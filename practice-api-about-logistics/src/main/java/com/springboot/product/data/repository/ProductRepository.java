package com.springboot.product.data.repository;

import com.springboot.product.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPrice(Integer price);

    Page<Product> findByName(String name, Pageable pageable);

}
