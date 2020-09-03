package by.epam.sphere.generator;

public class GeneratorId {

    private static long id;

    public static long generateId() {
        if (id >= Long.MAX_VALUE || id <0) {
            id = 0;
        }
        return ++id;
    }

    public static void setId(long value) {
        id = value;
    }

    public static long getId() { return id;  }
}
