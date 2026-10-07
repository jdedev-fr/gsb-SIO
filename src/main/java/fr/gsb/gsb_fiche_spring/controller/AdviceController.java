package fr.gsb.gsb_fiche_spring.controller;

import fr.gsb.gsb_fiche_spring.exception.VisiteurNonTrouveException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AdviceController {

    // Capture les erreurs des validateurs Jakarta (@NotNull, @Size, etc.)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleJsonError(HttpMessageNotReadableException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("erreur", "Format du JSON invalide ou mauvais types de données (ex: du texte au lieu d'un nombre)");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    //VisiteurNonTrouveException
    @ExceptionHandler(VisiteurNonTrouveException.class)
    public ResponseEntity<Map<String, String>> handleVisitorError(VisiteurNonTrouveException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("erreur", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundError(EntityNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("erreur", "Ressource non trouvé");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}