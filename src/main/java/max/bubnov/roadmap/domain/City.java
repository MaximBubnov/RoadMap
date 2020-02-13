package max.bubnov.roadmap.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class City {

    private String name;
    private double x;
    private double y;

    private List<Road> roads;

    public City(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        roads = new CopyOnWriteArrayList<>();
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Город: " +
                "'" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", \n Список дорог : " + roads +
                '\n';
    }
}
