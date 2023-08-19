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
      "AND p.productId = :productId AND p.brandId = :brandId " +
      "AND p.priority = (SELECT MAX(p2.priority) FROM PriceRepositoryModel p2 " +
      "WHERE (p2.startDate <= :date AND p2.endDate >= :date) " +
      "AND p2.productId = :productId AND p2.brandId = :brandId)")
  Optional<PriceRepositoryModel> findByDateAndProductIdAndBrandId(
      LocalDateTime date,
      long productId,
      long brandId
  );
}