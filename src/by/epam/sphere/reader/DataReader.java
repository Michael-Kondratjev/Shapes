package by.epam.sphere.reader;

import by.epam.sphere.exception.SphereException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static final Logger logger = LogManager.getLogger();

    public List<String> fileInListReader(String filePath) throws SphereException {

        List<String> stringList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String str = "";
            while ((str = br.readLine()) != null) {
                stringList.add(str);
            }
        } catch (IOException e) {
                logger.log(Level.ERROR, "Reading file error");
                throw new SphereException("Reading file error", e);
        }
        return stringList;
    }
}
