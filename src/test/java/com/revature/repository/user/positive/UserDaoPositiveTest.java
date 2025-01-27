package com.revature.repository.positive;
import com.revature.planetarium.entities.User;
import com.revature.planetarium.exceptions.UserFail;
import com.revature.service.parent.UserServiceTest;
import com.revature.repository.parent.UserDaoTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.sqlite.SQLiteException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static com.revature.planetarium.utility.JavalinSetup.userService;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class UserDaoPositiveTest extends UserDaoTest {

    private User positiveUser;
    private String positiveUsername;

    @Parameter
    public int userId;

    @Parameter(1)
    public String username;

    @Parameter(2)
    public String password;

    @Parameter(3)
    public String expectedExceptionMessage;

    @Parameters
    public static Collection<Object> inputs(){
        return Arrays.asList(new Object[][]{
                {0, "Super_man-2001", "Krypton-was_2000","Account Created Successfully"},
                {0, "NewUser", "Krypton-was_2000","Account Created Successfully"},
        });
    }


    @Before
    public void positiveSetup() throws SQLiteException {
        positiveUser = new User(userId, username, password);
           positiveUsername = "Batman";
    }
    @Test
    public void daoCreateUserPositiveTest(){
    Optional<User> response = userDao.createUser(positiveUser);
    Assert.assertTrue(response.isPresent());
    Assert.assertNotEquals(0, response.get().getId());

        //Mockito.when(userDao.createUser(positiveUser)).thenReturn(Optional.empty());
      // UserFail userFail = Assert.assertThrows(UserFail.class, ()->{userService.createUser(positiveUser);});
    }

    @Test
    public void daoFindUserByUsernamePositiveTest(){
        Optional<User> result = userDao.findUserByUsername(positiveUsername);
        Assert.assertTrue(result.isPresent());
    }

}
