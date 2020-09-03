package by.epam.sphere.generator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GeneratorIdTest {

    @Test
    public void generateIdTest() {
        long expected = 1L;
        long actual = GeneratorId.generateId();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void setIdTest() {
        GeneratorId.setId(3);
        long expected = 3L;
        long actual = GeneratorId.getId();
        Assert.assertEquals(actual,expected);
    }
}
