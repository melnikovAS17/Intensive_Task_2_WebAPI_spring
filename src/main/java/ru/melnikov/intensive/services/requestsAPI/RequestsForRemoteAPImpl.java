package ru.melnikov.intensive.services.requestsAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.melnikov.intensive.models.WeatherInfoModel;

import java.util.List;

@Component
@PropertySource("classpath:connectionAPI.properties")
public final class RequestsForRemoteAPImpl implements RequestsForRemoteAPI{
    private final RestTemplate restTemplate;
    private final Environment environment;

    @Autowired
    public RequestsForRemoteAPImpl(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    private String getURL() {
        return environment.getProperty("url.api.current.weather");
    }

    private String getAPIkey() {
        return environment.getProperty("api.key");
    }

    @Override
    public String getCurrentWeatherInTheCity(String city) {
       String response = restTemplate.getForObject(getURL()
                + city + getAPIkey(), String.class);
        return response;
    }

    @Override
    public List<WeatherInfoModel> getForecastWeatherInTheCity(String city) {
        return null;
    }
}
