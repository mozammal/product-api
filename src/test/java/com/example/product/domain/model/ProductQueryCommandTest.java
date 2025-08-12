package com.example.product.domain.model;

import com.example.product.application.model.ProductQueryCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductQueryCommandTest {
  @Test
  void ProductQueryCommand_whenOrderByFieldIsNotExists_throwException() {

    IllegalArgumentException ex =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              ProductQueryCommand productQueryCommand =
                  new ProductQueryCommand.Builder()
                      .categoryFilter("e1lectronics")
                      .sortField("fake_field")
                      .sortDirection("asc")
                      .build();
            });
  }
}
