package com.example.ovningar_restcontroller;

import com.example.ovningar_restcontroller.model.Product;

public class ProductV2 extends Product {

    private String category;

    public ProductV2(Long id, String name, String description, double price, String category) {
        super(id, name, description, price);
        this.category = category;
    }

    public ProductV2() {

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
