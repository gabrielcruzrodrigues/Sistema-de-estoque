package org.example;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(){}

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double TotalValueInStock() {
        return this.getQuantity();
    }

    public void AddProducts(int quantity) {
        int x = getQuantity() + quantity;
        setQuantity(x);
    }

    public void RemoveProducts(int quantity) {
        int x = getQuantity() - quantity;
        setQuantity(x);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
