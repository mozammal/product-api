package com.example.product;

import com.example.product.application.model.Product;
import com.example.product.application.model.SortDirection;
import com.example.product.application.model.port.out.ProductRepository;
import com.example.product.application.model.port.out.SortCriteria;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryProductRepository implements ProductRepository<Product> {

  private final List<Product> products = DataSource.getProducts();

  public InMemoryProductRepository() {}

  @Override
  public List<Product> findAll(SortCriteria sortCriteria) {
    return products.stream().sorted(getComparator(sortCriteria)).collect(Collectors.toList());
  }

  @Override
  public List<Product> findByCategory(String category, SortCriteria sortCriteria) {
    return products.stream()
        .filter(p -> p.getCategory().equalsIgnoreCase(category))
        .sorted(getComparator(sortCriteria))
        .collect(Collectors.toList());
  }

  @Override
  public List<Product> saveAll(List<Product> entities) {
    products.addAll(entities);
    return products;
  }

  private Comparator<Product> getComparator(SortCriteria sortCriteria) {
    Comparator<Product> comparator;

    switch (sortCriteria.getField()) {
      case PRICE:
        comparator = Comparator.comparing(Product::getPrice);
        break;
      case DESCRIPTION:
        comparator = Comparator.comparing(Product::getDescription, String.CASE_INSENSITIVE_ORDER);
        break;
      case CATEGORY:
        comparator = Comparator.comparing(Product::getCategory, String.CASE_INSENSITIVE_ORDER);
        break;
      case SKU:
      default:
        comparator = Comparator.comparing(Product::getSku, String.CASE_INSENSITIVE_ORDER);
        break;
    }

    if (sortCriteria.getDirection() == SortDirection.DESC) {
      comparator = comparator.reversed();
    }

    return comparator;
  }
}
