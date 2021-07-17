package com.example.work.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    private String cod;
    private float message;

    private float cnt;
    private List<WeatherObjectList> list = new ArrayList<>();
    private City CityObject;

}
