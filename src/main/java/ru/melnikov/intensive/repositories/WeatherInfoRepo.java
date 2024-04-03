package ru.melnikov.intensive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.melnikov.intensive.models.WeatherInfoModel;

@Repository
public interface WeatherInfoRepo extends JpaRepository<WeatherInfoModel, Integer> {


}
