package com.icekome.inditex;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class SpringApplication {

  public static void main(String[] args) {
    org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
  }
}