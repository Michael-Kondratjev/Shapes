package by.epam.sphere.specification.impl;

import by.epam.sphere.entity.impl.Sphere;
import by.epam.sphere.specification.SphereSpecification;

public class RadiusSpecification implements SphereSpecification {
    private double min;
    private double max;

    public RadiusSpecification(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(Sphere sphere) {
        return sphere.getRadius() >= min
                && sphere.getRadius()<= max;
    }
}
