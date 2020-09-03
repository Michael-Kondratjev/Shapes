package by.epam.sphere.exception;

public class SphereException extends Exception {

    public SphereException(String message) {
        super(message);
    }

    public SphereException(String message, Throwable cause) {
        super(message, cause);
    }

    public SphereException(Throwable cause) {
        super(cause);
    }

}
