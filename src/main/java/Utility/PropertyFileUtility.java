package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

    private final String propertyPath = "./src/test/resources/CommonData.properties";

    public String fetchdatafrompropertyfile(String key) throws IOException {

        Properties p = new Properties();

        try (FileInputStream fis = new FileInputStream(propertyPath)) {
            p.load(fis);
        }

        return p.getProperty(key);
    }

    public void writeBackDatatoPropertyfile(String key, String value) throws IOException {

        Properties p = new Properties();

        try (FileInputStream fis = new FileInputStream(propertyPath)) {
            p.load(fis);
        }

        p.setProperty(key, value);

        try (FileOutputStream fos = new FileOutputStream(propertyPath)) {
            p.store(fos, "Property file updated");
        }
    }
}
