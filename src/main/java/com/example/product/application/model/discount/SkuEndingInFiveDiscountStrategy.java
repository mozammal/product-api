package com.example.product.application.model.discount;

import com.example.product.application.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SkuEndingInFiveDiscountStrategy implements DiscountStrategy {

  @Override
  public BigDecimal applyDiscount(Product product) {
    if (product.getSku().endsWith("5")) {
      return product
          .getPrice()
          .multiply(BigDecimal.valueOf(0.70))
          .setScale(2, RoundingMode.HALF_UP);
    }
    return product.getPrice().setScale(2, RoundingMode.HALF_UP);
  }
}
