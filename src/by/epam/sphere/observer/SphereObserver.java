package by.epam.sphere.observer;

import by.epam.sphere.entity.Sphere;
import by.epam.sphere.entity.SphereParameters;
import by.epam.sphere.entity.SphereWarehouse;

public class SphereObserver {

    public void updateWarehouse(Sphere sphere){
        SphereParameters sphereParameters = new SphereParameters(sphere);

        SphereWarehouse sphereWarehouse = SphereWarehouse.getInstance();
        sphereWarehouse.replace(sphere.getId(), sphereParameters);
    }
}
