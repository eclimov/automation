import java.io.*;
import java.util.Properties;
import java.util.Scanner;

//Singleton class(means that we can call it from anywhere without creating actual object)
public class Config {

    private Properties configFile;

    private static Config instance;

    private Config() {
        // TODO: create config file if not exists and fill it with values
        // TODO(alt): prepare and commit default cfg file, that will be then changed manually by user
        configFile = new java.util.Properties();
        try {
            String config_file = "config.cfg";
            InputStream cfg_resource = getClass().getResourceAsStream(config_file);

            if(cfg_resource == null){
                /*
                https://stackoverflow.com/questions/17554085/how-to-create-a-file-in-src-main-resources
                System.out.println("QWERTY");
                Scanner scanner = new Scanner(cfg_resource);
                scanner.close();
                */
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
        System.out.println(configFile.getProperty(key));
        if(configFile.getProperty(key) == null){
            System.out.println("Property '"+key+"' does not exist in config file.");
            return "";
        }
        return configFile.getProperty(key);
    }

    public static String getProperty(String key) {
        if (instance == null) instance = new Config();
        return instance.getValue(key);
    }

    public static String getUser(){
        return getProperty("user");
    }

    public static String getBrowser(){
        return getProperty("browser");
    }

    public static String getBrowserVersion(){
        return getProperty("browser_version");
    }
}