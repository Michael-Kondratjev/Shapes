package by.epam.sphere.repository;

import by.epam.sphere.entity.impl.Sphere;
import by.epam.sphere.exception.SphereException;
import by.epam.sphere.parser.LineParser;
import by.epam.sphere.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SphereRepository {
    private static SphereRepository instance;
    private List<Sphere> sphereList = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger();

    private SphereRepository(){}

    public static SphereRepository getInstance() {
        if (instance == null) {
            instance = new SphereRepository();
        }
        return instance;
    }

    public void add(Sphere sphere) {
        sphereList.add(sphere);
    }

    public void addFromFile(String filename) throws SphereException {
        LineParser lineParser = new LineParser();
        DataReader dataReader = new DataReader();
        List<String> lineList = dataReader.fileInListReader(filename);
        for (String line : lineList) {
            try {
                Sphere sphere = lineParser.parseLineToSphere(line);
                sphereList.add(sphere);
            } catch (SphereException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void remove(Sphere sphere) {
        sphereList.remove(sphere);
    }

    public List<Sphere> getSphereList() {
        return sphereList;
    }
}
