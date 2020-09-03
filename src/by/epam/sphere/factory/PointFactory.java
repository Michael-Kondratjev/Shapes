package by.epam.sphere.factory;

import by.epam.sphere.entity.Point;

public class PointFactory {

    public static Point createPoint(double x, double y, double z) {
        return new Point(x,y,z);
    }
}
