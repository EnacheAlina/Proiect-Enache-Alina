package org.fastrackit.DataProvider;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.fastrackit.*;
import org.fastrackit.config.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AuthenticationUserDataProvider {
    static ValidAccount dino = new ValidAccount("dino", "choochoo");
    static ValidAccount turtle = new ValidAccount("turtle", "choochoo");
    static ValidAccount beetle = new ValidAccount("beetle", "choochoo");

    @DataProvider(name = "validCredentials")

    public Object[][] getCredentials() {
        return new Object[][]{
                {dino},
                {turtle},
                {beetle}
        };
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getInvalidCredentials() {
        InvalidAccount locked = new InvalidAccount("locked", "choochoo", "The user has been locked out.");
        InvalidAccount unknownUser = new InvalidAccount("unknown", "choochoo", "Incorrect username or password!");
        InvalidAccount wrongPass = new InvalidAccount("beetle", "wrongpassword", "Incorrect username or password!");
        InvalidAccount noPassword = new InvalidAccount("beetle", "", "Please fill in the password!");
        return new Object[][]{
                {locked},
                {unknownUser},
                {wrongPass},
                {noPassword}
        };
    }
}