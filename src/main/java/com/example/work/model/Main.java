package com.example.work.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main {

    private float temp;
    private float temp_min;
    private float temp_max;
    private float pressure;
    private float sea_level;
    private float grnd_level;
    private float humidity;
    private float temp_kf;
}
