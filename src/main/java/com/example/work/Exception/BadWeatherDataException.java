package com.example.work.Exception;

public class BadWeatherDataException  extends RuntimeException {

    public BadWeatherDataException(String message) {
        super(message);
    }
}
