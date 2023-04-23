package ru.dealerships.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends RuntimeException {


    @ExceptionHandler(value = CarNotFoundException.class)
    public ResponseEntity<String> handleCarNotFoundException(final CarNotFoundException e) {
        log.info(e.getMessage());
        return new ResponseEntity<>("Сar not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DealerNotFoundException.class)
    public ResponseEntity<String> handleDealerNotFoundException(final DealerNotFoundException e) {
        log.info(e.getMessage());
        return new ResponseEntity<>("Dealer not found", HttpStatus.NOT_FOUND);
    }
}
