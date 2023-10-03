package com.springboot.product.data.dao;

import com.springboot.product.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductDAO {

    // 물품 추가
    Product insertProduct(Product product);

    // 물품 검색
    Product selectProduct(Long number);

    // 물품 이름 수정
    Product updateProductName(Long number, String name) throws Exception;

    // 물품 삭제
    void deleteProduct(Long number) throws Exception;

    // 물품 검색 - price (List 자료구조)
    List<Product> findByPriceProduct(Integer price);

    // 물품 검색 - name (Page 자료구조)
    Page<Product> findByNameProduct(String name, Pageable pageable);



}
