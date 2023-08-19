package com.icekome.inditex.infrastructure.api;

import com.icekome.inditex.application.PriceRetriever;
import com.icekome.inditex.domain.Price;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
public record PriceController(
    PriceRetriever priceRetriever
) {

  @GetMapping("/v1")
  public ResponseEntity<PriceControllerModel> findPrice(
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime applicationDate,
      @RequestParam long productId,
      @RequestParam long chainId
  ) {
    final var price = priceRetriever.findPrice(applicationDate, productId, chainId);
    final var priceControllerModel = toControllerModel(price);
    return ResponseEntity.ok(priceControllerModel);
  }

  private PriceControllerModel toControllerModel(Price price) {
    return new PriceControllerModel(
        price.productId(),
        price.chainId(),
        price.price(),
        price.currency(),
        price.startDate(),
        price.endDate()
    );
  }

}
