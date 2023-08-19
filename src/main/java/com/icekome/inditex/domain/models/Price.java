package com.icekome.inditex.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Price(
    long id,
    long productId,
    LocalDateTime startDate,
    LocalDateTime endDate,
    int productList,
    long brandId,
    BigDecimal price,
    String currency,

    int priceList
) {

}
