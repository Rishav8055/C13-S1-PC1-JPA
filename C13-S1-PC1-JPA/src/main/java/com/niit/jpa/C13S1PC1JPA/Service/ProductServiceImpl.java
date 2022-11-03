package com.niit.jpa.C13S1PC1JPA.Service;

import com.niit.jpa.C13S1PC1JPA.Domain.Product;
import com.niit.jpa.C13S1PC1JPA.Repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        Optional<Product> optionalProduct=productRepo.findById(productId);
        if (optionalProduct.isEmpty()){
            return null;
        }
        Product existingProduct=optionalProduct.get();
        if (product.getProductName()!=null){
            existingProduct.setProductName(product.getProductName());
        }
        if (product.getProductDescription()!=null){
            existingProduct.setProductDescription(product.getProductDescription());
        }
        if (product.getAmountInStock()!=0){
            existingProduct.setAmountInStock(product.getAmountInStock());
        }

        return productRepo.save(product);
    }

    @Override
    public boolean deleteProductById(int productId) {
        productRepo.deleteById(productId);
        return true;
    }
}
