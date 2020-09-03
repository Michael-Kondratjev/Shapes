package by.epam.sphere.entity;

import by.epam.sphere.generator.GeneratorId;

public class Point {

    private double x,y,z;
    private long pointId;

    public Point(double a, double b) {
        x = a; y = b; z = 0;
        pointId = GeneratorId.generateId();
    }

    public Point(double a, double b, double c) {
        x = a; y = b; z = c;
        pointId = GeneratorId.generateId();
    }

    public Point(Point p) {
        this.x = p.x; this.y = p.y; this.z = p.z;
        pointId = GeneratorId.generateId();
    }

    public double getX() { return x;     }
    public double getY() { return y;     }
    public double getZ() { return z;     }

    public void setX(double x) { this.x = x;    }
    public void setY(double y) { this.y = y;    }
    public void setZ(double z) { this.z = z;    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;

        return this.x == other.x && this.y == other.y && this.z == other.z;
    }

    @Override
    public int hashCode() {
        double result;
        result = 13*(x+y+pointId);
        result += 7*(y+z-pointId);
        result += 10*(z+x);
        return (int) result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
              sb.append("Point. Coordinates: [")
                .append(getX())
                .append(",")
                .append(getY())
                .append(",")
                .append(getZ())
                .append("]  pointId=")
                .append(pointId);
        return sb.toString();
    }
}

