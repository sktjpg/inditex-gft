package com.icekome.inditex.infrastructure.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/test")
  public ResponseEntity<?> test() {
    return ResponseEntity.ok().build();
  }

}
