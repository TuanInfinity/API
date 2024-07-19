package com.example.demo.dto;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tuan Infinity on 7/18/2024 20:51:29
 *
 * @author Tuan Infinity
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailDTO {
    private Long id;

    private Double price;

    private Integer size;

    private String color;

    public static ProductDetailDTO productdetailConvertToProductDetailDTO(ProductDetail productDetail) {
        ProductDetailDTO productDeailDTOdto = ProductDetailDTO.builder()
                .id(productDetail.getId())
                .price(productDetail.getPrice())
                .size(productDetail.getSize())
                .color(productDetail.getColor())
                .build();
        return productDeailDTOdto;
    }
}
