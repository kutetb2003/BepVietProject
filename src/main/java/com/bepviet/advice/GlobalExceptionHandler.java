package com.bepviet.advice;

import com.bepviet.dto.ErrorResponseDto;
import com.bepviet.exception.FieldRequiredException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<ErrorResponseDto> handleFieldRequiredException(FieldRequiredException e){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setError(e.getMessage());
        List<String> details = new ArrayList<>();
        details.add("Name for recipe is required");
        errorResponseDto.setDetails(details);
        return new ResponseEntity<>(errorResponseDto, HttpStatusCode.valueOf(404));
    }
}
