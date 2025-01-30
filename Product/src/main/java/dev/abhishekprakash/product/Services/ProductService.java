package dev.abhishekprakash.product.Services;

import dev.abhishekprakash.product.Entities.ProductEntity;
import dev.abhishekprakash.product.Exceptions.ProductNotFoundException;
import dev.abhishekprakash.product.Repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public Page<ProductEntity> getProducts(Optional<Long> categoryId, Pageable pageable) {
        return categoryId.isPresent() ?
                productRepository.findAllByCategory_Id(categoryId.get(), pageable) :
                productRepository.findAll(pageable);
    }

    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with the id [" + id + "]."));
    }

}