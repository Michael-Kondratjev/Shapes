package by.epam.sphere.factory;

import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.impl.Sphere;
import by.epam.sphere.exception.SphereException;
import by.epam.sphere.validator.Validator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereFactory {

    private static final Logger logger = LogManager.getLogger();

    public static Sphere createSphere(double a, double b, double c, double r) throws SphereException {
        if (Validator.validateRadius(r)) {
            return new Sphere(a, b, c, r);
        } else {
            logger.log(Level.ERROR, "The sphere can't be created. The radius of the sphere must be greater than zero.");
            throw new SphereException("The radius of the sphere must be greater than zero.");
        }
    }

    public static Sphere createSphere(Point p, double r) throws SphereException {
        if (p == null) {
            throw new SphereException ("The sphere can't be created: center point is null.");
        }
        return createSphere(p.getX(),p.getY(),p.getZ(),r);
    }

    public static Sphere createSphere(double[] coord) throws SphereException {
        if (Validator.validateArrayLength(coord)) {
            return createSphere(coord[0], coord[1], coord[2], coord[3]);
         } else {
            logger.log(Level.ERROR,
                    "The sphere can't be created because of wrong number of coordinates. " +
                            "Only 4 coordinates are needed to create a sphere");
            throw new SphereException("Invalid array lenght. The array must be four numbers");
        }
    }

    public static Sphere createSphere(Sphere otherSphere) throws SphereException {
        if (otherSphere == null) {
            throw new SphereException ("New sphere can't be created: other sphere is null.");
        }
        return createSphere(otherSphere.getCenter(),otherSphere.getRadius());
    }

}
