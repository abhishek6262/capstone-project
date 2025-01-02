package dev.abhishekprakash.product.Repositories;

import dev.abhishekprakash.product.Entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}