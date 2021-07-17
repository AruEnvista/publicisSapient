package com.example.work.controller;

import com.example.work.model.WeatherForecast;
import com.example.work.service.CityForecastService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/weather")
public class CityForecastController {

    /*test and deploy a micro service to show the output of a city's next 3 days high and low temperatures. If rain is predicted in next 3 days or temperature goes above 40 degree Celsius then mention 'Carry umbrella' or 'Use sunscreen lotion' respectively, in the output, for that day. The service should be accessible via web browser on internet and end user should be able to view results by changing city. The output should be presented in web browser using any one of JavaScript framework, HTML, JSON or plain text. And the service should be ready (in Git repository) to be released to production or live environment.

    API to fetch weather forecast data

    api.openweathermap.org/data/2.5/forecast?q=London,us&mode=xml&appid=d2929e9483efc82c82c32ee7e02d563e Refer @ here for the details about this API.*/

    private CityForecastService cityForecastService;

    public CityForecastController(CityForecastService cityForecastService){
        this.cityForecastService = cityForecastService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<List<WeatherForecast>> getCity(@PathVariable String city){
        return cityForecastService.getCityDetails(city);
    }

}
