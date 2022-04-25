package com.pavlov.bannerCategory;

import com.pavlov.bannerCategory.exception.AlreadyExistingException;
import com.pavlov.bannerCategory.exception.BannerNotFoundException;
import com.pavlov.bannerCategory.exception.NotFoundException;
import com.pavlov.bannerCategory.exception.RemovalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AlreadyExistingException.class)
    public ResponseEntity<?> handleAlreadyExistingException(AlreadyExistingException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getLocalizedMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getLocalizedMessage());
    }

    @ExceptionHandler(RemovalException.class)
    public ResponseEntity<?> handleRemovalException (RemovalException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getLocalizedMessage());
    }

    @ExceptionHandler(BannerNotFoundException.class)
    public ResponseEntity<?> handleBannerNotFoundException (BannerNotFoundException exception) {
        return ResponseEntity.status(HttpAnswer.BANNER_NOT_FOUND.value).body(exception.getLocalizedMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        String errorMessage = "";
        if (!violations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            violations.forEach(violation -> builder.append(" " + violation.getMessage()));
            errorMessage = builder.toString();
        } else {
            errorMessage = "ConstraintViolationException occured.";
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    public enum HttpAnswer {
        BANNER_NOT_FOUND (204);

        final Integer value;

        HttpAnswer(Integer value){
            this.value = value;
        }
    }

}
