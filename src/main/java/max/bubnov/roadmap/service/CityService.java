package max.bubnov.roadmap.service;

import max.bubnov.roadmap.domain.City;
import max.bubnov.roadmap.domain.Road;
import max.bubnov.roadmap.repo.CityRepo;
import max.bubnov.roadmap.utils.LengthUtil;

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
    public List<Road> getRoadsByCityName(String name) {
        return findByName(name).getRoads();
    }

    public boolean addRoad(City first, City second, Road road) {
        if(first != null && second != null && road != null) {
            if (road.getCities().size() > 2) {
                System.out.println("Дорога уже имеет два города!");
                return false;
            } else if(road.getLength() >= LengthUtil.getPermissibleLength(first, second)) {
                first.getRoads().add(road);
                second.getRoads().add(road);
                road.getCities().add(first);
                road.getCities().add(second);
                return true;
            } else {
                System.out.println("Дорога слишком коротая");
                return false;
            }
        } else {
            System.out.println("Incorrect data");
            return false;
        }
    }
}
