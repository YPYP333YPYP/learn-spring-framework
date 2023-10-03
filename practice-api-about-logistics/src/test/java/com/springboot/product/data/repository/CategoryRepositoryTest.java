package com.springboot.product.data.repository;


import com.springboot.product.data.entity.Category;
import com.springboot.product.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void relationshipTest(){
        Product product = new Product();
        product.setName("pen");
        product.setPrice(2000);
        product.setStock(7);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());




        productRepository.save(product);


        Category category = new Category();
        category.setCode("S1");
        category.setName("book");
        category.getProductList().add(product);

        categoryRepository.save(category);


        List<Product> productList = categoryRepository.findById(1L).get().getProductList();

        for (Product foundProduct : productList){
            System.out.println(product);
        }

    }

}
