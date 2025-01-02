package dev.abhishekprakash.product.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dev.abhishekprakash.product.DTOs.ProductDTO;
import dev.abhishekprakash.product.Entities.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "category", source = "category")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "image", source = "image")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "title", source = "title")
    ProductDTO toDto(ProductEntity productEntity);
    
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    ProductEntity toEntity(ProductDTO productDTO);
}
