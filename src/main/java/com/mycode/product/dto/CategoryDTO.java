package com.mycode.product.dto;
import java.util.List;
import com.mycode.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        name="Category",
        description = "It holds category information along with this products"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
