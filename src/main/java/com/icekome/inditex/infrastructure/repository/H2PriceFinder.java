package com.icekome.inditex.infrastructure.repository;

import com.icekome.inditex.application.PriceFinder;
import com.icekome.inditex.domain.Price;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public record H2PriceFinder(
    PriceRepository priceRepository
) implements PriceFinder {

  @Override
  public List<Price> findBy(LocalDate date, Integer productList, Integer brandId) {
    return priceRepository
        .findByDateAndPriceListAndBrandId(
            date.atStartOfDay(),
            productList,
            brandId
        )
        .stream()
        .map(this::toDomain)
        .toList();
  }

  private Price toDomain(PriceRepositoryModel priceRepositoryModel) {
    return new Price(
        priceRepositoryModel.getId(),
        priceRepositoryModel.getStartDate(),
        priceRepositoryModel.getEndDate(),
        priceRepositoryModel.getPriceList(),
        priceRepositoryModel.getProductId(),
        priceRepositoryModel.getPrice(),
        priceRepositoryModel.getCurrency()
    );
  }
}