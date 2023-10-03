package com.springboot.product.data.dao.impl;


import com.springboot.product.data.dao.ProductDAO;
import com.springboot.product.data.entity.Product;
import com.springboot.product.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component // 등록된 Bean 객체를 가져올 수 있음
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired // 의존성 주입(생성자를 통한)
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product){
        Product saveProduct = productRepository.save(product);
        // JpaRepository의 save 메서드 사용

        return saveProduct;
    }

    @Override
    public Product selectProduct(Long number){
        Product selectedProduct = productRepository.getById(number);
        // JpaRepository의 getById 메서드 사용

        return selectedProduct;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        // 물품을 검색 -> 수정
        Optional<Product> selectedProduct = productRepository.findById(number); // 물품 검색 + nullpointerexception을 방지하는 Optional wrapper 클래스

        Product updatedProduct;

        if (selectedProduct.isPresent()){ // Optional 객체의 값의 유무 확인
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updatedProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }
        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception{
        // 물품 검색 -> 삭제

        Optional<Product> selectedProduct = productRepository.findById(number);

        if (selectedProduct.isPresent()){
            Product product = selectedProduct.get();

            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }

    @Override
    public List<Product> findByPriceProduct(Integer price){
        List<Product> findByPriceProduct = productRepository.findByPrice(price);

        return findByPriceProduct;
    }

    @Override
    public Page<Product> findByNameProduct(String name, Pageable pageable){


        Page<Product> findByNameProduct = productRepository.findByName(name, pageable);

        return findByNameProduct;
    }


}
