package com.example.product.domain.model.discount;

import com.example.product.application.model.Product;
import com.example.product.application.model.discount.DiscountService;
import com.example.product.application.model.discount.HomeKitchenDiscountStrategy;
import com.example.product.application.model.discount.ProductDiscountService;
import com.example.product.application.model.discount.SkuEndingInFiveDiscountStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class ProductDiscountServiceTest {

  private DiscountService discountService =
      new ProductDiscountService(
          List.of(
              new SkuEndingInFiveDiscountStrategy(),
              new HomeKitchenDiscountStrategy(),
              new SkuEndingInFiveDiscountStrategy()));

  @Test
  void applyDiscount_returnPriceAfterApplyingHighestDiscount() {
    Product product =
        new Product(
            "SKU0005",
            new BigDecimal("100.00"),
            "Wireless Mouse with ergonomic design",
            "Home & Kitchen");

    BigDecimal actualDiscountedPrice = new BigDecimal("70.00");

    BigDecimal discountedPrice = discountService.getBestDiscountedPrice(product);

    Assertions.assertEquals(discountedPrice, actualDiscountedPrice);
  }

  @Test
  void applyDiscount_WhenNotApplicable_returnsOriginalPrice() {
    Product product =
        new Product(
            "SKU0001", new BigDecimal("123.12"), "Wireless Mouse with ergonomic design", "Sports");
    BigDecimal actualDiscountedPrice = new BigDecimal("123.12");

    BigDecimal discountedPrice = discountService.getBestDiscountedPrice(product);

    Assertions.assertEquals(discountedPrice, actualDiscountedPrice);
  }
}
