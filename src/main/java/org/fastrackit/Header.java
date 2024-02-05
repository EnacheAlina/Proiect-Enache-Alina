package org.fastrackit;

public class Header {

    public static final String URL = "https://fasttrackit-test.netlify.app/#/";
    private String url = URL;
    public void clickOnTheLoginButton(){
        System.out.println("Click on the login button.");
    }
    public String getGreetingsMessage() {
        return "Hello guest!";
    }
    public void clickOnTheWishlistIcon() {
        System.out.println("Click on the Wishlist button.");
        url = URL + "/#/wishlist";
    }
    public void clickOnTheShoppingBagIcon() {
        System.out.println("Click on the Shopping bag icon. ");
        url = URL;
    }
       public String getUrl() {
           return url;
    }

    public void clickOnTheCartIcon() {
        System.out.println("Click on the Cart icon");
        url = URL + "/#/cart";
    }
}
