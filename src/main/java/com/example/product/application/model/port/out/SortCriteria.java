package com.example.product.application.model.port.out;

import com.example.product.application.model.SortDirection;
import com.example.product.application.model.SortField;

public class SortCriteria {
  private final SortField field;
  private final SortDirection direction;

  public SortCriteria(SortField field, SortDirection direction) {
    this.field = field;
    this.direction = direction;
  }

  public SortField getField() {
    return field;
  }

  public SortDirection getDirection() {
    return direction;
  }
}
