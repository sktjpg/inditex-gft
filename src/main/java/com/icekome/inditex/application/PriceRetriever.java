package com.icekome.inditex.application;

import com.icekome.inditex.domain.models.Price;
import java.time.LocalDateTime;

public interface PriceRetriever {

  Price findPrice(LocalDateTime date, long productId, long brandId);

}
