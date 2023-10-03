package com.springboot.product.controller;


import com.springboot.product.data.dto.ChangeProductNameDto;
import com.springboot.product.data.dto.ProductDto;
import com.springboot.product.data.dto.ProductResponseDto;
import com.springboot.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<ProductResponseDto> getProduct(Long number){
        ProductResponseDto productResponseDto = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto){
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductNameDto changeProductNameDto) throws Exception {
        ProductResponseDto productResponseDto = productService.changeProductName(changeProductNameDto.getNumber(), changeProductNameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception{
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
    }

    @GetMapping("/get")
    public ResponseEntity<List<ProductResponseDto>> getByPriceProduct(Integer price){
        List<ProductResponseDto> listProduct = productService.getByPriceProduct(price);

        return ResponseEntity.status(HttpStatus.OK).body(listProduct);
    }

    @GetMapping("/get+")
    public ResponseEntity<Page<ProductResponseDto>> getByNameProduct(String name, Pageable pageable){
        Page<ProductResponseDto> listProduct = productService.getByNameProduct(name,  pageable);

        return ResponseEntity.status(HttpStatus.OK).body(listProduct);
    }





}
