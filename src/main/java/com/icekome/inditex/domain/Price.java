package com.icekome.inditex.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Price(
    Long id,
    LocalDateTime startDate,
    LocalDateTime endDate,
    Integer productList,
    Integer chainId,
    BigDecimal price,
    String currency
) {

}
