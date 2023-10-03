package com.springboot.product.data.dto;

import com.springboot.product.data.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryResponseDto {

    private Long id;

    private String code;

    private String name;

    private List<Product> productList = new ArrayList<>();

    public CategoryResponseDto(){}

    public CategoryResponseDto(Long id, String code, String name, List<Product> productList){
        this.id = id;
        this.code = code;
        this.name = name;
        this.productList = productList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
