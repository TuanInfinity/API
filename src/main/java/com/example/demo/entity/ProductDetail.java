package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tuan Infinity on 7/18/2024 20:23:29
 *
 * @author Tuan Infinity
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "productdetail")

public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    private Double price;

    private Integer size;

    private String color;
}
