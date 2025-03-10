package dev.abhishekprakash.product.Repositories;

import dev.abhishekprakash.product.Entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Page<ProductEntity> findAllByCategory_Id(Long aLong, Pageable pageable);

    Page<ProductEntity> findAllByTitleContainingIgnoreCaseAndCategory_Id(String title, Long categoryId, Pageable pageable);

    Page<ProductEntity> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);

}