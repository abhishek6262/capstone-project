package dev.abhishekprakash.product.Services;

import dev.abhishekprakash.product.Repositories.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<String> getProductCategories() {
        return productCategoryRepository.getProductCategories();
    }

}