package com.example.product.domain.model;

import com.example.product.application.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

  @Test
  void Product_whenProductISInValidState_throwException() {

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          new Product(
              "SKU0030",
              BigDecimal.valueOf(-7.50),
              "Pack of 10 Ballpoint Pens, Blue Ink",
              "Stationery");
        });
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          new Product(
              "", BigDecimal.valueOf(7.50), "Pack of 10 Ballpoint Pens, Blue Ink", "Stationery");
        });

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          new Product("sku", null, "Pack of 10 Ballpoint Pens, Blue Ink", "Stationery");
        });
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          new Product("sku", BigDecimal.valueOf(7.50), "", "Stationery");
        });
  }
}
