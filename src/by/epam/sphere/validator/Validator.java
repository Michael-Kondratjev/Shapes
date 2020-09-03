package by.epam.sphere.validator;

import by.epam.sphere.entity.Sphere;

public class Validator {

    public static boolean validateRadius(double radius)  {
        return radius > 0;
    }

    public static boolean validateRadius(double[] mas)  {
        return validateRadius(mas[3]);
    }

    public static boolean validateArrayLength(double[] coord)  {
        return coord.length == Sphere.FOUR_VALUES;
    }

    public static boolean validateSphere(Object obj)  {
        return obj instanceof Sphere;
    }
//
}
