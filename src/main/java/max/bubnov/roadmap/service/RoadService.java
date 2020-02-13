package max.bubnov.roadmap.service;

import max.bubnov.roadmap.domain.Road;
import max.bubnov.roadmap.repo.RoadRepo;

import java.util.ArrayList;
import java.util.List;

public class RoadService implements RoadRepo {

    private List<Road> roads = new ArrayList<>();

    @Override
    public List<Road> findAll() {
        return roads;
    }

    @Override
    public Road findByName(String name) {
        if(roads != null && name != null) {
            return roads.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        } else {
            return null;
        }
    }

    @Override
    public boolean createRoad(Road road) {
        long count = roads.stream().filter(x -> x.equals(road)).count();
        if(count == 0) {
            return roads.add(road);
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Road road) {
        if(road != null && findAll().contains(road)) {
            System.out.println("Дорога успешно удалена. Для проверки API 7");
            return roads.remove(findByName(road.getName()));
        } else {
            System.out.println("Такой дороги не найдено!");
        }
        return false;
    }
}
