package org.fastrackit.DataProvider;

import org.testng.annotations.DataProvider;

public class AuthenticationDataProvider {
    @DataProvider(name = "validCredentials")
    public Object[][] getCredentials() {
        return new Object[][] {
                {"dino", "choochoo"},
                {"turtle", "choochoo"},
                {"beetle", "choochoo"}
        };
    }
        @DataProvider(name = "invalidCredentials")
        public Object[][] getInvalidCredentials() {
            return new Object[][] {
                    {"locked", "choochoo"},
                    {"unknown", "choochoo"},
                    {"beetle", "wrongpassword"}
            };
        }
}
