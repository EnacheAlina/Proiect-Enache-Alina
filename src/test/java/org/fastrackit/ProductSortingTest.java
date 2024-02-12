package org.fastrackit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductSortingTest {
    Page page = new Page();
    ProductCards  productList = new ProductCards();

    @BeforeClass
    public void setup() {
        page.openHomePage();
    }
    @AfterMethod
    public void cleanup() {
        Footer footer = new Footer();
        footer.clickToReset();
    }
        @Test
     public void when_sorting_products_A_to_Z_products_are_sorted_alphabetically_ASC() {
        Product firstProductBeforeSort= productList.getFirstProductInList();
        Product lastProductBeforeSort= productList.getLastProductInList();
        productList.clickOnTheSortButton();
        productList.clickOnTheAZSortButton();
        Product firstProductAfterSort= productList.getFirstProductInList();
        Product lastProductAfterSort= productList.getLastProductInList();

        assertEquals(firstProductAfterSort.getTitle(),firstProductBeforeSort.getTitle());
        assertEquals(lastProductAfterSort.getTitle(),lastProductBeforeSort.getTitle());

    }
    @Test
    public void when_sorting_products_Z_to_A_products_are_sorted_alphabetically_DESC() {
        Product firstProductBeforeSort= productList.getFirstProductInList();
        Product lastProductBeforeSort= productList.getLastProductInList();
        productList.clickOnTheSortButton();
        productList.clickOnTheZASortButton();
        Product firstProductAfterSort= productList.getFirstProductInList();
        Product lastProductAfterSort= productList.getLastProductInList();

        assertEquals(firstProductAfterSort.getTitle(),lastProductBeforeSort.getTitle());
        assertEquals(lastProductAfterSort.getTitle(),firstProductBeforeSort.getTitle());
    }
    @Test
    public void when_sorting_products_by_price_low_to_high_products_are_sorted_by_price_low_to_high() {
        productList.clickOnTheSortButton();
        productList.clickOnTheSortByPriceLoHi();

        Product firstProductBeforeSort= productList.getFirstProductInList();
        Product lastProductBeforeSort= productList.getLastProductInList();
        productList.clickOnTheSortButton();
        productList.clickOnTheSortByPriceLoHi();
        Product firstProductAfterSort= productList.getFirstProductInList();
        Product lastProductAfterSort= productList.getLastProductInList();

        assertEquals(firstProductAfterSort.getPrice(),firstProductBeforeSort.getPrice());
        assertEquals(lastProductAfterSort.getPrice(),lastProductBeforeSort.getPrice());
    }
    @Test
    public void when_sorting_products_by_price_high_to_low_products_are_sorted_by_price_high_to_low() {
        productList.clickOnTheSortButton();
        productList.clickOnTheSortByPriceLoHi();

        Product firstProductBeforeSort= productList.getFirstProductInList();
        Product lastProductBeforeSort= productList.getLastProductInList();
        productList.clickOnTheSortButton();
        productList.clickOnTheSortByPriceHiLo();
        Product firstProductAfterSort= productList.getFirstProductInList();
        Product lastProductAfterSort= productList.getLastProductInList();

        assertEquals(firstProductAfterSort.getPrice(),lastProductBeforeSort.getPrice());
        assertEquals(lastProductAfterSort.getPrice(), firstProductBeforeSort.getPrice());
    }
}
