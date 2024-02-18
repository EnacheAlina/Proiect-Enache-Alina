package org.fastrackit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductCards {
    private final ElementsCollection cards = $$(".card");
    private final SelenideElement sortButton = $(".sort-products-select");
    private final SelenideElement sortAZ = $("option[value=az]");
    private final SelenideElement sortZA = $("option[value=za]");
    private final SelenideElement sortLoHi = $("option[value=lohi]");
    private final SelenideElement sortHiLo = $("option[value=hilo]");

    public ProductCards() {
    }
    public void clickOnTheSortButton() {
        this.sortButton.click();
    }

    public void clickOnTheAZSortButton() {this.sortAZ.click();
    }
    public void clickOnTheZASortButton() {
        this.sortZA.click();
    }

    public void clickOnTheSortByPriceLoHi() {
        this.sortLoHi.click();
    }

    public void clickOnTheSortByPriceHiLo() {
        this.sortHiLo.click();
    }

    public Product getFirstProductInList() {
        SelenideElement first = cards.first();
        return new Product(first);
    }

        public Product getLastProductInList() {
        SelenideElement last = cards.last();
        return new Product(last);
    }
    public Product getProductById(String productId) {
        for (SelenideElement product : cards) {
            if (product.$(".card-link").getAttribute("href").endsWith("/" + productId)) {
                return new Product(product);
            }
        }
        return null;
    }
}

