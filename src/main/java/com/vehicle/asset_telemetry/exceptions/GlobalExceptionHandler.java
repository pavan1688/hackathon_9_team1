package com.vehicle.asset_telemetry.exceptions;

import com.vehicle.asset_telemetry.model.Error;
import com.vehicle.asset_telemetry.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseModel<Void>> handleGenericException() {
        ResponseModel<Void> res = new ResponseModel<>();
        Error err = new Error();
        err.setCode("INTERNAL_SERVER_err");
        err.setMessage("Internal Server error");
        res.setError(err);
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
