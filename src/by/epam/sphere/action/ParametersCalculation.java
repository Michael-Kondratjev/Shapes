package by.epam.sphere.action;

import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.Sphere;

public class ParametersCalculation {

    // sphere surface area
    public double area(Sphere sphere) {
        return 4 * Math.PI * Math.pow(sphere.getRadius(), 2);
    }

    // ball touching coordinate plane
    public boolean touch(Sphere sphere) {
        double r = sphere.getRadius();
        Point p = sphere.getCenter();
        double x = Math.abs(p.getX());
        double y = Math.abs(p.getY());
        double z = Math.abs(p.getZ());
        return r == x || r == y || r == z;
    }

    // sphere volume
    public double volume(Sphere sphere){
        return 4 * Math.PI * Math.pow(sphere.getRadius(),3) / 3;
    }

}



