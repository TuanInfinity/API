package com.example.demo.dto;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Tuan Infinity on 7/18/2024 20:51:18
 *
 * @author Tuan Infinity
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductDTO {
    private Long id; //khóa chính;

    private String productname; // tên sản phẩm;

    private LocalDateTime createat; //ngày tạo;

    private List<ProductDetailDTO> productDetailDTOS;

    public static ProductDTO productConvertToProductDTO(Product p) {
        ProductDTO pdto = ProductDTO.builder()
                .id(p.getId())
                .productname(p.getProductname())
                .productDetailDTOS(p.getProductDetails().stream().map(ProductDetailDTO::productdetailConvertToProductDetailDTO).toList())
                .createat(p.getCreateat())
                .build();
        return pdto;
    }
}
