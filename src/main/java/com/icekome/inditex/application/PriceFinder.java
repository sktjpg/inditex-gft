package com.icekome.inditex.application;

import com.icekome.inditex.domain.Price;
import java.time.LocalDateTime;
import java.util.List;

public interface PriceFinder {

  List<Price> findBy(
      LocalDateTime date,
      long productList,
      long chainId
  );

}
