package com.icekome.inditex.application;

import com.icekome.inditex.domain.Price;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public record PriceRetriever(PriceFinder priceFinder) {

  public List<Price> findPrice(LocalDate date, long productId, long chainId) {
    return priceFinder.findBy(date, productId, chainId);
  }

}
