package by.epam.sphere.exceptions;

import by.epam.sphere.exception.SphereException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SphereExceptionTest {

    @Test(expectedExceptions = SphereException.class,
            expectedExceptionsMessageRegExp = "This is new SphereException.")
    public void generateSphereExceptionMessageTest() throws SphereException {
        throw new SphereException("This is new SphereException.");
    }

    @Test(expectedExceptions = SphereException.class)
    public void generateSphereExceptionCauseTest() throws SphereException {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw new SphereException(e);
        }
    }

    @Test(expectedExceptions = SphereException.class,
            expectedExceptionsMessageRegExp = "This is new SphereException with cause.")
    public void generateSphereExceptionMessageCauseTest() throws SphereException {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw new SphereException("This is new SphereException with cause.", e);
        }
    }
}
