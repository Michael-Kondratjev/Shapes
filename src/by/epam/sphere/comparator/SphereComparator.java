package by.epam.sphere.comparator;

import by.epam.sphere.entity.impl.Sphere;

import java.util.Comparator;

public enum SphereComparator implements Comparator<Sphere> {
    ID {
        @Override
        public int compare(Sphere o1, Sphere o2) {
            return Long.compare(o1.getId(),o2.getId());
        }
    },
    RADIUS {
        @Override
        public int compare(Sphere o1, Sphere o2) {
            return Double.compare(o1.getRadius(), o2.getRadius());
        }
    },
    X {
        @Override
        public int compare(Sphere o1, Sphere o2) {
            return Double.compare(o1.getCenter().getX(), o2.getCenter().getX());
        }
    },
    Y {
        @Override
        public int compare(Sphere o1, Sphere o2) {
            return Double.compare(o1.getCenter().getY(), o2.getCenter().getY());
        }
    },
    Z {
        @Override
        public int compare(Sphere o1, Sphere o2) {
            return Double.compare(o1.getCenter().getZ(), o2.getCenter().getZ());
        }
    }
}
