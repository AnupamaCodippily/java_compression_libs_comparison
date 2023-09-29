package io.avcode;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class Configuration {

    public static String OUTPUT_PATH = "";

    public void create() throws NullPointerException, IOException {
        URL url = getClass().getClassLoader().getResource("application.yml");
        String path = url.getPath();
        File configFile = new File(path);

        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(new FileInputStream(configFile));

        Map<String, String> properties = (Map<String, String>) data.get("properties");

        OUTPUT_PATH = properties.get("output_folder_path");
    }

}
