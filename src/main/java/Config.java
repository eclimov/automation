import java.io.*;
import java.util.Properties;

//Singleton class(means that we can call it from anywhere without creating actual object)
public class Config {

    private Properties configFile;

    private static Config instance;

    private Config() {
        // TODO: create config file if not exists and fill it with values
        configFile = new java.util.Properties();
        try {
            String config_file = "config.cfg";
            InputStream cfg_resource = getClass().getResourceAsStream(config_file);

            if(cfg_resource == null){
                System.out.println("Please, create a '"+config_file+"' configuration file in 'src/main/resources/' folder");
                System.exit(0);
            } else{
                configFile.load(cfg_resource); //file in "\src\main\resources"
            }
        } catch (Exception eta) {
            eta.printStackTrace();
        }
    }

    private String getValue(String key) {
        return configFile.getProperty(key);
    }

    public static String getProperty(String key) {
        if (instance == null) instance = new Config();
        return instance.getValue(key);
    }

    // TODO: make the following work
    /*
    private void setValue(String key, String value) {
        configFile.setProperty(key, value);
    }

    public static boolean setProperty(String key, String value) {
        if (instance == null) instance = new Config();
        instance.setValue(key, value);
        return true;
    }
    */
}