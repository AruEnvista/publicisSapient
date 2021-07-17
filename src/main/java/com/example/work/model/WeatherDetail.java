package com.example.work.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDetail {
    private float id;
    private String main;
    private String description;
    private String icon;
}
