package com.mycode.product.service;

import com.mycode.product.dto.ProductDTO;
import com.mycode.product.entity.Category;
import com.mycode.product.entity.Product;
import com.mycode.product.exception.CategoryAlreadyExistsException;
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
            .orElseThrow(()-> new CategoryAlreadyExistsException("Category id: " + productDTO.getCategoryId()+ " not found"));

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
         Category category=categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found!"));
         product.setName(productDTO.getName());
         product.setDescription(productDTO.getDescription());
         product.setPrice(productDTO.getPrice());
         product.setCategory(category);
         productRepository.save(product);
         return ProductMapper.toProductDTO(product);

    }
public  String deleteProduct(Long id) {
    productRepository.deleteById(id);
    return "Product " +id+ " has been deleted!";
}



}
