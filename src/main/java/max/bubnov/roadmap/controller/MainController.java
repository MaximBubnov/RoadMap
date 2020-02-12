package max.bubnov.roadmap.controller;

import max.bubnov.roadmap.domain.City;
import max.bubnov.roadmap.domain.Road;
import max.bubnov.roadmap.service.CityService;
import max.bubnov.roadmap.service.RoadService;
import max.bubnov.roadmap.utils.LengthUtil;

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

    public List<Road> getRoadsByCityName(String name) {
        return cityService.getRoadsByCityName(name);
    }

    public boolean deleteRoad(Road road) {
        if(road != null) {
            roadService.delete(road);
            List<City> allCity = cityService.findAll();
            for (City city : allCity) {
                List<Road> roads = city.getRoads();
                for (Road road1 : roads) {
                    if (road1.equals(road)) {
                        roads.remove(road1);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return false;
    }
}

