package xyz.moroku0519.practiceapp.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import xyz.moroku0519.practiceapp.BuildConfig;
import xyz.moroku0519.practiceapp.api.entity.ForecastResponce;

/**
 * Created by kazuki on 2017/09/03.
 */

public interface WeatherApiClient {

    String apiKey = BuildConfig.OPEN_WEATHER_MAP_API_KEY;
    String cityName = "nerima";

    @GET("data/2.5/forecast")
    Call<WeatherResponse> fetchWeather(@Query("APPID") String apiKey, @Query("q") String cityName);

    public class WeatherResponse {
        @SerializedName("code")
        private String code;

        @SerializedName("message")
        private float message;

        @SerializedName("cnt")
        private int count;

        @SerializedName("list")
        private List<ForecastResponce> forecasts;

        public List<ForecastResponce> getForecasts() {
            return forecasts;
        }

    }
}
