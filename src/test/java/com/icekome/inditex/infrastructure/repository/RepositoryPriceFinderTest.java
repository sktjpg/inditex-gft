package com.icekome.inditex.infrastructure.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.icekome.inditex.domain.models.Price;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RepositoryPriceFinderTest {

  private final PriceRepository priceRepository = mock(PriceRepository.class);

  private RepositoryPriceFinder repositoryPriceFinder;

  @BeforeEach
  public void setUp() {
    repositoryPriceFinder = new RepositoryPriceFinder(priceRepository);
  }

  @Test
  public void shouldFoundPrice() {
    final var date = LocalDateTime.of(2023, 12, 1, 0, 0, 0);
    final var productId = 123L;
    final var brandId = 456L;
    final var repositoryModel = getPriceRepositoryModel(date, productId, brandId);
    final var expectedPrice = getPrice(date, productId, brandId);

    when(priceRepository.findHighestPriorityByDateAndProductIdAndBrandId(date, productId, brandId))
        .thenReturn(Optional.of(repositoryModel));

    Optional<Price> actualPrice = repositoryPriceFinder.findBy(date, productId, brandId);

    assertTrue(actualPrice.isPresent());
    assertEquals(expectedPrice, actualPrice.get());
  }

  @Test
  public void shouldNotFoundPrice() {
    final var date = LocalDateTime.now();
    final var productId = 123L;
    final var brandId = 456L;

    when(priceRepository.findHighestPriorityByDateAndProductIdAndBrandId(date, productId, brandId))
        .thenReturn(Optional.empty());

    Optional<Price> actualPrice = repositoryPriceFinder.findBy(date, productId, brandId);

    assertFalse(actualPrice.isPresent());
  }

  private PriceRepositoryModel getPriceRepositoryModel(LocalDateTime date, long productId,
      long brandId) {
    final var price = new PriceRepositoryModel();
    price.setId(1L);
    price.setBrandId(brandId);
    price.setStartDate(date);
    price.setEndDate(date);
    price.setPriceList(1);
    price.setProductId(productId);
    price.setPriority(3);
    price.setPrice(BigDecimal.ONE);
    price.setCurrency("EUR");
    return price;
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