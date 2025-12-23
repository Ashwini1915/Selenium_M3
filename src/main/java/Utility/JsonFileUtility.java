package Utility;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileUtility {

    public String fetchDataFromJsonFile(String key) throws Exception {

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("./src/test/resources/testdata.json");

        Object obj = parser.parse(reader);
        JSONObject jobj = (JSONObject) obj;

        return jobj.get(key).toString();
    }
}
