package dev.abhishekprakash.product.Services;

import dev.abhishekprakash.product.DTOs.ProductResponseDTO;
import dev.abhishekprakash.product.Entities.ProductEntity;
import dev.abhishekprakash.product.Mappers.ProductMapper;
import dev.abhishekprakash.product.Repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public SearchService(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    public Page<ProductResponseDTO> searchProducts(String query, Optional<Long> categoryId, Pageable pageable) {
        Page<ProductEntity> productEntities = categoryId.isPresent() ?
                productRepository.findAllByTitleContainingIgnoreCaseAndCategory_Id(query, categoryId.get(), pageable) :
                productRepository.findAllByTitleContainingIgnoreCase(query, pageable);

        return productEntities.map(productMapper::toDto);
    }

}