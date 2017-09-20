package xyz.moroku0519.practiceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.logging.Level;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.moroku0519.practiceapp.api.WeatherApiClient;
import xyz.moroku0519.practiceapp.injection.DaggerActivityComponent;

public class MainActivity extends AppCompatActivity {

    @Inject
    OkHttpClient okHttpClient;

    private WeatherApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerActivityComponent.create().inject(this);
        setContentView(R.layout.activity_main);

        apiClient = new Retrofit
                .Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.openweathermap.org")
                .build()
                .create(WeatherApiClient.class);
        fetchContents();

    }

    private void fetchContents() {

        Call<WeatherApiClient.WeatherResponse> call = apiClient.fetchWeather(WeatherApiClient.apiKey, WeatherApiClient.cityName);
        call.enqueue(new Callback<WeatherApiClient.WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherApiClient.WeatherResponse> call, Response<WeatherApiClient.WeatherResponse> response) {
                WeatherApiClient.WeatherResponse weatherResponse = response.body();
                if (weatherResponse != null) {

                }
            }

            @Override
            public void onFailure(Call<WeatherApiClient.WeatherResponse> call, Throwable t) {
            //TODO error handling
            }
        });

    }
}
