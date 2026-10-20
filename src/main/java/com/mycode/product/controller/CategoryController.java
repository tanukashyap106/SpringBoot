package com.mycode.product.controller;

import com.mycode.product.dto.CategoryDTO;
import com.mycode.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(
        name="Category REST API CRUD operation",
        description = "CREATE READ UPDATE DELETE operations for Category REST API"

)
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    //get all categories
    @Operation(
            summary = "Fetch all categories",
            description = "REST API to fetch all categories along with the products"
    )
    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();

    }
    //create categories
    private CategoryService categoryService;
    @Operation(
            summary = "Create category",
            description = "REST API to create category."
    )
    @ApiResponse(
         responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
            CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);

    }
    //get categories by id
    @Operation(
            summary = "Create category by categoryId",
            description = "REST API to create category by categoryId."
    )

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
   return categoryService.getCategoryById(id);
    }
    //delete categories
    @Operation(
            summary = "Delete category by categoryId",
            description = "REST API to delete category by categoryId."
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
    return categoryService.deleteCategory(id);

    }
}
