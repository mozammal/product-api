package com.example.product.application.model.discount;

import com.example.product.application.model.Product;

import java.math.BigDecimal;

public interface DiscountService{
  BigDecimal getBestDiscountedPrice(Product product);
}
