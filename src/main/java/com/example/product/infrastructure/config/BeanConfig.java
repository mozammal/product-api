package com.example.product.infrastructure.config;

import com.example.product.application.model.Product;
import com.example.product.application.model.discount.*;
import com.example.product.application.usecase.GetProductsUseCase;
import com.example.product.application.model.port.out.ProductRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfig {

  @Bean
  public DiscountService discountService() {
    return new ProductDiscountService(
        List.of(
            new ElectronicsDiscountStrategy(),
            new HomeKitchenDiscountStrategy(),
            new SkuEndingInFiveDiscountStrategy()));
  }

  @Bean
  public GetProductsUseCase getProductsUseCase(
      ProductRepository<Product> repo, DiscountService discountService) {
    return new GetProductsUseCase(repo, discountService);
  }
}
