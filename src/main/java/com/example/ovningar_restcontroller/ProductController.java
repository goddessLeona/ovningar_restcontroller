package com.example.ovningar_restcontroller;

import com.example.ovningar_restcontroller.model.Product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

@GetMapping
    public List<Product> getAll(){
        return productService.getAllProducts();
}

@GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        Product product = productService.getProductById(id);

        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
}

@PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        if(product == null){
            return ResponseEntity.badRequest().build();
        }
        productService.addProduct(product);
        return ResponseEntity.ok(product);
}

@DeleteMapping
    public ResponseEntity<Long> deleteProduct(@RequestParam long id){

        if(productService.deleteProduct(id)){
            return ResponseEntity.ok(id);
        }else{
            return ResponseEntity.notFound().build();
        }
}

@PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById (@PathVariable Long id, @RequestBody Product updatedProduct){

        Product product = productService.updateProduct(id, updatedProduct);

        if(product != null){
            return ResponseEntity.ok(product);
        }else{
            return ResponseEntity.notFound().build();
        }

}

@GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductByName(@RequestParam String name) {

    List<Product> products = productService.searchProductsByName(name);

    if (products.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(products);
}


}
