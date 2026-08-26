package com.mycode.product.controller;

import com.mycode.product.dto.ProductDTO;
import com.mycode.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    //getAllProducts



    //createProduct
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct=productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);

    }
    //update product
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO) {

    }
    //get product by id
    //delete product



}
