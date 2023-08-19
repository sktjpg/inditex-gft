package com.icekome.inditex.infrastructure.api.errors;

import com.icekome.inditex.domain.exceptions.BadParamsException;
import com.icekome.inditex.domain.exceptions.NotFoundException;
import java.time.OffsetDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse(
            OffsetDateTime.now(),
            404,
            ex.getMessage()
        ));
  }

  @ExceptionHandler(BadParamsException.class)
  public ResponseEntity<ErrorResponse> handleBadParamsException(BadParamsException ex) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse(
            OffsetDateTime.now(),
            400,
            ex.getMessage()
        ));
  }
}
