package com.example.ZamanA.Services;

import com.example.ZamanA.Models.Product;
import com.example.ZamanA.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product newProduct) {
        System.out.println("Received Product: " + newProduct);
        return productRepository.save(newProduct);
    }
}
