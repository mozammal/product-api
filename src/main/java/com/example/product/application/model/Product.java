package com.example.product.application.model;

import java.math.BigDecimal;

public class Product {
  private final String sku;
  private final BigDecimal price;
  private final String description;
  private final String category;

  public Product(String sku, BigDecimal price, String description, String category) {
    if (sku == null || sku.isBlank()) {
      throw new IllegalArgumentException("SKU must not be null or blank");
    }
    if (price == null) {
      throw new IllegalArgumentException("Price must not be null");
    }
    if (price.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Price must be greater than zero");
    }
    if (description == null || description.isBlank()) {
      throw new IllegalArgumentException("Description must not be null or blank");
    }
    if (category == null || category.isBlank()) {
      throw new IllegalArgumentException("Category must not be null or blank");
    }

    this.sku = sku.trim();
    this.price = price;
    this.description = description.trim();
    this.category = category.trim();
  }

  public String getSku() {
    return sku;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getDescription() {
    return description;
  }

  public String getCategory() {
    return category;
  }
}
