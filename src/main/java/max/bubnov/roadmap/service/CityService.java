package max.bubnov.roadmap.service;

import max.bubnov.roadmap.domain.City;
import max.bubnov.roadmap.domain.Road;
import max.bubnov.roadmap.repo.CityRepo;

import java.util.ArrayList;
import java.util.List;

public class CityService implements CityRepo{

    private List<City> cities = new ArrayList<>();

    @Override
    public List<City> findAll() {
        return cities;
    }

    @Override
    public City findByName(String name) {
        if(cities != null && name != null) {
           return cities.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        } else {
            return null;
        }
    }

    @Override
    public boolean createCity(City city) {
        long count = cities.stream().filter(x -> x.equals(city)).count();
        if(count == 0) {
            return cities.add(city);
        } else {
            return false;
        }
    }

    @Override
    public void deleteCity(City city) {
        cities.remove(cities.indexOf(city));
    }

    public List<Road> getRoadsByCityName(String name) {
        return findByName(name).getRoads();
    }
}
