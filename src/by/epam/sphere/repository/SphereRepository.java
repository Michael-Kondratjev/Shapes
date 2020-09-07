package by.epam.sphere.repository;

import by.epam.sphere.entity.impl.Sphere;

import java.util.ArrayList;
import java.util.List;

public class SphereRepository {
    private static SphereRepository instance;
    private List<Sphere> spheres = new ArrayList<>();

    private SphereRepository(){}

    public static SphereRepository getInstance() {
        if (instance == null) {
            instance = new SphereRepository();
        }
        return instance;
    }

    public void add(Sphere sphere) {
        spheres.add(sphere);
    }

    public void remove(Sphere sphere) {
        spheres.remove(sphere);
    }

    public List<Sphere> getSpheres() {
        return spheres;
    }
}
