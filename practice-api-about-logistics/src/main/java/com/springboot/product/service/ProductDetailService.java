package com.springboot.product.service;

import com.springboot.product.data.dto.ProductDetailDto;
import com.springboot.product.data.dto.ProductDetailResponseDto;




public interface ProductDetailService {

    ProductDetailResponseDto saveProductDetail(ProductDetailDto productDetailDto);
    ProductDetailResponseDto getProductDetail (Long id);
    void deleteProductDetail(Long id) throws Exception;
}
