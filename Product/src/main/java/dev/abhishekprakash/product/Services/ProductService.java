package dev.abhishekprakash.product.Services;

import dev.abhishekprakash.product.DTOs.ProductResponseDTO;
import dev.abhishekprakash.product.Entities.ProductEntity;
import dev.abhishekprakash.product.Exceptions.ProductNotFoundException;
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
    public Page<ProductResponseDTO> getProducts(Optional<Long> categoryId, Pageable pageable) {
        Page<ProductEntity> productEntities = categoryId.isPresent() ?
                productRepository.findAllByCategory_Id(categoryId.get(), pageable) :
                productRepository.findAll(pageable);

        return productEntities.map(productMapper::toDto);
    }

    public ProductResponseDTO getProductById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with the id: " + id));

        return productMapper.toDto(productEntity);
    }

}