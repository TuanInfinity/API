package com.example.demo.repo;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tuan Infinity on 7/16/2024 20:44:20
 *
 * @author Tuan Infinity
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
