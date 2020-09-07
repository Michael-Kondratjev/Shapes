package by.epam.sphere.validator;

import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.impl.Sphere;

public class Validator {

    public static boolean validateRadius(double radius)  {
        return radius > 0;
    }

    public static boolean validateRadius(double[] mas)  {
        return validateRadius(mas[3]);
    }

    public static boolean validateArrayLength(double[] coord)  {
        return coord.length == Sphere.FOUR_VALUES;
    }

    public static boolean validateSphere(Object obj)  {
        return obj instanceof Sphere;
    }

    public static boolean touchPlaneXY(Sphere sphere) {
        double r = sphere.getRadius();
        Point p = sphere.getCenter();
        double z = Math.abs(p.getZ());
        return r == z;
    }

    public static boolean intersectedByPlaneXY(Sphere sphere) {
        double r = sphere.getRadius();
        Point p = sphere.getCenter();
        double z = Math.abs(p.getZ());
        return z < r;
    }
}
