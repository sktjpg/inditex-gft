package com.icekome.inditex.application;

import com.icekome.inditex.domain.exceptions.BadParamsException;
import com.icekome.inditex.domain.exceptions.NotFoundException;
import com.icekome.inditex.domain.models.Price;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public record PriceRetriever(PriceFinder priceFinder) {

  public Price findPrice(LocalDateTime date, long productId, long chainId) {
    throwExceptionIfNotValid(date, productId, chainId);
    return priceFinder
        .findBy(date, productId, chainId)
        .orElseThrow(() -> notFoundException(date, productId, chainId));
  }

  private NotFoundException notFoundException(LocalDateTime date, long productId, long chainId) {
    return new NotFoundException("Not found any object with these inputs: "
        + "date: " + date
        + " - productId: " + productId
        + " - chainId: " + chainId
    );
  }

  private void throwExceptionIfNotValid(LocalDateTime date, long productId, long chainId) {
    if (date != null && productId >= 0 && chainId >= 0) {
      return;
    }

    final var errors = new ArrayList<String>();

    if (productId < 0) {
      errors.add("productId must be positive");
    }

    if (chainId < 0) {
      errors.add("chainId must be positive");
    }

    if (date == null) {
      errors.add("date must not be null");
    }

    String message = "The following params are not valid: " + String.join(" - ", errors);
    throw new BadParamsException(message);
  }

}
