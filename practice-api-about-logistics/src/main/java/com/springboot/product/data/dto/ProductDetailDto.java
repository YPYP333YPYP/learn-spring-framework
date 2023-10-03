package com.springboot.product.data.dto;

import com.springboot.product.data.entity.Product;

public class ProductDetailDto {

    private String description;

    private Product product;

    public ProductDetailDto(String description, Product product){
        this.description = description;
        this.product= product;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product){
        this.product = product;
    }
}
