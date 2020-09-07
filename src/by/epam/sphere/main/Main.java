package by.epam.sphere.main;

import by.epam.sphere.entity.impl.Sphere;
import by.epam.sphere.exception.SphereException;
import by.epam.sphere.factory.SphereFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args)  {

        Sphere sphere = null;
        try {
            sphere = SphereFactory.createSphere(0,0,0,-1);
        } catch (SphereException e) {
            logger.log(Level.ERROR, "message");
            e.printStackTrace();
        }
        System.out.println(sphere);
    }
}
