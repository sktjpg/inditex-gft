package com.icekome.inditex.infrastructure.api.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceControllerModel(
    long productId,
    long brandId,
    BigDecimal price,
    String currency,
    LocalDateTime startDate,
    LocalDateTime endDate
) {

}
