package com.icekome.inditex.infrastructure.api.controller;

import com.icekome.inditex.application.PriceRetriever;
import com.icekome.inditex.domain.models.Price;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
@AllArgsConstructor
public class PriceController {

  private final PriceRetriever priceRetriever;

  @GetMapping("/v1")
  public ResponseEntity<PriceControllerModel> findPrice(
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime applicationDate,
      @RequestParam long productId,
      @RequestParam long brandId
  ) {
    final var price = priceRetriever.findPrice(applicationDate, productId, brandId);
    final var priceControllerModel = toControllerModel(price);
    return ResponseEntity.ok(priceControllerModel);
  }

  private PriceControllerModel toControllerModel(Price price) {
    return new PriceControllerModel(
        price.productId(),
        price.brandId(),
        price.price(),
        price.currency(),
        price.startDate(),
        price.endDate(),
        price.priceList()
    );
  }
}