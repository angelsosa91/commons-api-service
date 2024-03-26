package py.com.solar.commonsapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import py.com.solar.exceptions.CommonsExceptionHandler;
import py.com.solar.exceptions.ErrorMessage;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler extends CommonsExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorMessage> handleSqlException(SQLException e, WebRequest request) {
        logError(e);
        var message = buildErrorMessage(e, HttpStatus.BAD_REQUEST, request);
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    public void logError(Exception e) {
        log.error("ExceptionHandler Error: {}", e.getMessage(), e);
    }

    private ErrorMessage buildErrorMessage(Exception e, HttpStatus httpStatus, WebRequest request) {
        return ErrorMessage.builder()
                .statusCode(httpStatus.value())
                .timestamp(LocalDateTime.now())
                .message(e.getMessage())
                .description(request.getDescription(true))
                .build();
    }
}