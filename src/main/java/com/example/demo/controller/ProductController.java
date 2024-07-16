package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by Tuan Infinity on 7/16/2024 20:45:35
 *
 * @author Tuan Infinity
 */
@RestController // cấu hình đây là 1 controller trả về đối tượng là file JSon;
@RequestMapping("api/v1/product") // tạo base API cho lớp controller;
@RequiredArgsConstructor // DI các phụ thuộc vào đối tượng private final giống @Autowired

public class ProductController {
    private final ProductRepository repository;

    @GetMapping("get-all")
    public ResponseEntity<?> getAll() {

        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("search/{id}")
    public ResponseEntity<?> search(
            //  @RequestParam(required = false, defaultValue = "1") Long id
            @PathVariable(name = "id") Long id
    ) {
/**
 * Truyền dữ liệu qua đường dẫn bao gồm 2 loại:
 * Loại 1: Param : ?id=1
 * Loại 2: Path Variable: /1
 */
//        try {
//            Long a = id;
//        }catch (Exception e){
//            throw new Exception("Nhập số vào: ")
//        }
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    //Các request cơ bản
    //Post là thêm
    //Get lấy dữ liệu
    //Put update
    //Patch update 1 phần dữ liệu
    //Delete xóa
    @PostMapping("save") // Cấu hình đường dẫn lưu dữ liệu CSDL
    public ResponseEntity<?> save(
            @RequestBody Product product // Lấy dữ liệu từ Body của request

    ) {
        return new ResponseEntity<>(repository.save(product), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id

    ) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>("Không có sản phẩm này!", HttpStatus.BAD_REQUEST);
        }
        repository.delete(product.get());
        String message = "OKE!";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
