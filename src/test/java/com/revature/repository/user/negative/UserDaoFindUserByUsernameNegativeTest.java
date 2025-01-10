package com.revature.repository.user.negative;

import com.revature.planetarium.entities.User;
import com.revature.repository.user.parent.UserDaoTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class UserDaoFindUserByUsernameNegativeTest extends UserDaoTest {

    private String negativeUsername;

    @Before
    public void negativeSetup(){
        negativeUsername = "Joker";
    }

    @Test
    public void findUserByUsernameNegativeTest(){
        Optional<User> result = userDao.findUserByUsername(negativeUsername);
        Assert.assertFalse(result.isPresent());
    }

}
