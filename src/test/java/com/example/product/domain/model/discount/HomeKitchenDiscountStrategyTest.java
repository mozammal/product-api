package com.example.product.domain.model.discount;

import com.example.product.application.model.Product;
import com.example.product.application.model.discount.DiscountStrategy;
import com.example.product.application.model.discount.HomeKitchenDiscountStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class HomeKitchenDiscountStrategyTest {

  private DiscountStrategy discountStrategy = new HomeKitchenDiscountStrategy();

  @Test
  void applyDiscount_returnPriceAfter25PercentDiscount() {
    Product product =
        new Product(
            "SKU0001",
            new BigDecimal("100.00"),
            "Wireless Mouse with ergonomic design",
            "Home & Kitchen");

    BigDecimal actualDiscountedPrice = new BigDecimal("75.00");

    BigDecimal discountedPrice = discountStrategy.applyDiscount(product);

    Assertions.assertEquals(discountedPrice, actualDiscountedPrice);
  }

  @Test
  void applyDiscount_WhenNotApplicable_returnsOriginalPrice() {
    Product product =
        new Product(
            "SKU0001",
            new BigDecimal("123.12"),
            "Wireless Mouse with ergonomic design",
            "Electronics");
    BigDecimal actualDiscountedPrice = new BigDecimal("123.12");

    BigDecimal discountedPrice = discountStrategy.applyDiscount(product);

    Assertions.assertEquals(discountedPrice, actualDiscountedPrice);
  }
}
