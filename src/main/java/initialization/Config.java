package initialization;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//Singleton class(means that we can have only one instance of it)
public class Config {

    private Properties configFile;

    private static Config instance;

    private String config_file = "config.cfg";
    private String config_file_path = System.getProperty("user.dir") + "\\" + config_file;

    private Config() {
        if (!new File(config_file_path).isFile()) { // If config file doesn't exist, create it and fill it with default values
            initConfig();
            System.out.println("Default config file has been created in '" + System.getProperty("user.dir") + "'. Please, fill it with your values and run the script again.");
            System.exit(0);
        }

        configFile = new Properties();
        try {
            InputStream cfg_resource = new FileInputStream(config_file_path);
            configFile.load(cfg_resource);
        } catch (Exception eta) {
            eta.printStackTrace();
        }
    }

    private void initConfig() {
        try {
            new File(System.getProperty("user.dir") + "/config.cfg").createNewFile();
            Map<String, String> cfgValues = new HashMap<String, String>();
            cfgValues.put("user_name", "[User name]");
            cfgValues.put("browser", "[Chrome or Firefox]");
            cfgValues.put("browser_version", "[Number without decimals]");
            cfgValues.put("db_username", "[DB user name]");
            cfgValues.put("db_password", "[DB password]");
            cfgValues.put("db_url", "[DB URL]");
            cfgValues.put("autotest_db_username", "[Autotests DB user name]");
            cfgValues.put("autotest_db_password", "[Autotests DB password]");
            cfgValues.put("autotest_db_url", "[Autotests DB URL]");
            for (Map.Entry<String, String> entry : cfgValues.entrySet()) {
                setConfigValue(entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setConfigValue(String key, String value)  {
        try {
            Properties prop = new Properties();
            InputStream in = new FileInputStream(config_file_path);
            prop.load(in);
            prop.setProperty(key, value);
            prop.store(new FileOutputStream(config_file_path), null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getUser(){
        return getProperty("user_name");
    }

    public static String getBrowser(){
        return getProperty("browser");
    }

    public static String getBrowserVersion(){
        return getProperty("browser_version");
    }

    public static String getAutotestDbusername() {
        return getProperty("autotest_db_name");
    }

    public static String getAutotestDbpassword() {
        return getProperty("autotest_db_password");
    }

    public static String getAutotestDbUrl() {
        return getProperty("autotest_db_url");
    }

    public static String getDbUsername() {
        return getProperty("db_username");
    }

    public static String getDbPassword() {
        return getProperty("db_password");
    }

    public static String getDbUrl() {
        return getProperty("db_url");
    }


    private String getValue(String key) {
        if(configFile.getProperty(key) == null){
            System.out.println("Property '"+key+"' does not exist in config file.");
            System.exit(0);
        }
        return configFile.getProperty(key);
    }

    public static String getProperty(String key) {
        if (instance == null) instance = new Config();
        return instance.getValue(key);
    }

}