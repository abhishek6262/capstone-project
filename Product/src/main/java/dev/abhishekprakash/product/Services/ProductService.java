package dev.abhishekprakash.product.Services;

import dev.abhishekprakash.product.DTOs.ProductDTO;
import dev.abhishekprakash.product.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getProducts(Optional<String> productCategory, Integer page, Integer size) {
        if (page < 1) throw new IllegalArgumentException("The `page` cannot be less than 1.");
        else if (size < 1) throw new IllegalArgumentException("The `size` cannot be less than 1.");

        if (productCategory.isPresent()) {
            return productRepository.getProductsByCategory(productCategory.get(), page, size);
        }

        return productRepository.getProducts(page, size);
    }

}