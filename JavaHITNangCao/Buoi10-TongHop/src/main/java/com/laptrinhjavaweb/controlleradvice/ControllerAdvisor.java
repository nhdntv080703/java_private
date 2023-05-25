package com.laptrinhjavaweb.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.laptrinhjavaweb.customexception.FileRequiredxception;
import com.laptrinhjavaweb.dto.ErrorResponseDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorResponseDTO> handleArithmeticException(ArithmeticException ex, WebRequest request) {
        ErrorResponseDTO result = new ErrorResponseDTO();
        result.setError(ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add("lỗi rồi a gì đó ơi");
        result.setDetails(details);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(FileRequiredxception.class)
    public ResponseEntity<ErrorResponseDTO> handleFileRequiredxception(FileRequiredxception ex, WebRequest request) {
        ErrorResponseDTO result = new ErrorResponseDTO();
        result.setError(ex.getMessage());
        List<String> details = new ArrayList<>();
        //details.add("lỗi rồi a gì đó ơi");
        result.setDetails(details);
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
