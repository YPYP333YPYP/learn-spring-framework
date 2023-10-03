package com.springboot.product.service;

import com.springboot.product.data.dto.CategoryDto;
import com.springboot.product.data.dto.CategoryResponseDto;

public interface CategoryService {

    CategoryResponseDto saveCategory (CategoryDto categoryDto);

    CategoryResponseDto getCategory (Long id);

    void deleteCategory(Long id) throws Exception;
}
