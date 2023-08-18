package com.icekome.inditex.application;

import com.icekome.inditex.domain.Price;
import java.time.LocalDate;
import java.util.List;

public interface PriceFinder {

  List<Price> findBy(
      LocalDate date,
      int productList,
      int chainId
  );

}
