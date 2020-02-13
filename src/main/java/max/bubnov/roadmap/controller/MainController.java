package max.bubnov.roadmap.controller;

import max.bubnov.roadmap.domain.City;
import max.bubnov.roadmap.domain.Road;
import max.bubnov.roadmap.service.CityService;
import max.bubnov.roadmap.service.RoadService;

import java.util.List;

public class MainController {

    private final CityService cityService = new CityService();
    private final RoadService roadService = new RoadService();

    public List<City> getAllCities() {
        return cityService.findAll();
    }

    public boolean createCity(City city) {
        return cityService.createCity(city);
    }

    public List<Road> getAllRoads(){
        return roadService.findAll();
    }

    public boolean createRoad(Road road) {
        return roadService.createRoad(road);
    }

    public City getCityByName(String name) {
        return cityService.findByName(name);
    }

    public Road getRoadByName(String name) {
        return roadService.findByName(name);
    }

    public boolean addRoad(City first, City second,  Road road) {
        return cityService.addRoad(first, second, road);
    }

    public List<Road> getRoadsByCityName(String name) {
        return cityService.getRoadsByCityName(name);
    }

    public boolean deleteRoad(Road road) {
            roadService.delete(road);
            List<City> allCity = cityService.findAll();
            for (City city : allCity) {
                List<Road> roads = city.getRoads();
                for (Road road1 : roads) {
                    if (road1.equals(road)) {
                        roads.remove(road1);
                    } else {
                        return false;
                    }
                }
            }
        return false;
    }
}

