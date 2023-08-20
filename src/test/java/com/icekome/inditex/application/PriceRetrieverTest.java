package com.icekome.inditex.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.icekome.inditex.domain.exceptions.BadParamsException;
import com.icekome.inditex.domain.exceptions.NotFoundException;
import com.icekome.inditex.domain.models.Price;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriceRetrieverTest {

  private final PriceFinder priceFinder = mock(PriceFinder.class);

  private PriceRetriever priceRetriever;

  @BeforeEach
  public void setUp() {
    priceRetriever = new PriceRetriever(priceFinder);
  }

  @Test
  public void shouldReturnTheExpectedPrice() {
    final var date = LocalDateTime.of(2023, 12, 1, 0, 0, 0);
    final var productId = 1L;
    final var brandId = 1L;
    final var expectedPrice = getPrice(date, productId, brandId);

    when(priceFinder.findBy(date, productId, brandId)).thenReturn(Optional.of(expectedPrice));

    final var actualPrice = priceRetriever.findPrice(date, productId, brandId);

    assertEquals(expectedPrice, actualPrice);
  }

  @Test
  public void shouldThrowNotFoundException() {
    final var date = LocalDateTime.now();
    final var productId = 2L;
    final var brandId = 2L;

    when(priceFinder.findBy(date, productId, brandId)).thenReturn(Optional.empty());

    assertThrows(NotFoundException.class, () -> priceRetriever.findPrice(date, productId, brandId));
  }

  @Test
  public void shouldThrowBadParamsException() {
    assertThrows(
        BadParamsException.class,
        () -> priceRetriever.findPrice(null, -2, -2)
    );
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
}