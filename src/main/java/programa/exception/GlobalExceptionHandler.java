package programa.exception;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex) {
        logger.error("Error no controlado: ", ex);
        return new ResponseEntity<>(
                Map.of("error", "Error interno del servidor",
                        "mensaje", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
        logger.error("Error de runtime: ", ex);
        return new ResponseEntity<>(
                Map.of("error", "Error de operación",
                        "mensaje", ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleValidationException(ConstraintViolationException ex) {
        logger.error("Error de validación: ", ex);
        return new ResponseEntity<>(
                Map.of("error", "Error de validación",
                        "mensaje", ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}