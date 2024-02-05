package org.fastrackit;

public class Product {

    private final String title;
    public Product(String productTitle) {
        this.title= productTitle;
    }

    public String getTitle() {
        return title;
    }
    public void ClickOnTheProductCartIcon(){
        System.out.println("Click on the Cart icon.");
    }
}
