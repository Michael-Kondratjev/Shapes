package by.epam.sphere.action;

import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.impl.Sphere;
import by.epam.sphere.exception.SphereException;
import by.epam.sphere.validator.Validator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculation {

    private static final Logger logger = LogManager.getLogger();

    public double area(Sphere sphere) {
        return 4 * Math.PI * Math.pow(sphere.getRadius(), 2);
    }

    public double volume(Sphere sphere){
        return 4 * Math.PI * Math.pow(sphere.getRadius(),3) / 3;
    }

    public double distanceFromOriginToCenter(Sphere sphere) {
        double r = sphere.getRadius();
        Point p = sphere.getCenter();
        double x = Math.abs(p.getX());
        double y = Math.abs(p.getY());
        double z = Math.abs(p.getZ());
        return Math.sqrt(x*x + y*y + z*z);
    }

// h - height of the spherical segment
    public double segmentVolume(Sphere sphere, double h) throws SphereException {
        String message =
                "The height of the spherical segment must be greater than zero" +
                "and less than the diameter";
        if (h <= 0 || h >= 2*sphere.getRadius()) {
            logger.log(Level.ERROR, message);
            throw new SphereException(message);
        }
        return Math.PI * h*h * (3*sphere.getRadius() - h) / 3;
    }

    public double segmentVolumeRatio(Sphere sphere, double lowerHight) throws SphereException {
        return segmentVolume(sphere, 2* sphere.getRadius() - lowerHight) /
                segmentVolume(sphere, lowerHight);
    }

    public double segmentHeightAbovePlaneXY(Sphere sphere) throws SphereException {
        if (Validator.intersectedByPlaneXY(sphere)) {
            double radius = sphere.getRadius();
            double z = sphere.getCenter().getZ();
            return radius + z;
        } else {
            logger.log(Level.ERROR, "The plane XY don't intersect this sphere.");
            throw new SphereException("The plane XY don't intersect this sphere");
        }
    }
}



