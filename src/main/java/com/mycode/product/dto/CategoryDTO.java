package com.mycode.product.dto;
import java.util.List;
import com.mycode.product.entity.Product;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
