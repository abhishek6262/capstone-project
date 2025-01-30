package dev.abhishekprakash.product.Services;

import dev.abhishekprakash.product.DTOs.CategoryResponseDTO;
import dev.abhishekprakash.product.Entities.CategoryEntity;
import dev.abhishekprakash.product.Mappers.CategoryMapper;
import dev.abhishekprakash.product.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository,
                           CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryResponseDTO> getCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();

        return categoryEntities.stream()
                .map(categoryMapper::toResponseDto)
                .collect(Collectors.toList());
    }

}