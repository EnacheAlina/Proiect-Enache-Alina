package org.fastrackit;

import java.util.ArrayList;
import java.util.List;

public class ProductCards {
    private List<Product> products = new ArrayList<>();

    public ProductCards() {
        this.products.add(new Product("Awesome Granite Chips"));
        this.products.add(new Product("Awesome Metal Chair"));
    }
    public Product getProductByName(String productName) {
     for (Product product : products) {
         if (product.getTitle().equals(productName))
             return product;
     }
     return null;
    }
}
