package com.icekome.inditex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class InditexApplication {

  public static void main(String[] args) {
    SpringApplication.run(InditexApplication.class, args);
  }

}
