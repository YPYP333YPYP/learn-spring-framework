package com.springboot.product.data.dto;

import com.springboot.product.data.entity.Product;

public class ProductDetailResponseDto {
    private Long id;
    private String description;

    private Product product;

    public ProductDetailResponseDto(){}

    public ProductDetailResponseDto(Long id, String description, Product product){
        this.id = id;
        this.description = description;
        this.product = product;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
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
