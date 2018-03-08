import java.util.Properties;

public class Config {

    private Properties configFile;

    private static Config instance;

    private Config() {
        // TODO: create config file if not exists and fill it with values
        configFile = new java.util.Properties();
        try {
            //configFile.load(this.getClass().getClassLoader().getResourceAsStream(config_path));
            //configFile.load(new FileInputStream(config_path));
            configFile.load(getClass().getResourceAsStream("config.cfg")); //file in "\src\main\resources"
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