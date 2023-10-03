package com.springboot.product.service;

import com.springboot.product.data.dto.ProductDto;
import com.springboot.product.data.dto.ProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProductService {
    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

    List<ProductResponseDto> getByPriceProduct(Integer price);

    Page<ProductResponseDto> getByNameProduct(String name, Pageable pageable);

}
