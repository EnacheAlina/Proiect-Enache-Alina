package org.fastrackit.DataProvider;
import org.testng.annotations.DataProvider;
import static org.fastrackit.DataProvider.ProductsDataProvider.agc;
import static org.fastrackit.DataProvider.ProductsDataProvider.ich;

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
