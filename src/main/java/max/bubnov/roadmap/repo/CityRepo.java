package max.bubnov.roadmap.repo;

import max.bubnov.roadmap.domain.City;

import java.util.List;

public interface CityRepo {

    List<City> findAll();

    City findByName(String name);

    boolean createCity(City city);

    void deleteCity(City city);


}
