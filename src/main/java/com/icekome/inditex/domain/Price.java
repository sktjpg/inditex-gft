package com.icekome.inditex.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Price(
    Long id,
    Long productId,
    LocalDateTime startDate,
    LocalDateTime endDate,
    Integer productList,
    Long chainId,
    BigDecimal price,
    String currency
) {

}
