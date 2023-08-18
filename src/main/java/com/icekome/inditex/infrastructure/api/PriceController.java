package com.icekome.inditex.infrastructure.api;

import com.icekome.inditex.application.PriceRetriever;
import com.icekome.inditex.domain.Price;
import java.time.LocalDate;
import java.util.List;
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

  @GetMapping()
  public ResponseEntity<List<PriceControllerModel>> getPriceQuery(
      @RequestParam("applicationDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate applicationDate,
      @RequestParam("productId") Integer productId,
      @RequestParam("chainId") Integer chainId
  ) {
    return ResponseEntity.ok(
        priceRetriever
            .findPrice(applicationDate, productId, chainId)
            .stream()
            .map(this::toControllerModel)
            .toList()
    );
  }

  private PriceControllerModel toControllerModel(Price it) {
    return new PriceControllerModel(
        it.productId(),
        it.chainId(),
        it.price(),
        it.currency(),
        it.startDate(),
        it.endDate()
    );
  }

}
