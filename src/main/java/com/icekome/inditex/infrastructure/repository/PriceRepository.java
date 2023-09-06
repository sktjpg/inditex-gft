package com.icekome.inditex.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceRepositoryModel, Long> {

  @Query("SELECT p FROM PriceRepositoryModel p " +
      "WHERE (p.startDate <= :date AND p.endDate >= :date) " +
      "AND p.productId = :productId " +
      "AND p.brandId = :brandId " +
      "ORDER BY p.priority DESC " +
      "LIMIT 1")
  Optional<PriceRepositoryModel> findHighestPriorityByDateAndProductIdAndBrandId(
      LocalDateTime date,
      long productId,
      long brandId
  );
}