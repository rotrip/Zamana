package com.example.ZamanA.Controllers;

import com.example.ZamanA.Models.Product;
import com.example.ZamanA.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductByID(@PathVariable Long id){
        System.out.println("returned the details");
        return productService.getProductById(id);
    }

    @PostMapping("/addproduct")
    public ResponseEntity addProduct(@RequestBody Product newProduct){
        Product addedProduct=productService.addProduct(newProduct);
        return ResponseEntity.ok(addedProduct);
    }


}
