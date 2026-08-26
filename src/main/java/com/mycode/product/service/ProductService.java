package com.mycode.product.service;

import com.mycode.product.dto.ProductDTO;
import com.mycode.product.entity.Category;
import com.mycode.product.entity.Product;
import com.mycode.product.mapper.ProductMapper;
import com.mycode.product.repository.CategoryRepository;
import com.mycode.product.repository.ProductRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
private ProductRepository productRepository;
private CategoryRepository categoryRepository;

public ProductDTO createProduct(ProductDTO productDTO) {
    /**
     * name,description,price,categoryId
     */
    Category category= categoryRepository.findById(productDTO.getCategoryId())
            .orElseThrow(()-> new RuntimeException("Category not found!"));

    //DTO---entity
   Product product= ProductMapper.toProductEntity(productDTO,category);
   product = productRepository.save(product);
   //Entity---DTO
    return ProductMapper.toProductDTO(product);

}

//get all products
public List<ProductDTO> getAllProducts() {
    return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
}

//get product by id
public ProductDTO getProductById(Long id) {
   Product product = productRepository.findById(id)
           .orElseThrow(()-> new RuntimeException("Product not found!"));
   return ProductMapper.toProductDTO(product);
}
//update Product
    public ProductDTO updateProduct(Long id,ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found!"));

    }




}
