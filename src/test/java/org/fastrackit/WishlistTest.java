package org.fastrackit;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//@Test(dependsOnGroups = "AuthentificationTest")
public class WishlistTest {
    Page page = new Page();
    Header header = new Header();

    @BeforeClass
    public void setup() {
        page.openHomePage();
    }
    @AfterMethod
    public void cleanup() {
        Footer footer = new Footer();
        footer.clickToReset();
    }

    @Test
    public void user_can_navigate_to_Wishlist_Page() {
        header.clickOnTheWishlistIcon();
        assertEquals(page.getPageTitle(), "Wishlist", "Expected to be on the Wishlist Page.");
    }
        @Test
        public void user_can_navigate_to_Home_Page_from_Wishlist_Page() {
            header.clickOnTheWishlistIcon();
            header.clickOnTheShoppingBagIcon();
            assertEquals(page.getPageTitle(), "Products", "Expected to be on the Products Page.");
        }
    }
