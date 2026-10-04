package com.enviro.assessment.junior.thandekamnyakeni.entities;

@RestController

public class GlobalExceptionHandler{
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, String>> handleBusiness(BusinessException ex){
        return ResponseEntity.badrequest().body(Map.of("error" ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex){
        return ResponseEntity.badrequest().body(Map.of("error" ex.getFieldError().getDefaultMessage()));
    }
}