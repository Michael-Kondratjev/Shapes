package by.epam.sphere.entity;

import by.epam.sphere.action.Calculation;
import by.epam.sphere.entity.impl.Sphere;

public class SphereParameters {
    private long sphereId;
    private double volume;
    private double area;

    public SphereParameters(Sphere sphere) {
        Calculation calculation = new Calculation();
        volume = calculation.volume(sphere);
        area = calculation.area(sphere);
        sphereId = sphere.getId();
    }

    public double getArea() {
        return area;
    }
    public double getVolume() {
        return volume;
    }
    public long getSphereId() {
        return sphereId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SphereParameters that = (SphereParameters) o;
        return sphereId == that.sphereId &&
                Double.compare(that.volume, volume) == 0 &&
                Double.compare(that.area, area) == 0;
    }

    @Override
    public int hashCode() {
        return (int) (volume * area + area * sphereId - volume * sphereId);
    }

    @Override
    public String toString() {
        return "SphereParameters{" +
                "sphereId=" + sphereId +
                ", volume=" + volume +
                ", area=" + area +
                '}';
    }
}
