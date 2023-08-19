package com.icekome.inditex.infrastructure.api.errors;

import java.time.OffsetDateTime;

public record ErrorResponse(
    OffsetDateTime timestamp,
    int status,
    String error
) {

}
