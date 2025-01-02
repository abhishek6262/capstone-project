package dev.abhishekprakash.product.Services;

import dev.abhishekprakash.product.DTOs.ProductDTO;
import dev.abhishekprakash.product.Entities.ProductEntity;
import dev.abhishekprakash.product.Mappers.ProductMapper;
import dev.abhishekprakash.product.Repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductService(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> getProducts(Optional<String> productCategory, Pageable pageable) {
        Page<ProductEntity> productEntities = productCategory.isPresent() ?
                productRepository.findAllByCategory(productCategory.get(), pageable) :
                productRepository.findAll(pageable);

        return productEntities.map(productMapper::toDto);
    }

}