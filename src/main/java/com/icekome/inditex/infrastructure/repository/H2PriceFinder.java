package com.icekome.inditex.infrastructure.repository;

import com.icekome.inditex.application.PriceFinder;
import com.icekome.inditex.domain.Price;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class H2PriceFinder implements PriceFinder {

  private final PriceRepository priceRepository;

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
