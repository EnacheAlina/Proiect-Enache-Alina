
package org.fastrackit;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.fastrackit.DataProvider.AuthenticationUserDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

    public class WishlistTests {

        Page page = new Page();
        Header header = new Header();
        ModalDialog modal = new ModalDialog();

        CartPage cartPage = new CartPage();
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
        @Description("Users can navigate to Wishlist Page")
        @Severity(SeverityLevel.CRITICAL)
        @Owner("Alina Enache")
        @Issue("DMS-001")
        @Link(name = "Fastrackit", url = "https://recruit-me.it/moodle/mod/url/view.php?id=10630")
        @Story("Users can navigate to Wishlist Page from Homepage")
        @Test(dataProvider = "validCredentials", dataProviderClass = AuthenticationUserDataProvider.class)

        public void users_can_navigate_to_Wishlist_Page(ValidAccount account) {
            header.clickOnTheWishlistIcon();
            assertEquals(page.getPageTitle(), "Wishlist", "Expected to be on the Wishlist Page.");
        }

        @Description("Users can navigate to Home Page from Wishlist Page")
        @Severity(SeverityLevel.CRITICAL)
        @Owner("Alina Enache")
        @Issue("DMS-001")
        @Link(name = "Fastrackit", url = "https://recruit-me.it/moodle/mod/url/view.php?id=10630")
        @Story("Users can navigate to Home page from Wishlist Page")


        @Test(dataProvider = "validCredentials", dataProviderClass = AuthenticationUserDataProvider.class)
        public void users_can_navigate_to_Home_Page_from_Wishlist_Page(ValidAccount account) {
            header.clickOnTheWishlistIcon();
            header.clickOnTheShoppingBagIcon();
            assertEquals(page.getPageTitle(), "Products", "Expected to be on the Products Page.");
        }
    }