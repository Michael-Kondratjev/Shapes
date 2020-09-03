package by.epam.sphere.main;

import by.epam.sphere.entity.Sphere;
import by.epam.sphere.exception.SphereException;
import by.epam.sphere.parser.LineParser;
//
public class Main {
    public static void main(String[] args) {
        LineParser lineParser = new LineParser();
        Sphere sphere = null;
        try {
            sphere = lineParser.parseLineToSphere("1 2 3a 4");
        } catch (SphereException e) {
            e.printStackTrace();
        }
        System.out.println(sphere);
    }
}
