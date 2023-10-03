package com.springboot.product.data.dto;

import com.springboot.product.data.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {

    private String code;

    private String name;

    private List<Product> productList = new ArrayList<>();

    public CategoryDto(String code, String name, List<Product> productList){
        this.code = code;
        this.name = name;
        this.productList = productList;
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
