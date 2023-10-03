package com.springboot.product.data.dao;

import com.springboot.product.data.entity.Category;

public interface CategoryDAO {

    Category insertCategory(Category category);

    Category selectCategory(Long id);

    void deleteCategory(Long id) throws Exception;
}
