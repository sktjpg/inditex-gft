package com.icekome.inditex.infrastructure.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.icekome.inditex.application.PriceRetriever;
import com.icekome.inditex.domain.models.Price;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class PriceControllerTest {

  private final PriceRetriever priceRetriever = mock(PriceRetriever.class);

  private PriceController priceController;

  @BeforeEach
  public void setUp() {
    priceController = new PriceController(priceRetriever);
  }

  @Test
  public void testFindPrice_Success() {
    final var applicationDate = LocalDateTime.now();
    final var productId = 1L;
    final var brandId = 1L;

    final var price = getPrice(applicationDate, productId, brandId);
    final var expectedModel = getPriceControllerModel(applicationDate, productId, brandId);

    when(priceRetriever.findPrice(applicationDate, productId, brandId)).thenReturn(price);

    ResponseEntity<PriceControllerModel> response = priceController
        .findPrice(applicationDate, productId, brandId);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(expectedModel, response.getBody());
  }

  private Price getPrice(LocalDateTime date, long productId, long brandId) {
    return new Price(
        1L,
        productId,
        date,
        date,
        1,
        brandId,
        BigDecimal.ONE,
        "EUR",
        1
    );
  }

  private PriceControllerModel getPriceControllerModel(LocalDateTime date, long productId,
      long brandId) {
    return new PriceControllerModel(
        productId,
        brandId,
        BigDecimal.ONE,
        "EUR",
        date,
        date,
        1
    );
  }

}