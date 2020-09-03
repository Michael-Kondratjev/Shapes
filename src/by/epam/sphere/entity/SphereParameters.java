package by.epam.sphere.entity;

import by.epam.sphere.action.ParametersCalculation;

public class SphereParameters {
    private long sphereId;
    private double volume;
    private double area;

    public SphereParameters(Sphere sphere) {
        ParametersCalculation parametersCalculation = new ParametersCalculation();
        volume = parametersCalculation.volume(sphere);
        area = parametersCalculation.area(sphere);
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
}
