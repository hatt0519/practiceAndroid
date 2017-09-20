package xyz.moroku0519.practiceapp.api.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.moroku0519.practiceapp.api.WeatherApiClient;

/**
 * Created by kazuki on 2017/09/03.
 */

public class ForecastResponce {
    @SerializedName("dt")
    private int dateTimeUnix;

    @SerializedName("main")
    private Temperature temperature;

    @SerializedName("dt_txt")
    private String detail;


    public class Temperature {
        @SerializedName("temp")
        private float averageTemperature;

        @SerializedName("temp_min")
        private float minTemperature;

        @SerializedName("temp_max")
        private float maxtemperature;
    }


}
