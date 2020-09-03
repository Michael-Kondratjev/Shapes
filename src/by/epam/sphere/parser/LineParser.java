package by.epam.sphere.parser;

import by.epam.sphere.entity.Sphere;
import by.epam.sphere.exception.SphereException;
import by.epam.sphere.factory.SphereFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineParser {

    private static final Logger logger = LogManager.getLogger();
    private static final String DELIMETER = "\\s+";

    public Sphere parseLineToSphere(String line) throws SphereException {

        double[] fourValues = new double[Sphere.FOUR_VALUES];
        line = line.trim();
        String[] arrayString = line.split(DELIMETER);
            if (arrayString.length == Sphere.FOUR_VALUES) {
                for (int i = 0; i < arrayString.length; i++) {
                    try {
                        fourValues[i] = Double.parseDouble(arrayString[i]);
                    } catch (NumberFormatException e) {
                        logger.log(Level.ERROR,
                                "This line does not contain valid data to create a sphere.");
                        throw new SphereException(
                                "This line does not contain valid data to create a sphere");
                    }
                }
            } else {
                logger.log(Level.ERROR, "This line does not contain valid data to create a sphere.");
                throw new SphereException("This line does not contain valid data to create a sphere");
            }
        return SphereFactory.createSphere(fourValues);
    }
}
