package com.example.product.application.model.discount;

import com.example.product.application.model.Product;

import java.math.BigDecimal;

public interface DiscountStrategy {
  BigDecimal applyDiscount(Product product);
}
