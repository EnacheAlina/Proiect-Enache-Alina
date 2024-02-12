package org.fastrackit;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Page {
    public static final String URL = "https://fasttrackit-test.netlify.app/#/";
    private final SelenideElement pageTitle= $(".subheader-container .text-muted");

    @Step("Open Demo shop page.")
    public void openHomePage() {
        System.out.println("Opening: " + URL);
        open(URL);
    }
        public String getPageTitle() {
            return pageTitle.text();
        }
}
