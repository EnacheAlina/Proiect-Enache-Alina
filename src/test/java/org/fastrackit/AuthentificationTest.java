package org.fastrackit;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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
        @Test(description = "User turtle can login with valid credentials.")
        @Description("User turtle can login with valid credentials")
        @Severity(SeverityLevel.CRITICAL)
        @Owner("Alina Enache")
        @Issue("DMS-001")
        @Link(name= "Fastrackit", url= "https://recruit-me.it/moodle/mod/url/view.php?id=10630")
        @Story("Login with valid credentials")
        public void user_turtle_can_login_with_valid_credentials() {
            header.clickOnTheLoginButton();
            modal.typeInUsername("turtle");
            modal.typeInPassword("choochoo");
            modal.clickOnTheLogingButton();
            assertEquals(header.getGreetingsMessage(), "Hi turtle!", "Logged in with turtle, expected message to be Hi turtle!");
        }

        @Test
        public void user_dino_can_login_with_valid_credentials() {
            header.clickOnTheLoginButton();
            modal.typeInUsername("dino");
            modal.typeInPassword("choochoo");
            modal.clickOnTheLogingButton();
            assertEquals(header.getGreetingsMessage(), "Hi dino!", "Logged in with dino, expected message to be Hi dino!");
        }

        @Test
        public void user_beetle_can_login_with_valid_credentials() {
            header.clickOnTheLoginButton();
            modal.typeInUsername("beetle");
            modal.typeInPassword("choochoo");
            modal.clickOnTheLogingButton();
            assertEquals(header.getGreetingsMessage(), "Hi beetle!", "Logged in with beetle, expected message to be Hi beetle!");
        }

    }
