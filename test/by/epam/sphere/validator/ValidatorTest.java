package by.epam.sphere.validator;

import by.epam.sphere.entity.impl.Sphere;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidatorTest {

    @Test
    public void validateRadiusTest() {
        double r = 1;
        Assert.assertTrue(Validator.validateRadius(r));
    }

    @Test
    public void validateRadiusInArrayTest() {
        double[] array = {1,1,1,-1};
        Assert.assertFalse(Validator.validateRadius(array));
    }

    @Test
    public void validateArrayLengthTest() {
        double[] array = {1,1,1,-1};
        Assert.assertTrue(Validator.validateArrayLength(array));
    }

    @Test
    public void validateSphereTestNegative() {
        Assert.assertFalse(Validator.validateSphere(1));
    }

    @Test
    public void validateSphereTestPositive() {
        Sphere sphere = new Sphere(0,0,0,1);
        Assert.assertTrue(Validator.validateSphere(sphere));
    }

    @Test
    public void touchTest() {
        Sphere sphere = new Sphere(0,0,6,6);
        Assert.assertTrue(Validator.touchPlaneXY(sphere));
    }

    @Test
    public void noTouchTest() {
        Sphere sphere = new Sphere(6,6,6,5);
        Assert.assertFalse(Validator.touchPlaneXY(sphere));
    }

    @Test
    public void intersectedByPlaneXYTest() {
        Sphere sphere = new Sphere(0,0,5,6);
        Assert.assertTrue(Validator.touchPlaneXY(sphere));
    }

    @Test
    public void noIntersectedByPlaneXYTest() {
        Sphere sphere = new Sphere(0,0,7,6);
        Assert.assertFalse(Validator.touchPlaneXY(sphere));
    }



}
