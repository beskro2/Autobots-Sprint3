package com.revature.planetarium.repository.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import com.revature.planetarium.entities.User;
import com.revature.planetarium.exceptions.UserFail;
import com.revature.planetarium.utility.DatabaseConnector;

public class UserDaoImp implements UserDao {

    @Override
    public Optional<User> createUser(User newUser) {
        try (Connection conn = DatabaseConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)){
            validation(newUser);
            stmt.setString(1, newUser.getUsername());
            stmt.setString(2, newUser.getPassword());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    newUser.setId(rs.getInt(1));
                    return Optional.of(newUser);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new UserFail(e.getMessage());
        }
        return Optional.empty();
    }

    private void validation(User newUser) throws SQLException{
        if (findUserByUsername(newUser.getUsername()).isPresent()){ // checks if the username exists
            throw new SQLException("Invalid username");
        }else if (newUser.getUsername().length() < 5 || newUser.getUsername().length() > 30){ // checks if the username meets the length constraint
            throw new SQLException("Invalid username");
        }else if (!newUser.getUsername().matches("^[a-zA-Z].*")){ // checks if the username starting char is any letter using regex (cap or lower)
            throw new SQLException("Invalid username");
        }else if (!newUser.getUsername().matches("^[a-zA-Z0-9_-]*$")) { // checks if the username supports lower case, upper case, numeric characters, underscores, and dashes
            throw new SQLException("Invalid username");
        }else if (newUser.getPassword().length() < 5 || newUser.getPassword().length() > 30) { // checks if the password meets the length constraint
            throw new SQLException("Invalid password");
        }else if (!newUser.getPassword().matches("^[a-zA-Z].*")){ // checks if the password starting char is any letter using regex (cap or lower)
            throw new SQLException("Invalid password");
        }else if (!newUser.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")){ // checks if the password contains at least one lower case, uppercase and number
            throw new SQLException("Invalid password");
        }else if (!newUser.getPassword().matches("^[a-zA-Z0-9_-]*$")){ // checks if the password supports underscores and dashes
            throw new SQLException("Invalid password");
        }
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?")) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    return Optional.of(user);
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            System.out.println(e);
            throw new UserFail(e.getMessage());
        }
    }


}
