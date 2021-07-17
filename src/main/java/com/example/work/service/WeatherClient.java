package com.example.work.service;

import com.example.work.model.Weather;

public interface WeatherClient {
    Weather getWeather(String city);
}
