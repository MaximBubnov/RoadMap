package max.bubnov.roadmap.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Road {

    private String name;
    private double length;

    private List<City> cities;

    public Road(String name, double length) {
        this.name = name;
        this.length = length;
        cities = new ArrayList<>();
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return name.equals(road.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}
