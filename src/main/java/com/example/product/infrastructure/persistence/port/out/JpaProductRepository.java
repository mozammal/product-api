package com.example.product.infrastructure.persistence.port.out;

import com.example.product.infrastructure.persistence.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JpaProductRepository extends JpaRepository<ProductEntity, String> {
  List<ProductEntity> findByCategoryIgnoreCase(String category, Sort sort);
}
