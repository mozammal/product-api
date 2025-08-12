package com.example.product.application.model.port.out;

import java.util.List;

public interface ProductRepository<T> {
  List<T> findAll(SortCriteria sortCriteria);

  List<T> findByCategory(String category, SortCriteria sortCriteria);

  List<T> saveAll(List<T> entities);
}
