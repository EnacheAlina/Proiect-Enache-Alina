package org.fastrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private SelenideElement emptyCartPageElement= $(".text-center");

    public CartPage() {
    }
    public String getEmptyCartPage() {
        return this.emptyCartPageElement.text();
    }
    public boolean isEmptyCartMessageDisplayed() {
        return emptyCartPageElement.isDisplayed();

    }
}
