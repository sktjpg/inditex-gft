package com.icekome.inditex.application;

import com.icekome.inditex.domain.exceptions.NotFoundException;
import com.icekome.inditex.domain.models.Price;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public record PriceRetriever(PriceFinder priceFinder) {

  public Price findPrice(LocalDateTime date, long productId, long chainId) {
    return priceFinder
        .findBy(date, productId, chainId)
        .orElseThrow(() -> new NotFoundException(
            "Not found any object with these inputs: date: " + date + " - productId: " + productId
                + " - chainId: " + chainId));
  }

}
