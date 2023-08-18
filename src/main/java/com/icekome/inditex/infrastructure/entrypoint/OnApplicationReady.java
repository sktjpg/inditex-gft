package com.icekome.inditex.infrastructure.entrypoint;

import org.flywaydb.core.Flyway;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public record OnApplicationReady(
    Flyway flyway
) {

  @EventListener(ApplicationReadyEvent.class)
  public void migrate() {
    flyway.migrate();
  }

}