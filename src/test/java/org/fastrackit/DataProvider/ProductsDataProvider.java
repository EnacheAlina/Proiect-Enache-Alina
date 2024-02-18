package org.fastrackit.DataProvider;
import org.fastrackit.ProductData;
import org.testng.annotations.DataProvider;

public class ProductsDataProvider {

   static ProductData agc = new ProductData("1", "Awesome Granite Chips", "$15.99");
    static ProductData ich = new ProductData("2", "Incredible Concrete Hat", "$7.99");
    @DataProvider(name = "products")
    public Object[][] getCredentials() {

        return new Object[][]{
                {agc},
                {ich}
        };
    }
    public ProductData getAgc() {
        return agc;
    }

    public ProductData getIch() {
        return ich;
    }
}