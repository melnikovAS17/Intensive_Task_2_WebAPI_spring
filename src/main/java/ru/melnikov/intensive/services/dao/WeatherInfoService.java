package ru.melnikov.intensive.services.dao;

import org.springframework.stereotype.Service;
import ru.melnikov.intensive.models.WeatherInfoModel;
import ru.melnikov.intensive.repositories.WeatherInfoRepo;

@Service
public class WeatherInfoService  {

    private final WeatherInfoRepo weatherInfoRepo;

    public WeatherInfoService(WeatherInfoRepo weatherInfoRepo) {
        this.weatherInfoRepo = weatherInfoRepo;
    }

    public void saveMeasurement(WeatherInfoModel weatherInfoModel) {
        weatherInfoRepo.save(weatherInfoModel);
    }
}
