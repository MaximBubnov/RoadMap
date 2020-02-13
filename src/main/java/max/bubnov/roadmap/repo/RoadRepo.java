package max.bubnov.roadmap.repo;

import max.bubnov.roadmap.domain.Road;

import java.util.List;

public interface RoadRepo {

    List<Road> findAll();

    Road findByName(String name);

    //API # 2
    boolean createRoad(Road road);
    //API # 3
    boolean delete(Road road);
}
