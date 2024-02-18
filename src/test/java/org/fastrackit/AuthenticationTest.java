package org.fastrackit;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.fastrackit.DataProvider.AuthenticationUserDataProvider;
import org.fastrackit.config.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups="AuthentificationTest")

public class AuthenticationTest extends Config {
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
        Selenide.refresh();
        Selenide.clearBrowserCookies();
        footer.clickToReset();
    }
    @Description("Users can login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Enache")
    @Issue("DMS-001")
    @Link(name = "Fastrackit", url = "https://recruit-me.it/moodle/mod/url/view.php?id=10630")
    @Story("Login with valid credentials")
    @Test(dataProvider = "validCredentials", dataProviderClass = AuthenticationUserDataProvider.class)
    public void valid_user_can_login_with_valid_credentials(ValidAccount account) {
        header.clickOnTheLoginButton();
        modal.typeInUsername(account.getUser());
        modal.typeInPassword(account.getPassword());
        modal.clickOnTheLogingButton();
        assertEquals(header.getGreetingsMessage(), account.getGreetingsMsg(), "Logged in with valid user, expected greetings message to be: " + account.getGreetingsMsg());
    }

    @Description("Users cannot login with invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Enache")
    @Issue("DMS-002")
    @Link(name = "Fastrackit", url = "https://recruit-me.it/moodle/mod/url/view.php?id=10630")
    @Story("Login users with invalid credentials")

    @Test(dataProvider = "invalidCredentials", dataProviderClass = AuthenticationUserDataProvider.class, description = "User cannot login with invalid credentials. ")
    public void non_functional_authentication(InvalidAccount account) {
        header.clickOnTheLoginButton();
        modal.typeInUsername(account.getUser());
        modal.typeInPassword(account.getPassword());
        modal.clickOnTheLogingButton();
        boolean errorMessageVisible = modal.isErrorMessageVisible();
        String errorMsg = modal.getErrorMsg();
        assertTrue(errorMessageVisible, "Error is diplayed");
        assertEquals(errorMsg, account.getErrorMsg());
    }
}