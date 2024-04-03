package ru.melnikov.intensive.services.requestsAPI;

import org.springframework.stereotype.Component;
import ru.melnikov.intensive.models.WeatherInfoModel;

import java.util.List;

@Component
public interface RequestsForRemoteAPI {

     String getCurrentWeatherInTheCity(String city);

     List<WeatherInfoModel> getForecastWeatherInTheCity(String city);
}
