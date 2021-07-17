package com.example.work.service;

import com.example.work.config.ApplicationConfig;
import com.example.work.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherClientImpl implements  WeatherClient {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Override
    public Weather getWeather(String city) {
        RestTemplate restTemplate  = new RestTemplate();
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("q", city);
        queryParams.put("mode", "json");
        queryParams.put("appid", applicationConfig.getAppid());
        UriComponentsBuilder builder = getUriComponentsBuilder(applicationConfig.getUrl(), queryParams);
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<>(getHeaders()),
                        Weather.class).getBody();
    }

    private UriComponentsBuilder getUriComponentsBuilder(String url,
                                                         Map<String, String> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        queryParams.forEach(builder::queryParam);
        return builder;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
