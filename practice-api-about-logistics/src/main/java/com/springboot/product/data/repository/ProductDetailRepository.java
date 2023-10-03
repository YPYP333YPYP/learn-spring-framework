package com.springboot.product.data.repository;



import com.springboot.product.data.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

}
