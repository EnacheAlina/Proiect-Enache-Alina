package org.fastrackit;

public class ProductData {
    private final String id;
    private final String name;
    private final String price;
    private final Product product;


    public ProductData(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.product = new Product(id);
    }

    public Product getProduct() {
        return product;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
        @Override
     public String toString() {
            return this.name;
        }
    }

