package com.niit.jpa.C13S1PC1JPA.Service;

import com.niit.jpa.C13S1PC1JPA.Domain.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);
    public List<Product> getAllProduct();
    public Product updateProduct(Product product,int productId);
    public boolean deleteProductById(int productId);
}
