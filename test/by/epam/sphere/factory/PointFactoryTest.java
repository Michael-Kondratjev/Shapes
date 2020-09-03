package by.epam.sphere.factory;

import by.epam.sphere.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointFactoryTest {

    @Test
    public void  createPointTest() {
        Point expected = new Point(2,3,4);
        Point actual = PointFactory.createPoint(2,3,4);
        Assert.assertEquals(actual,expected);
    }
}
