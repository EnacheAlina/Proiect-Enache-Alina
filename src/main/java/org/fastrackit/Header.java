package org.fastrackit;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Header {

    private final SelenideElement loginButton = $(".navbar .fa-sign-in-alt");
    private final SelenideElement greetingsElement= $(".navbar-text span span");
    private final SelenideElement wishlistButton = $(".navbar .fa-heart");
    private final SelenideElement cartIcon= $(".fa-shopping-cart");
    private final SelenideElement homePageButton = $("[data-icon=shopping-bag]");

    public void clickOnTheLoginButton(){
        loginButton.click();
        System.out.println("Click on the login button.");
    }
    public String getGreetingsMessage() {
        return greetingsElement.text();
    }
    public void clickOnTheWishlistIcon() {
        System.out.println("Click on the Wishlist button.");
        wishlistButton.click();
    }
    public void clickOnTheShoppingBagIcon() {
        System.out.println("Click on the Shopping bag icon. ");
    }
    public void clickOnTheCartIcon() {
        System.out.println("Click on the Cart icon");
        cartIcon.click();
    }
}
