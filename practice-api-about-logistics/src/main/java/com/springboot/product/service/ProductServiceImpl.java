package com.springboot.product.service;

import com.springboot.product.data.dao.ProductDAO;
import com.springboot.product.data.dto.ProductDto;
import com.springboot.product.data.dto.ProductResponseDto;
import com.springboot.product.data.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service // 로직을 처리하는 Service 계층을 표시
public class ProductServiceImpl implements ProductService {

    // 데이터베이스로부터 값을 받음 -> DAO
    // 클라이언트에게 전달하기 위해서 Dto 제공
    // service 계층의 역활 중 하나
    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number){
        // DAO 객체를 사용 -> 클라이언트에게는 Dto 객체로 전달되어야함 -> 변환 과정이 필요

        Product product = productDAO.selectProduct(number);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        productResponseDto.setProvider(product.getProvider());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto){
        // dto 객체를 받고 -> dao 객체로 전달 (데이터베이스)
        // 클라이언트에게도 물품이 잘 저장되었다는 것을 알 수 있게 Dto 객체로 전달 (클라이언트)

        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());

        product.setProvider(productDto.getProvider());
        product.setUpdatedAt(LocalDateTime.now());
        product.setCreatedAt(LocalDateTime.now());

        Product saveProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setNumber(saveProduct.getNumber());
        productResponseDto.setName(saveProduct.getName());
        productResponseDto.setPrice(saveProduct.getPrice());
        productResponseDto.setStock(saveProduct.getStock());
        productResponseDto.setProvider(saveProduct.getProvider());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changeProduct = productDAO.updateProductName(number, name);

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setNumber(changeProduct.getNumber());
        productResponseDto.setName(changeProduct.getName());
        productResponseDto.setPrice(changeProduct.getPrice());
        productResponseDto.setStock(changeProduct.getStock());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception{
        productDAO.deleteProduct(number);
    }

    @Override
    public List<ProductResponseDto> getByPriceProduct(Integer price) {
        List<Product> listProduct = productDAO.findByPriceProduct(price);

        List<ProductResponseDto> listProductResponseDto = new ArrayList<>(listProduct.size());

       for(Product product : listProduct){
            ProductResponseDto productResponseDto = new ProductResponseDto();

            productResponseDto.setNumber(product.getNumber());
            productResponseDto.setName(product.getName());
            productResponseDto.setPrice(product.getPrice());
            productResponseDto.setStock(product.getStock());

            listProductResponseDto.add(productResponseDto);
        }

        return listProductResponseDto;
    }

    @Override
    public Page<ProductResponseDto> getByNameProduct(String name, Pageable pageable){

        Page<Product> list = productDAO.findByNameProduct(name, pageable);

        List<ProductResponseDto> listProductResponseDto = new ArrayList<>(list.getSize());

        for (Product product : list){
            ProductResponseDto productResponseDto = new ProductResponseDto();

            productResponseDto.setNumber(product.getNumber());
            productResponseDto.setName(product.getName());
            productResponseDto.setPrice(product.getPrice());
            productResponseDto.setStock(product.getStock());

            listProductResponseDto.add(productResponseDto);
        }

        Page<ProductResponseDto> page = new PageImpl<>(listProductResponseDto, (org.springframework.data.domain.Pageable) pageable, list.getSize());
        return page;

    }




}
