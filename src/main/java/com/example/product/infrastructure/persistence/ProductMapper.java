package com.example.product.infrastructure.persistence;

import com.example.product.application.model.Product;

public class ProductMapper {

  public static Product toDomain(ProductEntity entity) {
    return new Product(
        entity.getSku(), entity.getPrice(), entity.getDescription(), entity.getCategory());
  }

  public static ProductEntity toEntity(Product product) {
    ProductEntity entity = new ProductEntity();
    entity.setSku(product.getSku());
    entity.setPrice(product.getPrice());
    entity.setDescription(product.getDescription());
    entity.setCategory(product.getCategory());
    return entity;
  }
}
