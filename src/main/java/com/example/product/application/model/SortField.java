package com.example.product.application.model;

public enum SortField {
  SKU("sku"),
  PRICE("price"),
  DESCRIPTION("description"),
  CATEGORY("category");

  private final String value;

  SortField(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static SortField from(String value) {
    try {
      return SortField.valueOf(value.trim().toUpperCase());
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid parameter: " + value);
    }
  }
}
