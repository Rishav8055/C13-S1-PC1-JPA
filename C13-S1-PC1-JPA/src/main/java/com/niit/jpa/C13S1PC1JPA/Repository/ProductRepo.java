package com.niit.jpa.C13S1PC1JPA.Repository;

import com.niit.jpa.C13S1PC1JPA.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product ,Integer> {

    public List<Product> findByProductName(String productName);
    public List<Product> findByProductDescription(String productDescription);
}
