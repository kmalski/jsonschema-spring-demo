package com.zti.jsonschema.demo;

import com.zti.jsonschema.demo.validation.JsonValidationException;
import com.zti.jsonschema.types.ErrorResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class HelloExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(HelloExceptionHandler.class);
    private static final ZoneId warsawZone = ZoneId.of("Europe/Warsaw");

    @ExceptionHandler(JsonValidationException.class)
    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    protected ResponseEntity<Object> handleJsonValidationError(JsonValidationException ex, WebRequest request) {
        logger.error("Error during request validation: ", ex);

        ErrorResponse response = new ErrorResponse();
        response.setTimestamp(Instant.now().atZone(warsawZone));
        response.setReason("Request validation failed");
        response.setDetails(
                ex.getValidationMessages()
                        .stream()
                        .map(Objects::toString)
                        .collect(Collectors.joining(", ")));

        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (body == null) {
            logger.error("Error during request validation: ", ex);

            ErrorResponse response = new ErrorResponse();
            response.setTimestamp(Instant.now().atZone(warsawZone));
            response.setReason("Error during request processing");
            response.setDetails(ex.getMessage());
            return super.handleExceptionInternal(ex, response, headers, status, request);
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}
