package com.example.demo.controller;

import com.example.demo.repo.ProductDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tuan Infinity on 7/18/2024 20:31:57
 *
 * @author Tuan Infinity
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/v1/product-detail")
@RequiredArgsConstructor

public class ProductDetailController {
    private final ProductDetailRepository productDetailRepository;

    @GetMapping("get-all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(productDetailRepository.findAll(), HttpStatus.OK);
    }
}
