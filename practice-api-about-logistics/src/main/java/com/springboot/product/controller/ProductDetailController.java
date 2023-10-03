package com.springboot.product.controller;


import com.springboot.product.data.dto.ProductDetailDto;
import com.springboot.product.data.dto.ProductDetailResponseDto;
import com.springboot.product.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product_detail")
public class ProductDetailController {


    private final ProductDetailService productDetailService;

    @Autowired
    public ProductDetailController(ProductDetailService productDetailService){
        this.productDetailService = productDetailService;

    }

    @GetMapping()
    public ResponseEntity<ProductDetailResponseDto> getProduct(Long id){
        ProductDetailResponseDto productDetailResponseDto = productDetailService.getProductDetail(id);

        return ResponseEntity.status(HttpStatus.OK).body(productDetailResponseDto);
    }

    @PostMapping()
    public ResponseEntity<ProductDetailResponseDto> createProduct(@RequestBody ProductDetailDto productDetailDto){
        ProductDetailResponseDto productDetailResponseDto = productDetailService.saveProductDetail(productDetailDto);

        return ResponseEntity.status(HttpStatus.OK).body(productDetailResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long id) throws Exception{
        productDetailService.deleteProductDetail(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
    }

}
