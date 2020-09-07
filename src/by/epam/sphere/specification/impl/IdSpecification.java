package by.epam.sphere.specification.impl;

import by.epam.sphere.entity.impl.Sphere;
import by.epam.sphere.specification.SphereSpecification;

public class IdSpecification implements SphereSpecification {
    private long id;

    public IdSpecification(long id){
        this.id = id;
    }

    @Override
    public boolean specify(Sphere sphere) {
        return this.id == sphere.getId();
    }
}
