package com.mycode.product.controller;

import com.mycode.product.dto.ProductDTO;
import com.mycode.product.service.ProductService;
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
        name="Product REST API CRUD operation",
        description = "CREATE READ UPDATE DELETE operations for product REST API"

)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    //getAllProducts
    @Operation(
            summary = "Fetch all product",
            description = "REST API to fetch all products"
    )
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
    //createProduct
    @Operation(
            summary = "Create product",
            description = "REST API to fetch all products"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct=productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);

    }
    //update product
    @Operation(
            summary = "Update product by productId",
            description = "REST API to update product by productId"
    )
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO) {
       return productService.updateProduct(id, productDTO);
    }

    //get product by id
    @Operation(
            summary = "Fetch product by product Id",
            description = "REST API to fetch product by productId"
    )
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);}


    //delete product
        @Operation(
                summary = "Delete product by productId",
                description = "REST API to Delete product by productId"
        )
        @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }




}
