package org.fastrackit;

public class DemoShop {
    public static void main(String[] args) {
        System.out.println(" - = Demo Shop = -");
        System.out.println("1. User can login with valid credentials.");
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        Header header = new Header();
        header.clickOnTheLoginButton();
        ModalDialog modal = new ModalDialog();
        modal.typeInUsername("dino");
        modal.typeInPassword("choochoo");
        modal.clickOnTheLogingButton();
        String greetingsMessage = header.getGreetingsMessage();
        boolean isLogged = greetingsMessage.contains("dino");
        System.out.println("Hi Dino is displayed in the header:" + isLogged);
        System.out.println("Greetings msg is: "+ greetingsMessage);

        System.out.println("------------------------");
        System.out.println("2. User can add product to cart from product cards. ");
        homePage.openHomePage();
        ProductCards cards= new ProductCards();
        Product awesomeGraniteChips = cards.getProductByName("Awesome Granite Chips");
        System.out.println("Product is: " + awesomeGraniteChips.getTitle());
        awesomeGraniteChips.ClickOnTheProductCartIcon();

        System.out.println("------------------------");
        System.out.println("3. User can navigate to Home Page from Wishlist Page. ");
        homePage.openHomePage();
        header.clickOnTheWishlistIcon();
        String url = header.getUrl();
        System.out.println("Expected to be on the Wishlist page. " + url);
        header.clickOnTheShoppingBagIcon();
        url = header.getUrl();
        System.out.println("Expected to be on the Home page. " + url);
    }
}