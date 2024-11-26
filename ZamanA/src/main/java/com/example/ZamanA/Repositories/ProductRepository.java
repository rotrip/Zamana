package com.example.ZamanA.Repositories;

import com.example.ZamanA.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
