package org.fastrackit;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.fastrackit.DataProvider.ProductsDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartNavigationTests {
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
        Selenide.refresh();
        Selenide.clearBrowserCookies();
    }

    @Description("Users can navigate to CartPage")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Alina Enache")
    @Issue("DMS-003")
    @Link(name = "Fastrackit", url = "https://recruit-me.it/moodle/mod/url/view.php?id=10630")
    @Story("Users can navigate to CartPage")
    @Epic("Cart Page")
    @Feature("User can Login to DemoShop App.")

    @Test
    public void user_can_navigate_to_CartPage() {
        header.clickOnTheCartIcon();
        assertEquals(page.getPageTitle(), "Your cart", "Expected to be on the Cart Page.");
    }
    @Test()
    public void user_can_navigate_to_Home_Page_from_CartPage() {
        header.clickOnTheCartIcon();
        header.clickOnTheShoppingBagIcon();
        assertEquals(page.getPageTitle(), "Products", "Expected to be on the Products Page.");
    }

    @Test(dataProviderClass = ProductsDataProvider.class, dataProvider = "products")
    public void user_can_increment_the_amount_of_a_product_in_cart_page(ProductData productData) {
        productData.getProduct().clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        CartItem item = new CartItem(productData.getId());
        item.increaseAmount();
        assertEquals(item.getItemAmount(), "2");
    }
    @Test
    public void user_can_reduce_the_amount_of_a_product_in_cart_page() {
        Product product = new Product("9");
        product.clickOnTheProductCartIcon();
        product.clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        CartItem item = new CartItem("9");
        item.reduceAmount();
        assertEquals(item.getItemAmount(), "1");
    }
}



