package org.fastrackit;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Footer {
    private final SelenideElement resetStateButton = $(".fa-undo");

    @Step("Reset app state.")
    public void clickToReset() {
        resetStateButton.click();
        System.out.println("Resetting page to default. . .");
    }
}
