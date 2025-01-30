package dev.abhishekprakash.product.Controllers;

import dev.abhishekprakash.product.DTOs.ProductResponseDTO;
import dev.abhishekprakash.product.Entities.ProductEntity;
import dev.abhishekprakash.product.Mappers.ProductMapper;
import dev.abhishekprakash.product.Services.ProductService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductController {

    private final ProductMapper productMapper;

    private final ProductService productService;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> getProducts(
            @RequestParam(required = false) Optional<Long> categoryId,
            @RequestParam(defaultValue = "0") @PositiveOrZero Integer page,
            @RequestParam(defaultValue = "10") @Min(1) @Max(100) Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> products = productService.getProducts(categoryId, pageable);

        return ResponseEntity.ok(products.map(productMapper::toResponseDto));
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable @Positive Long productId) {
        ProductEntity product = productService.getProductById(productId);

        return ResponseEntity.ok(productMapper.toResponseDto(product));
    }

}