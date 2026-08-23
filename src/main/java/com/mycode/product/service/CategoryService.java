package com.mycode.product.service;


import com.mycode.product.dto.CategoryDTO;
import com.mycode.product.entity.Category;
import com.mycode.product.mapper.CategoryMapper;
import com.mycode.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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



    //create,get,delete,get by id
}
