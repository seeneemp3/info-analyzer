package com.personal.infostore.web.controller;

import com.personal.infostore.model.exception.SensorNFE;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(SensorNFE.class)
    public String sensorNotFound(SensorNFE e) {
        return "Sensor not found";
    }

    @ExceptionHandler
    public String serverError(Exception e) {
        e.printStackTrace();
        return "Something went wrong";
    }
}
