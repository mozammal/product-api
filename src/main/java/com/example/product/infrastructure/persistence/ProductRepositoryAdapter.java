package com.example.product.infrastructure.persistence;

import com.example.product.application.model.Product;
import com.example.product.application.model.SortDirection;
import com.example.product.application.model.port.out.ProductRepository;
import com.example.product.application.model.port.out.SortCriteria;
import com.example.product.infrastructure.persistence.port.out.JpaProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryAdapter implements ProductRepository<Product> {

  private final JpaProductRepository jpaRepository;

  public ProductRepositoryAdapter(JpaProductRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  private Sort toInfraSortCriteria(SortCriteria sortCriteria) {

    Sort.Direction direction =
        (sortCriteria.getDirection() == SortDirection.DESC)
            ? Sort.Direction.DESC
            : Sort.Direction.ASC;

    return Sort.by(direction, sortCriteria.getField().getValue());
  }

  @Override
  public List<Product> findAll(SortCriteria sortCriteria) {
    Sort sort = toInfraSortCriteria(sortCriteria);
    List<ProductEntity> entities = jpaRepository.findAll(sort);
    return entities.stream().map(ProductMapper::toDomain).collect(Collectors.toList());
  }

  @Override
  public List<Product> findByCategory(String category, SortCriteria sortCriteria) {
    Sort sort = toInfraSortCriteria(sortCriteria);
    List<ProductEntity> entities = jpaRepository.findByCategoryIgnoreCase(category, sort);
    return entities.stream().map(ProductMapper::toDomain).collect(Collectors.toList());
  }

  @Override
  public List<Product> saveAll(List<Product> products) {
    List<ProductEntity> entities =
        products.stream()
            .map(product -> ProductMapper.toEntity(product))
            .collect(Collectors.toList());

    return jpaRepository.saveAll(entities).stream()
        .map(entitiy -> ProductMapper.toDomain(entitiy))
        .collect(Collectors.toList());
  }
}
