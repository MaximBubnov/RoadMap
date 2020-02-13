package max.bubnov.roadmap.repo;

import max.bubnov.roadmap.domain.City;
import max.bubnov.roadmap.domain.Road;

import java.util.List;

public interface CityRepo {

    List<City> findAll();

    //API # 4
    City findByName(String name);

    //API # 1
    boolean createCity(City city);
    // API # 5
    List<Road> getRoadsByCityName(String name);

}
