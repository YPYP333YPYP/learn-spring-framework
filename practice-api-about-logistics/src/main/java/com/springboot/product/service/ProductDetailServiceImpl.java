package com.springboot.product.service;


import com.springboot.product.data.dao.ProductDAO;
import com.springboot.product.data.dao.ProductDetailDAO;
import com.springboot.product.data.dto.ProductDetailDto;
import com.springboot.product.data.dto.ProductDetailResponseDto;
import com.springboot.product.data.dto.ProductResponseDto;
import com.springboot.product.data.entity.Product;
import com.springboot.product.data.entity.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductDetailServiceImpl implements ProductDetailService{

    private final ProductDetailDAO productDetailDAO;
    private final ProductDAO productDAO;

    @Autowired
    public ProductDetailServiceImpl(ProductDetailDAO productDetailDAO, ProductDAO productDAO){

        this.productDetailDAO = productDetailDAO;
        this.productDAO = productDAO;
    }

    @Override
    public ProductDetailResponseDto saveProductDetail(ProductDetailDto productDetailDto){
        ProductDetail productDetail = new ProductDetail();

        productDetail.setDescription(productDetailDto.getDescription());
        productDetail.setProduct(productDetailDto.getProduct());

        productDetail.setUpdatedAt(LocalDateTime.now());
        productDetail.setCreatedAt(LocalDateTime.now());

        ProductDetail saveProductDetail = productDetailDAO.insertProductDetail(productDetail);

        ProductDetailResponseDto productDetailResponseDto = new ProductDetailResponseDto();

        productDetailResponseDto.setId(saveProductDetail.getId());
        productDetailResponseDto.setDescription(saveProductDetail.getDescription());
        productDetailResponseDto.setProduct(saveProductDetail.getProduct());


        return productDetailResponseDto;
    }

    @Override
    public ProductDetailResponseDto getProductDetail(Long id){
        ProductDetail productDetail = productDetailDAO.selectProductDetail(id);



        ProductDetailResponseDto productDetailResponseDto = new ProductDetailResponseDto();

        productDetailResponseDto.setId(productDetail.getId());
        productDetailResponseDto.setDescription(productDetail.getDescription());
        productDetailResponseDto.setProduct(productDetail.getProduct());

        return productDetailResponseDto;

    }

    @Override
    public void deleteProductDetail(Long id) throws Exception{
        productDetailDAO.deleteProductDetail(id);
    }



}
