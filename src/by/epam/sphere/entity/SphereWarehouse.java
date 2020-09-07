package by.epam.sphere.entity;

import java.util.HashMap;
import java.util.Map;

public class SphereWarehouse {
    private static SphereWarehouse instance;
    private static Map<Long,SphereParameters> sphereParametersMap =
            new HashMap<>();

    private SphereWarehouse(){}

    public static SphereWarehouse getInstance(){
        if (instance == null) {
            instance = new SphereWarehouse();
        }
        return instance;
    }

    public  SphereParameters get(Long sphereId) {
        return sphereParametersMap.get(sphereId);
    }

    public  SphereParameters put(Long sphereId, SphereParameters sphereParam) {
        return sphereParametersMap.put(sphereId, sphereParam);
    }

    public  SphereParameters remove(Long sphereId) {
        return sphereParametersMap.remove(sphereId);
    }

    public void replace(Long sphereId, SphereParameters sphereParam) {
        sphereParametersMap.replace(sphereId, sphereParam);
    }

    public static Map<Long, SphereParameters> getSphereParametersMap() {
        return sphereParametersMap;
    }
}
