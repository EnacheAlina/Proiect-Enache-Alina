package org.fastrackit;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.fastrackit.DataProvider.UserAndProductDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

@Severity(SeverityLevel.CRITICAL)
@Feature("Users can add products to cart.")

public class ProductsAndUsersInteractionTest {

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
    @Test(dataProviderClass = UserAndProductDataProvider.class, dataProvider = "userAndProduct")
    public void logged_in_user_can_add_a_product_to_cart(ValidAccount account, ProductData productData) {
        header.clickOnTheLoginButton();
        modal.typeInUsername(account.getUser());
        modal.typeInPassword(account.getPassword());
        modal.clickOnTheLogingButton();
        productData.getProduct().clickOnTheProductCartIcon();
        header.clickOnTheCartIcon();
        assertFalse(cartPage.isEmptyCartMessageDisplayed());
    }
    @Test(dataProviderClass = UserAndProductDataProvider.class, dataProvider = "userAndProduct")
    public void when_multiple_users_navigates_to_cart_page_empty_cart_page_is_displayed(ValidAccount account, ProductData productData) {
        header.clickOnTheCartIcon();
        assertEquals(cartPage.getEmptyCartPage(), "How about adding some products in your cart?");
    }
}
