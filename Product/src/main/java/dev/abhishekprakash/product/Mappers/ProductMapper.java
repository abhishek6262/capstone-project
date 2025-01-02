package dev.abhishekprakash.product.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dev.abhishekprakash.product.DTOs.ProductResponseDTO;
import dev.abhishekprakash.product.Entities.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "id",          target = "id")
    @Mapping(source = "title",       target = "title")
    @Mapping(source = "category",    target = "category")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "image",       target = "image")
    @Mapping(source = "price",       target = "price")
    @Mapping(source = "createdAt",   target = "createdAt")
    @Mapping(source = "updatedAt",   target = "updatedAt")
    ProductResponseDTO toDto(ProductEntity productEntity);
    
    @Mapping(source = "createdAt",  target = "createdAt")
    @Mapping(source = "updatedAt",  target = "updatedAt")
    ProductEntity toEntity(ProductResponseDTO productDTO);
}
