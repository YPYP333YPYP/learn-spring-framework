package com.springboot.product.controller;


import com.springboot.product.data.dto.CategoryDto;
import com.springboot.product.data.dto.CategoryResponseDto;
import com.springboot.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<CategoryResponseDto> getCategory(Long id){
        CategoryResponseDto categoryResponseDto = categoryService.getCategory(id);

        return ResponseEntity.status(HttpStatus.OK).body(categoryResponseDto);
    }

    @PostMapping()
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryResponseDto categoryResponseDto = categoryService.saveCategory(categoryDto);

        return ResponseEntity.status(HttpStatus.OK).body(categoryResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteCategory(Long id) throws Exception{
        categoryService.deleteCategory(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
    }
}
