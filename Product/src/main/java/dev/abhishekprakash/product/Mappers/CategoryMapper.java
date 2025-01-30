package dev.abhishekprakash.product.Mappers;

import dev.abhishekprakash.product.DTOs.CategoryResponseDTO;
import dev.abhishekprakash.product.Entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    CategoryResponseDTO toResponseDto(CategoryEntity categoryEntity);

}