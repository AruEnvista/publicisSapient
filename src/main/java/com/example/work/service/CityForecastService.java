package com.example.work.service;

import com.example.work.model.WeatherForecast;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CityForecastService {
    ResponseEntity<List<WeatherForecast>> getCityDetails(String city);
}
