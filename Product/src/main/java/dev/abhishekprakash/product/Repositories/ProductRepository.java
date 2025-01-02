package dev.abhishekprakash.product.Repositories;

import dev.abhishekprakash.product.Clients.ProductClient;
import dev.abhishekprakash.product.DTOs.ProductDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final ProductClient productClient;

    public ProductRepository(ProductClient productClient) {
        this.productClient = productClient;
    }

    public List<ProductDTO> getProducts(Integer page, Integer size) {
        return productClient.getProducts(page, size);
    }

    public List<ProductDTO> getProductsByCategory(String productCategory, Integer page, Integer size) {
        return productClient.getProductsByCategory(productCategory, page, size);
    }

}