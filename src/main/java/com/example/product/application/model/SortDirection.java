package com.example.product.application.model;

public enum SortDirection {
  ASC("ASC"),
  DESC("DESC");

  private final String value;

  SortDirection(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static SortDirection from(String value) {
    try {
      return SortDirection.valueOf(value.trim().toUpperCase());
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid parameter:  " + value);
    }
  }
}
