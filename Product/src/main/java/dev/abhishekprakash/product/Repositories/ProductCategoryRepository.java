package dev.abhishekprakash.product.Repositories;

import dev.abhishekprakash.product.Clients.ProductCategoryClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductCategoryRepository {

    private final ProductCategoryClient productCategoryClient;

    public ProductCategoryRepository(ProductCategoryClient productCategoryClient) {
        this.productCategoryClient = productCategoryClient;
    }

    public List<String> getProductCategories() {
        return productCategoryClient.getProductCategories();
    }

}