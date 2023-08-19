package com.icekome.inditex.application;

import com.icekome.inditex.domain.models.Price;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceFinder {

  Optional<Price> findBy(LocalDateTime date, long productList, long brandId);
}