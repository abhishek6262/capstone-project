package dev.abhishekprakash.product.Services;

import dev.abhishekprakash.product.Entities.ProductEntity;
import dev.abhishekprakash.product.Repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ProductEntity> getProducts(Optional<String> productCategory, Pageable pageable) {
        if (productCategory.isPresent()) {
            return productRepository.findAllByCategory(productCategory.get(), pageable);
        }

        return productRepository.findAll(pageable);
    }

}