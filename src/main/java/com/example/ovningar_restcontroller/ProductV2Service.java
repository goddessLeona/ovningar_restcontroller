package com.example.ovningar_restcontroller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductV2Service {

    private final List<ProductV2> products = new ArrayList<>();
    private long nextId = 1;

    // Lägg till några exempelprodukter i konstruktorn
    public ProductV2Service() {

        ProductV2 laptop = new ProductV2();
        laptop.setId(nextId++);
        laptop.setName("Laptop");
        laptop.setDescription("Kraftfull bärbar dator");
        laptop.setPrice(12000.0);
        laptop.setCategory("Electronics");
        products.add(laptop);

        ProductV2 phone = new ProductV2();
        phone.setId(nextId++);
        phone.setName("Mobiltelefon");
        phone.setDescription("Smartphone med bra kamera");
        phone.setPrice(8000.0);
        phone.setCategory("phone");
        products.add(phone);

        ProductV2 headset = new ProductV2();
        headset.setId(nextId++);
        headset.setName("Headset");
        headset.setDescription("Trådlöst headset med brusreducering");
        headset.setPrice(1500.0);
        headset.setCategory("audio");
        products.add(headset);
    }

    // Hämta alla produkter
    public List<ProductV2> getAllProducts() {
        return products;
    }

    // Hämta en specifik produkt med ID
    public ProductV2 getProductById(Long id) {
        for (ProductV2 product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    // Lägg till en ny produkt
    public ProductV2 addNewProduct(ProductV2 product){
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    // Uppdatera en befintlig produkt
    public ProductV2 updateProduct(Long id, ProductV2 updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            com.example.ovningar_restcontroller.model.Product product = products.get(i);
            if (product.getId().equals(id)) {
                updatedProduct.setId(id);
                products.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        return null;
    }

    // Ta bort en produkt
    public boolean deleteProduct(Long id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<ProductV2> searchProductsByName(String name) {
        List<ProductV2> result = new ArrayList<>();
        for (ProductV2 product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

}
