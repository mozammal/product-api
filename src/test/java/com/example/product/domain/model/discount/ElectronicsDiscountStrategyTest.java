package com.example.product.domain.model.discount;

import com.example.product.application.model.Product;
import com.example.product.application.model.discount.DiscountStrategy;
import com.example.product.application.model.discount.ElectronicsDiscountStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ElectronicsDiscountStrategyTest {

  DiscountStrategy discountStrategy = new ElectronicsDiscountStrategy();

  @Test
  void applyDiscount_returnPriceAfter15PercentDiscount() {
    // given
    Product product =
        new Product(
            "SKU0001",
            new BigDecimal("100.00"),
            "Wireless Mouse with ergonomic design",
            "Electronics");
    BigDecimal actualDiscountedPrice = new BigDecimal("85.00");

    // when
    BigDecimal discountedPrice = discountStrategy.applyDiscount(product);

    // then
    Assertions.assertEquals(discountedPrice, actualDiscountedPrice);
  }

  @Test
  void applyDiscount_WhenNotApplicable_returnsOriginalPrice() {
    // given
    Product product =
        new Product(
            "SKU0001",
            new BigDecimal("123.12"),
            "Wireless Mouse with ergonomic design",
            "Home & Kitchen");
    BigDecimal actualDiscountedPrice = new BigDecimal("123.12");

    // when
    BigDecimal discountedPrice = discountStrategy.applyDiscount(product);

    // then

    Assertions.assertEquals(discountedPrice, actualDiscountedPrice);
  }
}
