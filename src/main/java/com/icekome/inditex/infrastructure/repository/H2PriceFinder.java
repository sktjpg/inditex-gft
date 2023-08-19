package com.icekome.inditex.infrastructure.repository;

import com.icekome.inditex.application.PriceFinder;
import com.icekome.inditex.domain.models.Price;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public record H2PriceFinder(PriceRepository priceRepository) implements PriceFinder {

  @Override
  public Optional<Price> findBy(LocalDateTime date, long productId, long brandId) {
    return priceRepository
        .findByDateAndProductIdAndBrandId(date, productId, brandId)
        .map(this::toDomain);
  }

  private Price toDomain(PriceRepositoryModel priceRepositoryModel) {
    return new Price(
        priceRepositoryModel.getId(),
        priceRepositoryModel.getProductId(),
        priceRepositoryModel.getStartDate(),
        priceRepositoryModel.getEndDate(),
        priceRepositoryModel.getPriceList(),
        priceRepositoryModel.getBrandId(),
        priceRepositoryModel.getPrice(),
        priceRepositoryModel.getCurrency()
    );
  }
}
