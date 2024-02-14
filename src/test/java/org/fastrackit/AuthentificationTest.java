package org.fastrackit;

import io.qameta.allure.*;
import org.fastrackit.DataProvider.AuthenticationDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups="AuthentificationTest")

public class AuthentificationTest {
    Page page = new Page();
    Header header = new Header();
    ModalDialog modal = new ModalDialog();

    @BeforeClass
    public void setup() {
        page.openHomePage();
    }

    @AfterMethod
    public void cleanup() {
        Footer footer = new Footer();
        footer.clickToReset();
    }

    @Description("User turtle can login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Enache")
    @Issue("DMS-001")
    @Link(name = "Fastrackit", url = "https://recruit-me.it/moodle/mod/url/view.php?id=10630")
    @Story("Login with valid credentials")


    @Test(dataProvider = "validCredentials", dataProviderClass = AuthenticationDataProvider.class)
    public void valid_user_can_login_with_valid_credentials(String user, String pass) {
        header.clickOnTheLoginButton();
        modal.typeInUsername(user);
        modal.typeInPassword(pass);
        modal.clickOnTheLogingButton();
        assertEquals(header.getGreetingsMessage(), "Hi " + user + "!", "Logged in with valid user, expected greetings message to be Hi. " + user + "!");
    }
    @Test(dataProvider = "invalidCredentials", dataProviderClass = AuthenticationDataProvider.class, description = "User cannot login with invalid credentials. ")
    public void non_functional_authentication(String user, String pass) {
        header.clickOnTheLoginButton();
        modal.typeInUsername(user);
        modal.typeInPassword(pass);
        modal.clickOnTheLogingButton();
        boolean errorMessageVisible = modal.isErrorMessageVisible();
        modal.clickToCloseModal();
        assertTrue(errorMessageVisible, "Error message is shown when invalid credentials used for login");
    }
}