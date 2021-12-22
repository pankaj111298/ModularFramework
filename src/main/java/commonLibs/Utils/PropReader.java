package commonLibs.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropReader {

    public static Properties getProperties(String filename) throws IOException {
        String currentWorkingDirectory = System.getProperty("user.dir");
        filename = filename.trim();
        Properties properties = new Properties();
        properties.load(new FileInputStream(currentWorkingDirectory + filename));
        return properties;
    }
}
