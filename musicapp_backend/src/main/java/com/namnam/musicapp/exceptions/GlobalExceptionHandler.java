package com.namnam.musicapp.exceptions;

import com.namnam.musicapp.dtos.reponses.ApiResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)// handler any expected exception (code 999)
    ResponseEntity<ApiResponse> handlingException(Exception exception)
    {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ErrorCode.UNKNOWN_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNKNOWN_EXCEPTION.getMessage());

        return ResponseEntity.badRequest().body(apiResponse); //400
    }


    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException exception)
    {
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse); //400
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException exception)
    {
        String enumKey = exception.getFieldError().getDefaultMessage();

        //if use error code key in validation string => throw code 9999, INVALID_VALIDATE_KEY
        ErrorCode errorCode = ErrorCode.INVALID_VALIDATE_KEY;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        } catch (IllegalArgumentException e){}

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(apiResponse); //400
    }
}
