package org.fastrackit;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsAddingTests {
    Page page = new Page();
    Header header = new Header();
    CartPage cartPage = new CartPage();

    @BeforeClass
    public void setup() {
        page.openHomePage();
    }

    @AfterMethod
    public void cleanup() {
        Footer footer = new Footer();
        footer.clickToReset();
    }

    @Epic("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("User can Login to DemoShop App.")

    @Test
    public void user_can_add_product_to_cart_from_product_cards() {
        Product product = new Product("9");
        product.clickOnTheProductCartIcon();
        assertTrue(header.isShoppingBadgeVisible());
        String badgeValue = header.getShoppingCartBadgeValue();
        assertEquals(badgeValue, "1", "After adding one product to cart, badge shows 1.");
    }

    @Test
    public void user_can_add_two_products_to_cart_from_product_cards() {
        Product product = new Product("9");
        product.clickOnTheProductCartIcon();
        product.clickOnTheProductCartIcon();
        assertTrue(header.isShoppingBadgeVisible());
        String badgeValue = header.getShoppingCartBadgeValue();
        assertEquals(badgeValue, "2", "After adding two products to cart, badge shows 2.");
    }
}



