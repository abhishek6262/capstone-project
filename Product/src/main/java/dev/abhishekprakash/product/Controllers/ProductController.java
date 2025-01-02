package dev.abhishekprakash.product.Controllers;

import dev.abhishekprakash.product.DTOs.ProductDTO;
import dev.abhishekprakash.product.Services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(
            @RequestParam(value = "category", required = false) Optional<String> category,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        List<ProductDTO> products = productService.getProducts(category, page, size);

        return ResponseEntity.ok(products);
    }

}