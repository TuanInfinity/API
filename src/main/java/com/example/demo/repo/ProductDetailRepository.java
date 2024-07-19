package com.example.demo.repo;

import com.example.demo.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tuan Infinity on 7/18/2024 20:30:58
 *
 * @author Tuan Infinity
 */
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
