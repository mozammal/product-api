package com.example.product.application.model;

public class ProductQueryCommand {
  private final String categoryFilter;
  private final SortField sortField;
  private final SortDirection sortDirection;

  private ProductQueryCommand(Builder builder) {
    this.categoryFilter = builder.categoryFilter;
    this.sortField = SortField.from(builder.sortFieldStr == null ? "sku" : builder.sortFieldStr);
    this.sortDirection =
        SortDirection.from(builder.sortDirectionStr == null ? "ASC" : builder.sortDirectionStr);
  }

  public String getCategoryFilter() {
    return categoryFilter;
  }

  public SortField getSortField() {
    return sortField;
  }

  public SortDirection getSortDirection() {
    return sortDirection;
  }

  public static class Builder {
    private String categoryFilter;
    private String sortFieldStr;
    private String sortDirectionStr;

    public Builder categoryFilter(String categoryFilter) {
      this.categoryFilter = categoryFilter;
      return this;
    }

    public Builder sortField(String sortField) {
      this.sortFieldStr = sortField;
      return this;
    }

    public Builder sortDirection(String sortDirection) {
      this.sortDirectionStr = sortDirection;
      return this;
    }

    public ProductQueryCommand build() {
      return new ProductQueryCommand(this);
    }
  }
}
