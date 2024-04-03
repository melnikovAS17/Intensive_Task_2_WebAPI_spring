package ru.melnikov.intensive.utils.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.melnikov.intensive.models.WeatherInfoModel;

public class JsonParser {


    private static JsonNode obj;
    private static ObjectMapper mapper;

    public static WeatherInfoModel getCurrentWeather(String response) {
        mapper = new ObjectMapper();
        try {
            obj = mapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        WeatherInfoModel weatherInfoModel = new WeatherInfoModel();
        weatherInfoModel.setTemp(Math.round((obj.get("main").get("temp").asDouble() - 273.15) * 100.0) / 100.0);
        weatherInfoModel.setTempFeelsLike(Math.round((obj.get("main").get("feels_like").asDouble() - 273.15) * 100.0) / 100.0);
        weatherInfoModel.setPressure(obj.get("main").get("pressure").asInt());
        weatherInfoModel.setHumidity(obj.get("main").get("humidity").asInt());
        weatherInfoModel.setWindSpeed(obj.get("wind").get("speed").asDouble());
        weatherInfoModel.setCity(obj.get("name").asText());
        return weatherInfoModel;
    }
}
