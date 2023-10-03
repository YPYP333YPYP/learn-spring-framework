package com.springboot.product.data.dao.impl;

import com.springboot.product.data.dao.CategoryDAO;
import com.springboot.product.data.entity.Category;
import com.springboot.product.data.entity.Product;
import com.springboot.product.data.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryDAOImpl implements CategoryDAO {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryDAOImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category insertCategory(Category category){
        Category saveCategory = categoryRepository.save(category);


        return saveCategory;
    }

    @Override
    public Category selectCategory(Long id){
        Category selectedCategory = categoryRepository.getById(id);

        return selectedCategory;
    }

    @Override
    public void deleteCategory(Long id) throws  Exception{
        Optional<Category> selectedCategory = categoryRepository.findById(id);

        if (selectedCategory.isPresent()){
            Category category = selectedCategory.get();

            categoryRepository.delete(category);
        } else {
            throw new Exception();
        }
    }
}
