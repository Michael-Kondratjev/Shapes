package by.epam.sphere.factory;

import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.impl.Sphere;
import by.epam.sphere.exception.SphereException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static by.epam.sphere.factory.SphereFactory.createSphere;


public class SphereFactoryTest {

    Sphere validSphere;

    @BeforeClass
    public void setValidSphere() {
        validSphere = new Sphere(0,0,0,5);
    }

    @Test
    public void createSphereFromNumberTest() throws SphereException {
        Sphere expected = validSphere;
        Sphere actual = createSphere(0,0,0,5);
        Assert.assertEquals(actual,expected);
    }

    @Test(expectedExceptions = SphereException.class, expectedExceptionsMessageRegExp =
                    "The radius of the sphere must be greater than zero.")
    public void createSphereFromNumberNegativeRadiusTest() throws SphereException {
        Sphere actual = createSphere(0,0,0,-5);
    }

    @Test
    public void createSphereFromPointTest() throws SphereException {
        Sphere expected = validSphere;
        Sphere actual = createSphere(new Point(0,0,0),5);
        Assert.assertEquals(actual,expected);
    }

    @Test(expectedExceptions = SphereException.class)
    public void createSphereFromNullPointTest() throws SphereException {
        Sphere sphere = createSphere(null,5);
    }

    @Test
    public void createSphereFromArrayTest() throws SphereException {
        Sphere expected = validSphere;
        Sphere actual = createSphere(new double[] {0,0,0,5});
        Assert.assertEquals(actual,expected);
    }

    @Test(expectedExceptions = SphereException.class, expectedExceptionsMessageRegExp =
            "Invalid array lenght. The array must be four numbers")
    public void createSphereFromArrayWrongLenghtTest() throws SphereException {
        Sphere actual = createSphere(new double[] {0,0,0,5,5});
    }

    @Test
    public void createSphereFromSphereTest() throws SphereException {
        Sphere expected = validSphere;
        Sphere actual = createSphere(validSphere);
        Assert.assertEquals(actual,expected);
    }

    @Test(expectedExceptions = SphereException.class)
    public void createSphereFromNullSphereTest() throws SphereException {
        Sphere sphere = createSphere((Sphere) null);
    }

}
