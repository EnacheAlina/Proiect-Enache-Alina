package org.fastrackit.DataProvider;

import org.fastrackit.*;

import org.testng.annotations.DataProvider;

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