package by.epam.sphere.reader;

import by.epam.sphere.exception.SphereException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataReaderTest {
    DataReader dataReader;

    @BeforeClass
    public void setDataReader() {
        dataReader = new DataReader();
    }

    @Test
    public void dataReaderTest() throws SphereException {
        List<String> actual = new ArrayList<>();
        actual.add("1 1 1 1");
        actual.add("");
        actual.add("2 2 2 2");
        actual.add("0 3 0 3");

        List<String> expected = new ArrayList<>();
        expected = dataReader.fileInListReader(
                "test/resources/DataReaderTest.txt");

        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = SphereException.class, expectedExceptionsMessageRegExp = "Reading file error")
    public void dataReaderExceptionTest() throws SphereException {
        List<String> stringList = dataReader.fileInListReader("wrong path");
    }
}
