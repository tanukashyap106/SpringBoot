package com.mycode.product.service;


import com.mycode.product.dto.CategoryDTO;
import com.mycode.product.entity.Category;
import com.mycode.product.mapper.CategoryMapper;
import com.mycode.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    //create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
    Category category = CategoryMapper.toCategoryEntity(categoryDTO);
    category = categoryRepository.save(category);
    return CategoryMapper.toCategoryDTO(category);

    }
    //get all categories
    public List<CategoryDTO> getAllCategories(){
      return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();

    }
    //get category by id
    public CategoryDTO getCategoryById(Long id){
        Category category=categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }
    //delete category
    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category deleted successfully";
    }



    //create,get,delete,get by id
}
