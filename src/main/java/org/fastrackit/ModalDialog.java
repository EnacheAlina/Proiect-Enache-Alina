package org.fastrackit;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ModalDialog {

    private final SelenideElement username= $("#user-name");
    private final SelenideElement password = $("#password");
    private final SelenideElement loginButton = $(".modal-dialog .fa-sign-in-alt");

    @Step("Type in username")
    public void typeInUsername(String user) {
        System.out.println("Click on the Username field. ");
        username.click();
        System.out.println("Type in " + user);
        username.type(user);
    }
    @Step("Type in password")
    public void typeInPassword(String pass) {
        System.out.println("Click on the Password field. ");
        password.click();
        System.out.println("Type in " + pass);
        password.type(pass);
    }
    @Step("Click on the login button.")
    public void clickOnTheLogingButton() {
        System.out.println("Click on the Login button.");
        loginButton.click();
    }
}
