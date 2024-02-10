package org.fastrackit;

public class DemoShop {
    public static void main(String[] args) {
        System.out.println(" - = Demo Shop = -");
        System.out.println("1. User can login with valid credentials.");
        Page page = new Page();
        page.openHomePage();
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
        page.openHomePage();
        ProductCards cards= new ProductCards();
        Product awesomeGraniteChips = cards.getProductByName("Awesome Granite Chips");
        System.out.println("Product is: " + awesomeGraniteChips.getTitle());
        awesomeGraniteChips.ClickOnTheProductCartIcon();

        System.out.println("------------------------");
        System.out.println("3. User can navigate to Home Page from Wishlist Page. ");
        page.openHomePage();
        header.clickOnTheWishlistIcon();
        String pageTitle = page.getPageTitle();
        System.out.println("Expected to be on the Wishlist page. Title is:  " + pageTitle);
        header.clickOnTheShoppingBagIcon();
        pageTitle = page.getPageTitle();
        System.out.println("Expected to be on the Home page. Title is:  " + pageTitle);

        System.out.println("------------------------");
        System.out.println("4. User can navigate to Home Page from Cart Page. ");
        page.openHomePage();
        header.clickOnTheCartIcon();
        pageTitle = page.getPageTitle();
        System.out.println("Expected to be on the Cart page. Title is: " + pageTitle);
        header.clickOnTheShoppingBagIcon();
        pageTitle = page.getPageTitle();
        System.out.println("Expected to be on the Home page. Title is: " + pageTitle);
    }
}