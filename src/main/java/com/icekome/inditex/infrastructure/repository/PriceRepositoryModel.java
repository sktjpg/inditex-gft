package com.icekome.inditex.infrastructure.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "PRICES")
@Data
public class PriceRepositoryModel {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_seq_generator")
  @SequenceGenerator(name = "price_seq_generator", sequenceName = "price_seq", allocationSize = 1)
  @Column(name = "ID")
  private Long id;

  @Column(name = "BRAND_ID")
  private Long brandId;

  @Column(name = "START_DATE")
  private LocalDateTime startDate;

  @Column(name = "END_DATE")
  private LocalDateTime endDate;

  @Column(name = "PRICE_LIST")
  private int priceList;

  @Column(name = "PRODUCT_ID")
  private Long productId;

  @Column(name = "PRIORITY")
  private int priority;

  @Column(name = "PRICE")
  private BigDecimal price;

  @Column(name = "CURR")
  private String currency;
}