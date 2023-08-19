package com.icekome.inditex.domain.exceptions;

public class BadParamsException extends RuntimeException {

  public BadParamsException(String message) {
    super(message);
  }
}