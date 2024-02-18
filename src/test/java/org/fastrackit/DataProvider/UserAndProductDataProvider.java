package org.fastrackit.DataProvider;

import org.testng.annotations.DataProvider;

import static org.fastrackit.DataProvider.ProductsDataProvider.agc;
import static org.fastrackit.DataProvider.ProductsDataProvider.ich;
import static org.testng.Assert.assertEquals;

public class UserAndProductDataProvider {
    @DataProvider(name = "userAndProduct")
    public Object[][] getUserAndProduct() {
        return new Object[][]{
                {AuthenticationUserDataProvider.beetle, agc},
                {AuthenticationUserDataProvider.beetle, ich},
                {AuthenticationUserDataProvider.turtle, agc},
                {AuthenticationUserDataProvider.dino, agc},

        };
    }
}
//
//        @DataProvider(name = "userAndProducts")
//        public Object[][] getUsersAndProducts() {
//            List<ProductData> products = new ArrayList<>();
//            products.add(agc);
//            products.add(ich);
//
//            return new Object[][] {
//                    {AuthenticationDataProvider.beetle, products},
//                    {AuthenticationDataProvider.beetle, products},
//                    {AuthenticationDataProvider.turtle, products},
//                    {AuthenticationDataProvider.dino, products},
//            };
//        }
//    }
