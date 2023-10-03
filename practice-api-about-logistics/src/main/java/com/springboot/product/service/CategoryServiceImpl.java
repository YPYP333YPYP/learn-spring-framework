package com.springboot.product.service;

import com.springboot.product.data.dao.CategoryDAO;
import com.springboot.product.data.dto.CategoryDto;
import com.springboot.product.data.dto.CategoryResponseDto;
import com.springboot.product.data.dto.ProductResponseDto;
import com.springboot.product.data.entity.Category;
import com.springboot.product.data.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO){
        this.categoryDAO =categoryDAO;
    }

    @Override
    public CategoryResponseDto saveCategory(CategoryDto categoryDto){

        Category category = new Category();

        category.setName(categoryDto.getName());
        category.setCode(categoryDto.getCode());
        category.setProductList(categoryDto.getProductList());

        Category saveCategory = categoryDAO.insertCategory(category);

        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();

        categoryResponseDto.setId(saveCategory.getId());
        categoryResponseDto.setName(saveCategory.getName());
        categoryResponseDto.setCode(saveCategory.getCode());
        categoryResponseDto.setProductList(saveCategory.getProductList());

        return categoryResponseDto;
    }

    @Override
    public CategoryResponseDto getCategory(Long id){
        Category category = categoryDAO.selectCategory(id);

        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();

        categoryResponseDto.setCode(category.getCode());
        categoryResponseDto.setName(category.getName());
        categoryResponseDto.setProductList(category.getProductList());

        return categoryResponseDto;
    }

    @Override
    public void deleteCategory(Long id) throws Exception{
        categoryDAO.deleteCategory(id);

    }
}
