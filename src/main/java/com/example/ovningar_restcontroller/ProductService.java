package com.example.ovningar_restcontroller;

import org.springframework.stereotype.Service;
import com.example.ovningar_restcontroller.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private long nextId = 1;

    // Lägg till några exempelprodukter i konstruktorn
    public ProductService() {
        // Skapa några produkter och lägg till dem i products-listan
        Product laptop = new Product();
        laptop.setId(nextId++);
        laptop.setName("Laptop");
        laptop.setDescription("Kraftfull bärbar dator");
        laptop.setPrice(12000.0);
        products.add(laptop);

        Product phone = new Product();
        phone.setId(nextId++);
        phone.setName("Mobiltelefon");
        phone.setDescription("Smartphone med bra kamera");
        phone.setPrice(8000.0);
        products.add(phone);

        Product headset = new Product();
        headset.setId(nextId++);
        headset.setName("Headset");
        headset.setDescription("Trådlöst headset med brusreducering");
        headset.setPrice(1500.0);
        products.add(headset);
    }

    // Hämta alla produkter
    public List<Product> getAllProducts() {
        return products;
    }

    // Hämta en specifik produkt med ID
    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    // Lägg till en ny produkt
    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    // Uppdatera en befintlig produkt
    public Product updateProduct(Long id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
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

    public List<Product> searchProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

}


