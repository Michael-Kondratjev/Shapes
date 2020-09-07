package by.epam.sphere.specification.impl;

import by.epam.sphere.action.Calculation;
import by.epam.sphere.entity.impl.Sphere;
import by.epam.sphere.specification.SphereSpecification;

public class FromOriginSpecification implements SphereSpecification {
    private double distance;

    public FromOriginSpecification(double distance){
        this.distance = distance;
    }

    @Override
    public boolean specify(Sphere sphere) {
        Calculation parametersCalculation = new Calculation();
        double distanceToCenter = parametersCalculation.distanceFromOriginToCenter(sphere);
        return distance >= (distanceToCenter + sphere.getRadius());
    }
}
