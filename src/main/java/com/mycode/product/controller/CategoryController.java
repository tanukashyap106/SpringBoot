package com.mycode.product.controller;

import com.mycode.product.dto.CategoryDTO;
import com.mycode.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    //get all categories
    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();

    }
    //create categories
    private CategoryService categoryService;
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }
    //get categories by id
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
   return categoryService.getCategoryById(id);
    }
    //delete categories
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
    return categoryService.deleteCategory(id);

    }
}
