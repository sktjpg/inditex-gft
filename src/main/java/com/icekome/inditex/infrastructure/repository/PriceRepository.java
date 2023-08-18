package com.icekome.inditex.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceRepositoryModel, Long> {

  @Query("SELECT p FROM PriceRepositoryModel p " +
      "WHERE (p.startDate <= :date AND p.endDate >= :date) " +
      "AND p.priceList = :productList AND p.brandId = :brandId")
  List<PriceRepositoryModel> findByDateAndPriceListAndBrandId(
      LocalDateTime date,
      int productList,
      int brandId
  );


}
