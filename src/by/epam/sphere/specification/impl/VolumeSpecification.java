package by.epam.sphere.specification.impl;

import by.epam.sphere.action.Calculation;
import by.epam.sphere.entity.impl.Sphere;
import by.epam.sphere.specification.SphereSpecification;

public class VolumeSpecification implements SphereSpecification {
    private double min;
    private double max;

    public VolumeSpecification(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(Sphere sphere) {
        Calculation parametersCalculation = new Calculation();
        double volume = parametersCalculation.volume(sphere);
        return volume >= min
                && volume <= max;
    }
}
