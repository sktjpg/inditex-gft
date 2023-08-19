package com.icekome.inditex.application;

import com.icekome.inditex.domain.Price;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public record PriceRetriever(PriceFinder priceFinder) {

  public Price findPrice(LocalDateTime date, long productId, long chainId) {
    return priceFinder
        .findBy(date, productId, chainId)
        .orElseThrow(() -> new RuntimeException(""));
  }

}
