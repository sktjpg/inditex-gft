package com.icekome.inditex.infrastructure.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

  @Value("${spring.datasource.url}")
  private String url;

  @Value("${spring.datasource.username}")
  private String username;

  @Value("${spring.datasource.password}")
  private String password;

  @Value("${spring.flyway.locations}")
  private String locations;

  @Bean
  public Flyway flyway() {
    return Flyway
        .configure()
        .dataSource(url, username, password)
        .locations(locations)
        .load();
  }
}