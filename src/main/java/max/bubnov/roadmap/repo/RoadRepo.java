package max.bubnov.roadmap.repo;

import max.bubnov.roadmap.domain.Road;

import java.util.List;

public interface RoadRepo {

    List<Road> findAll();

    Road findByName(String name);

    boolean createRoad(Road road);


    void delete(Road road);
}
