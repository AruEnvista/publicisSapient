package com.example.work.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherObjectList {

    private float dt;
    private Main main;
    private List<WeatherDetail> weather = new ArrayList<WeatherDetail>();
    private Clouds clouds;
    private Wind wind;
    private Sys sys;
    private String dt_txt;

}
