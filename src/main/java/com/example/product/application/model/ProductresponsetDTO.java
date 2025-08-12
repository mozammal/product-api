package com.example.product.application.model;

import java.math.BigDecimal;

public record ProductresponsetDTO(
    String sku,
    String description,
    String category,
    BigDecimal originalPrice,
    BigDecimal discountedPrice) {}
