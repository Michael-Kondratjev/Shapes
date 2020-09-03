package by.epam.sphere.parser;

import by.epam.sphere.entity.Sphere;
import by.epam.sphere.exception.SphereException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LineParserTest {

    LineParser lp;

    @BeforeClass
    public void setLp() {
        lp = new LineParser();
    }

    @Test
    public void parseValidLineTest() throws SphereException {
        String validLine = "1 2 3 4";
        Sphere expected = new Sphere(1,2,3,4);
        Sphere actual = lp.parseLineToSphere(validLine);
        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = SphereException.class)
    public void parseShortLineTest() throws SphereException {
        String shortLine = "1 2 3";
        lp.parseLineToSphere(shortLine);
    }

    @Test(expectedExceptions = SphereException.class)
    public void parseLongLineTest() throws SphereException {
        String longLine = "1 2 3 4 5";
        lp.parseLineToSphere(longLine);
    }

    @Test(expectedExceptions = SphereException.class)
    public void parseInvalidLineTest() throws SphereException {
        String invalidLine = "1 2 3 4a";
        lp.parseLineToSphere(invalidLine);
    }

    @Test(expectedExceptions = SphereException.class)
    public void parseInvalidRadiusTest() throws SphereException {
        String invalidLineNegativeRadius = "1 2 3 -4";
        lp.parseLineToSphere(invalidLineNegativeRadius);
    }





}
