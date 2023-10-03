package com.springboot.product.data.dao.impl;

import com.springboot.product.data.dao.ProductDetailDAO;
import com.springboot.product.data.entity.Product;
import com.springboot.product.data.entity.ProductDetail;
import com.springboot.product.data.repository.ProductDetailRepository;
import com.springboot.product.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ProductDetailDAOImpl implements ProductDetailDAO {

    private final ProductDetailRepository productDetailRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductDetailDAOImpl(ProductDetailRepository productDetailRepository, ProductRepository productRepository){
        this.productDetailRepository = productDetailRepository;
        this.productRepository = productRepository;

    }

    @Override
    public ProductDetail insertProductDetail(ProductDetail productDetail){
        ProductDetail insertProductDetail = productDetailRepository.save(productDetail);

        return insertProductDetail;
    }

    @Override
    public ProductDetail selectProductDetail (Long id){
        ProductDetail selectProductDetail = productDetailRepository.getById(id);

        return selectProductDetail;
    }

    @Override
    public void deleteProductDetail (Long id) throws Exception{
        Optional<ProductDetail> selectedProductDetail = productDetailRepository.findById(id);

        if (selectedProductDetail.isPresent()){
            ProductDetail productDetail = selectedProductDetail.get();

            productDetailRepository.delete(productDetail);
        } else {
            throw new Exception();
        }
    }


}
