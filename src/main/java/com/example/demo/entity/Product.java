package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Tuan Infinity on 7/16/2024 20:17:07
 *
 * @author Tuan Infinity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
/**
 * Đây là ánh xạ của bảng sản phầm trong CSDL;
 */
public class Product {
    // Tên thuộc tính của đối tượng chỉ viết thường;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //khóa chính;

    private String productname; // tên sản phẩm;

    private LocalDateTime createat; //ngày tạo;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER) //map ở trường ProductDetail
//    @JsonIgnore
    private List<ProductDetail> productDetails;
}
