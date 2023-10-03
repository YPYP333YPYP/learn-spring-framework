package com.springboot.product.data.dto;



public class ProviderResponseDto {

    private Long id;
    private String name;

    public ProviderResponseDto(){}

    public ProviderResponseDto(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

}
