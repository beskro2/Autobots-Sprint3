package com.revature.steps.hooks;

import com.revature.utility.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static com.revature.TestMain.driver;

public class Hooks {

    /*
        Instead of manually resetting the test database between
        runs we can use a hook and the setup class to automate
        the database reset process
     */

    @Before
    public void resetDatabase(){
        System.out.println("resetDatabase hook called");
        Setup.resetTestDatabase();
    }



}