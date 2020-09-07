package by.epam.sphere.entity.impl;

import by.epam.sphere.entity.Observable;
import by.epam.sphere.entity.Point;
import by.epam.sphere.exception.SphereException;
import by.epam.sphere.factory.PointFactory;
import by.epam.sphere.generator.GeneratorId;
import by.epam.sphere.observer.impl.SphereObserver;
import by.epam.sphere.validator.Validator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sphere implements Observable {

   public static final int FOUR_VALUES = 4;
   private long sphereId;
   private Point center;
   private double radius;

    private static final Logger logger = LogManager.getLogger();

    public Sphere(double a, double b, double c, double r)  {
        center = PointFactory.createPoint(a, b, c);
        radius = r;
        sphereId = GeneratorId.generateId();
    }

    public Sphere(Point p, double r) {
        center = p;
        radius = r;
        sphereId = GeneratorId.generateId();
    }

    public Sphere(double [] coord) {
        center = PointFactory.createPoint(coord[0], coord[1], coord[2]);
        radius = coord[3];
        sphereId = GeneratorId.generateId();
    }

    public Sphere(Sphere sp) {
        center = sp.getCenter();
        radius = sp.getRadius();
        sphereId = GeneratorId.generateId();
        }

    public void setCenter(Point p) {
        this.center = p;
        notifyObserver();
    }

    public void setCenter(double a, double b, double c) {
        this.center = PointFactory.createPoint(a,b,c);
        notifyObserver();
    }

    public void setRadius(double radius) throws SphereException {
        if(Validator.validateRadius(radius)) {
            this.radius = radius;
            notifyObserver();
        } else {
            logger.log(Level.ERROR, "The radius of the sphere must be greater than zero.");
            throw new SphereException("The radius of the sphere must be greater than zero.");
        }

    }

    public void setX(double x) {
        setCenter(x,center.getY(),center.getZ());
        notifyObserver();
    }
    public void setY(double y) {
        setCenter(center.getX(),y,center.getZ());
        notifyObserver();
    }
    public void setZ(double z) {
        setCenter(center.getX(),center.getY(),z);
        notifyObserver();
    }

    public void setSphereId(long value) { sphereId = value;     }

    public Point getCenter() { return center;     }
    public double getRadius() { return radius;    }
    public long getId() { return sphereId;   }

    @Override
     public void notifyObserver(){
        SphereObserver sphereObserver = new SphereObserver();
        sphereObserver.updateWarehouse(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Sphere other = (Sphere) obj;

        return this.radius == other.radius && this.center.equals(other.center);
    }

    @Override
    public int hashCode() {
        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();
        double result;
        result = 13*(x+y+sphereId);
        result += 7*(y+z-sphereId);
        result += 10*(z+x);
        return (int) result;
}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
              sb.append("Sphere. Center coordinates: [")
                .append(center.getX())
                .append(",")
                .append(center.getY())
                .append(",")
                .append(center.getZ())
                .append("] radius=")
                .append(radius)
                .append("  sphereId=")
                .append(sphereId);

        return sb.toString();
    }

}
