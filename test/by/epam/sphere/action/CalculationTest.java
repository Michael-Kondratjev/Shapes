package by.epam.sphere.action;

import by.epam.sphere.entity.impl.Sphere;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculationTest {

    Calculation pc;
    Sphere sp;

    @BeforeClass
    public void setUp() {
        pc = new Calculation();
        sp = new Sphere(0,0,0,5);
    }

    @Test
    public void testArea() {
        double actual;
        double expected;
        actual = pc.area(sp);
        expected = 100 * Math.PI;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testVolume() {
        double actual;
        double expected;
        actual = pc.volume(sp);
        expected = 523.59;
        Assert.assertEquals(expected, actual, 0.01);
    }


}