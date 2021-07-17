package com.example.work.service;

import com.example.work.Exception.BadWeatherDataException;
import com.example.work.Exception.ResourceNotFoundException;
import com.example.work.model.Weather;
import com.example.work.model.WeatherForecast;
import com.example.work.model.WeatherObjectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityForecastServiceImpl implements CityForecastService {

    @Autowired
    private WeatherClient weatherClient;

    @Override
    public ResponseEntity<List<WeatherForecast>> getCityDetails(String city) {

        if(city.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        List<WeatherForecast> daywiseWeatherList = new ArrayList<>();

        try {
            Weather details = weatherClient.getWeather(city);

            List<WeatherObjectList> threeDaysWeather = details.getList().subList(0, 3);

            for (WeatherObjectList weatherObjectList : threeDaysWeather) {

                WeatherForecast weatherForecast = new WeatherForecast();

                if (weatherObjectList.getMain() != null) {

                    weatherForecast.setHigh(weatherObjectList.getMain().getTemp_max());
                    weatherForecast.setLow(weatherObjectList.getMain().getTemp_min());

                    float temperatureInCelsius = weatherObjectList.getMain().getTemp() - 273.15F;

                    if (temperatureInCelsius > 40.0) {
                        weatherForecast.setMessage("Use sunscreen lotion");
                    } else if (weatherObjectList.getWeather().get(0).getMain().contains("Rain")) {
                        weatherForecast.setMessage("Carry umbrella");
                    } else {
                        weatherForecast.setMessage(weatherObjectList.getWeather().get(0).getMain());
                    }

                } else {
                    throw new BadWeatherDataException("Bad weather");
                }

                daywiseWeatherList.add(weatherForecast);
            }


        } catch (Exception ex) {
            throw new ResourceNotFoundException("Weather Not Found" + city);
        }
        return ResponseEntity.ok(daywiseWeatherList);
    }
}
