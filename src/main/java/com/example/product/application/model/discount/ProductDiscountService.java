package com.example.product.application.model.discount;

import com.example.product.application.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductDiscountService implements DiscountService {

  private final List<DiscountStrategy> strategies;

  public ProductDiscountService(List<DiscountStrategy> strategies) {
    this.strategies = strategies;
  }

  public BigDecimal getBestDiscountedPrice(Product product) {
    return strategies.stream()
        .map(s -> s.applyDiscount(product))
        .min(BigDecimal::compareTo)
        .orElse(product.getPrice());
  }
}
