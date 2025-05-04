package com.example.ovningar_restcontroller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/products")
public class ProductV2Controller {

    private ProductV2Service ProductServiceV2;

    public ProductV2Controller(ProductV2Service productServiceV2) {
        this.ProductServiceV2 = productServiceV2;
    }

    @GetMapping
    public List<ProductV2> getAll(){
        return ProductServiceV2.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductV2> getProductById(@PathVariable long id){

        ProductV2 product = (ProductV2) ProductServiceV2.getProductById(id);

        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductV2> addProduct(@RequestBody ProductV2 product){

        if(product == null){
            return ResponseEntity.badRequest().build();
        }
        ProductServiceV2.addNewProduct(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductV2> updateProductById (@PathVariable Long id, @RequestBody ProductV2 updatedProduct){

        ProductV2 product = ProductServiceV2.updateProduct(id,updatedProduct);

        if(product != null){
            return ResponseEntity.ok(product);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping
    public ResponseEntity<Long> deleteProduct(@RequestParam long id){

        if(ProductServiceV2.deleteProduct(id)){
            return ResponseEntity.ok(id);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
