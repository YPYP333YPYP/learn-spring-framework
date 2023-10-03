package com.springboot.product.data.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProviderDto {

    private String name;

    public ProviderDto(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;

    }
}
