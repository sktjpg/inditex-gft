package com.icekome.inditex.infrastructure.onready;

import lombok.AllArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FlywayStarter {

  private final Flyway flyway;

  @EventListener(ApplicationReadyEvent.class)
  public void migrate() {
    flyway.migrate();
  }
}