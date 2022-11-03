package com.niit.jpa.C13S1PC1JPA.Controller;

import com.niit.jpa.C13S1PC1JPA.Domain.Product;
import com.niit.jpa.C13S1PC1JPA.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/v1")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/product/post")
    public ResponseEntity<?>  saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }
    @GetMapping("/product")
    public  ResponseEntity<?> getProductDetail(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.FOUND);
    }
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId){
        return new ResponseEntity<>(productService.deleteProductById(productId),HttpStatus.OK);
    }
}
