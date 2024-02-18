package org.fastrackit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header {

    private final SelenideElement loginButton = $(".navbar .fa-sign-in-alt");
    private final SelenideElement greetingsElement= $(".navbar-text span span");
    private final SelenideElement wishlistButton = $(".navbar .fa-heart");
    private final SelenideElement cartIcon= $(".fa-shopping-cart");
    private final SelenideElement shoppingCartBadge= $(".shopping_cart_badge");
    private final ElementsCollection shoppingCartBadges= $$(".shopping_cart_badge");
    private final SelenideElement homePageButton = $("[data-icon=shopping-bag]");

    @Step("Click on the Login button.")
    public void clickOnTheLoginButton(){
        loginButton.click();
        System.out.println("Click on the Login button.");
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
        homePageButton.click();
    }

    @Step("Click on the Cart Icon Button.")
    public void clickOnTheCartIcon() {
        System.out.println("Click on the Cart icon");
        cartIcon.click();
    }
    public String getShoppingCartBadgeValue () {
        return this.shoppingCartBadge.text();
    }

    public boolean isShoppingBadgeVisible() {
        return !this.shoppingCartBadges.isEmpty();
    }

    }

