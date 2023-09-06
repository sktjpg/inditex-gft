package com.icekome.inditex.application;

import com.icekome.inditex.domain.exceptions.BadParamsException;
import com.icekome.inditex.domain.exceptions.NotFoundException;
import com.icekome.inditex.domain.models.Price;
import java.time.LocalDateTime;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PriceRetrieverUseCase implements PriceRetriever {

  private final PriceFinder priceFinder;

  @Override
  public Price findPrice(LocalDateTime date, long productId, long brandId) {
    throwExceptionIfNotValid(date, productId, brandId);
    return priceFinder
        .findBy(date, productId, brandId)
        .orElseThrow(() -> notFoundException(date, productId, brandId));
  }

  private NotFoundException notFoundException(LocalDateTime date, long productId, long brandId) {
    return new NotFoundException("Not found any object with these inputs: "
        + "date: " + date
        + " - productId: " + productId
        + " - brandId: " + brandId
    );
  }

  private void throwExceptionIfNotValid(LocalDateTime date, long productId, long brandId) {
    if (date != null && productId >= 0 && brandId >= 0) {
      return;
    }

    final var errors = new ArrayList<String>();

    if (productId < 0) {
      errors.add("productId must be positive");
    }

    if (brandId < 0) {
      errors.add("brandId must be positive");
    }

    if (date == null) {
      errors.add("date must not be null");
    }

    String message = "The following params are not valid: " + String.join(" - ", errors);
    throw new BadParamsException(message);
  }
}