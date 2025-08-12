package com.example.product.application.usecase;

import com.example.product.application.model.*;
import com.example.product.application.model.discount.DiscountService;
import com.example.product.application.model.port.out.ProductRepository;
import com.example.product.application.model.port.out.SortCriteria;

import java.util.List;
import java.util.stream.Collectors;

public class GetProductsUseCase {

  private final ProductRepository<Product> repository;
  private final DiscountService discountService;

  public GetProductsUseCase(ProductRepository<Product> repository, DiscountService discountService) {
    this.repository = repository;
    this.discountService = discountService;
  }

  public List<ProductresponsetDTO> execute(ProductQueryCommand command) {

    String categoryFilter = command.getCategoryFilter();
    String sortFieldStr = command.getSortField().getValue();
    String sortDirStr = command.getSortDirection().getValue();
    SortField sortField = SortField.from(sortFieldStr == null ? "sku" : sortFieldStr);
    SortDirection sortDirection = SortDirection.from(sortDirStr == null ? "ASC" : sortDirStr);
    SortCriteria sortCriteria = new SortCriteria(sortField, sortDirection);
    List<Product> products;

    if (categoryFilter != null && !categoryFilter.isBlank()) {
      products = repository.findByCategory(categoryFilter.trim(), sortCriteria);
    } else {
      products = repository.findAll(sortCriteria);
    }

    return products.stream()
        .map(
            p ->
                new ProductresponsetDTO(
                    p.getSku(),
                    p.getDescription(),
                    p.getCategory(),
                    p.getPrice(),
                    discountService.getBestDiscountedPrice(p)))
        .collect(Collectors.toList());
  }
}
