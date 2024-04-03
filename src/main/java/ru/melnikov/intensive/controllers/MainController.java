package ru.melnikov.intensive.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.melnikov.intensive.models.WeatherInfoModel;
import ru.melnikov.intensive.services.dao.WeatherInfoService;
import ru.melnikov.intensive.services.requestsAPI.RequestsForRemoteAPImpl;
import ru.melnikov.intensive.utils.parsers.JsonParser;

@Controller
public class MainController {


    private final RequestsForRemoteAPImpl requestsForRemoteAPImpl;
    private final WeatherInfoService weatherInfoService;
    @Autowired
    public MainController(RequestsForRemoteAPImpl requestsForRemoteAPImpl, WeatherInfoService weatherInfoService) {
        this.requestsForRemoteAPImpl = requestsForRemoteAPImpl;
        this.weatherInfoService = weatherInfoService;
    }

    @GetMapping("/weather")
    public String getFormForCurrentMeasurements() {
        return "formMeasurements";
    }

    @PostMapping("/weather")
    public String getMeasurements(@RequestParam(value = "city", required = false) String city, Model model) {
        WeatherInfoModel weatherInfoModel =
                JsonParser.getCurrentWeather(requestsForRemoteAPImpl.getCurrentWeatherInTheCity(city));
        weatherInfoService.saveMeasurement(weatherInfoModel);
        model.addAttribute("weatherInfo", weatherInfoModel);
        return "measurementsResult";
    }
}
