package com.revature.planetarium.repository.moon;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import com.revature.planetarium.entities.Moon;
import com.revature.planetarium.exceptions.MoonFail;
import com.revature.planetarium.exceptions.PlanetFail;
import com.revature.planetarium.utility.DatabaseConnector;


public class MoonDaoImp implements MoonDao {

 private boolean isValidImageType(byte[] imageData){
        System.out.println("imagedata: "+imageData );

        // Check if imageData is null or empty
        if (imageData == null || imageData.length == 0) {
            System.out.println("No image data provided.");
            return true; // Treat this as invalid if no image data is provided
        }

        try (InputStream is = new ByteArrayInputStream(imageData)){
            String mimeType = URLConnection.guessContentTypeFromStream(is);
            System.out.println(mimeType);
            return mimeType != null && (mimeType.equals("image/png") || mimeType.equals("image/jpeg"));
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public Optional<Moon> createMoon(Moon moon) {


        if(!isValidImageType(moon.imageDataAsByteArray())){
            throw new MoonFail("Invalid file type");
        }

        if (moon.getMoonDescription().length() > 300) {
            throw new PlanetFail("Invalid description");
        }
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO moons (name, myPlanetId, image, description) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, moon.getMoonName());
            stmt.setInt(2, moon.getOwnerId());
            stmt.setBytes(3, moon.imageDataAsByteArray());
            stmt.setString(4,moon.getMoonDescription());

            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()) {
                    int newMoonId = rs.getInt(1);
                    moon.setMoonId(newMoonId);
                    System.out.println(moon.toString());
                    return Optional.of(moon);
                }
            }
        } catch (SQLException e) {
            System.out.println("test");
            throw new MoonFail(e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public Optional<Moon> readMoon(int id) {
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM moons WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Moon moon = new Moon();
                moon.setMoonId(rs.getInt("id"));
                moon.setMoonName(rs.getString("name"));
                moon.setOwnerId(rs.getInt("myPlanetId"));
                moon.setMoonDescription(rs.getString("description"));
                byte[] byteImageData = rs.getBytes("image");
                if (byteImageData != null){
                    String base64ImageData = Base64.getEncoder().encodeToString(byteImageData);
                    moon.setImageData(base64ImageData);
                }

                return Optional.of(moon);
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new MoonFail(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Moon> readMoon(String name) {
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM moons WHERE name = ?")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Moon moon = new Moon();
                moon.setMoonId(rs.getInt("id"));
                moon.setMoonName(rs.getString("name"));
                moon.setOwnerId(rs.getInt("myPlanetId"));
                moon.setMoonDescription(rs.getString("description"));
                byte[] byteImageData = rs.getBytes("image");

                if (byteImageData != null){
                    String base64ImageData = Base64.getEncoder().encodeToString(byteImageData);
                    moon.setImageData(base64ImageData);
                }

                return Optional.of(moon);
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new MoonFail(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Moon> readAllMoons() {
        List<Moon> moons = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM moons")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Moon moon = new Moon();
                moon.setMoonId(rs.getInt("id"));
                moon.setMoonName(rs.getString("name"));
                moon.setOwnerId(rs.getInt("myPlanetId"));
                byte[] byteImageData = rs.getBytes("image");
                if (byteImageData != null){
                    String base64ImageData = Base64.getEncoder().encodeToString(byteImageData);
                    moon.setImageData(base64ImageData);
                }
                moons.add(moon);
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new MoonFail(e.getMessage());
        }
        return moons;
    }

    @Override
    public List<Moon> readMoonsByPlanet(int planetId) {
        List<Moon> moons = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM moons WHERE myPlanetId = ?")) {
            stmt.setInt(1, planetId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Moon moon = new Moon();
                moon.setMoonId(rs.getInt("id"));
                moon.setMoonName(rs.getString("name"));
                moon.setOwnerId(rs.getInt("myPlanetId"));
                byte[] byteImageData = rs.getBytes("image");
                if (byteImageData != null){
                    String base64ImageData = Base64.getEncoder().encodeToString(byteImageData);
                    moon.setImageData(base64ImageData);
                }
                moons.add(moon);
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new MoonFail(e.getMessage());
        }
        return moons;
    }

    @Override
    public Optional<Moon> updateMoon(Moon moon) {
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE moons SET name = ?, myPlanetId = ? WHERE id = ?")) {
            stmt.setString(1, moon.getMoonName());
            stmt.setInt(2, moon.getOwnerId());
            stmt.setInt(3, moon.getMoonId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0 ? Optional.of(moon) : Optional.empty();
        } catch (SQLException e) {
            System.out.println(e);
            throw new MoonFail(e.getMessage());
        }
    }

    @Override
    public boolean deleteMoon(int id) {
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM moons WHERE id = ?")) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println(e);
            throw new MoonFail(e.getMessage());
        }
    }

    @Override
    public boolean deleteMoon(String name) {
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM moons WHERE name = ?")) {
            stmt.setString(1, name);
            int rowsDeleted = stmt.executeUpdate();
            if(rowsDeleted == 0){
                throw new MoonFail("Invalid moon name");
            }

            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println(e);
            throw new MoonFail(e.getMessage());
        }
    }
    
}
