package dev.abhishekprakash.product.Mappers;

import org.mapstruct.Mapper;

import dev.abhishekprakash.product.DTOs.ProductDTO;
import dev.abhishekprakash.product.Entities.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(ProductEntity productEntity);
    
    ProductEntity toEntity(ProductDTO productDTO);
}
