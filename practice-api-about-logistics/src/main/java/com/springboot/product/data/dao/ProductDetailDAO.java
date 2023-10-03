package com.springboot.product.data.dao;

import com.springboot.product.data.entity.Product;
import com.springboot.product.data.entity.ProductDetail;

public interface ProductDetailDAO {

    // 물품 정보 추가
    ProductDetail insertProductDetail(ProductDetail productDetail);

    // 물품 정보 검색
    ProductDetail selectProductDetail(Long id);

    // 물품 정보 삭제
    void deleteProductDetail(Long id) throws Exception;

}
