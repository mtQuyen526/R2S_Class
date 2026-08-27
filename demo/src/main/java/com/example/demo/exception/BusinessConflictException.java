package com.example.demo.exception;

import com.example.demo.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class BusinessConflictException extends BusinessException {
    public BusinessConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT; // 409
    }
}