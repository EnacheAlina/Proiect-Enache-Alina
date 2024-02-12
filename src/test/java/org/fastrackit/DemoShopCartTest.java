package org.fastrackit;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
@Epic("Login")
@Severity(SeverityLevel.CRITICAL)
@Feature("User can Login to Demoshop app")


public class DemoShopCartTest {
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

    @Test
    public void user_can_navigate_to_CartPage() {
        header.clickOnTheCartIcon();
        assertEquals(page.getPageTitle(), "Your cart", "Expected to be on the Cart Page.");
    }

    @Test
    public void user_can_navigate_to_Home_Page_from_CartPage() {
        header.clickOnTheCartIcon();
        header.clickOnTheShoppingBagIcon();
        assertEquals(page.getPageTitle(), "Products", "Expected to be on the Products Page.");
    }

    @Test
    public void user_can_add_product_to_cart_from_product_cards() {
        Product product = new Product("9");
        product.clickOnTheProductCartIcon();
        assertTrue(header.isShoppingBadgeVisible());
        String badgeValue = header.getShoppingCartBadgeValue();
        assertEquals(badgeValue, "1", "After adding one product to cart, badge shows 1. ");
    }

    @Test
    public void user_can_add_two_products_to_cart_from_product_cards() {
        Product product = new Product("9");
        product.clickOnTheProductCartIcon();
        product.clickOnTheProductCartIcon();
        assertTrue(header.isShoppingBadgeVisible());
        String badgeValue = header.getShoppingCartBadgeValue();
        assertEquals(badgeValue, "2", "After adding two product to cart, badge shows 2. ");
    }
}