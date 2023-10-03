package com.springboot.product.data.dto;

import com.springboot.product.data.entity.ProductDetail;
import com.springboot.product.data.entity.Provider;

public class ProductDto {

    private String name;
    private int price;
    private int stock;

    private ProductDetail productDetail;

    private Provider provider;

    public ProductDto(String name, int price, int stock,ProductDetail productDetail, Provider provider){
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.productDetail = productDetail;
        this.provider = provider;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }




    public Provider getProvider(){
        return provider;
    }

    public void setProvider(Provider provider){
        this.provider = provider;
    }
}
