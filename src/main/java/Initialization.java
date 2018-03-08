import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

public class Initialization {
    @BeforeTest
    public void beforeTest(){
        Configuration.browser = "chrome";
        int chrome_version = 61;
        String chromedriver_version = getChromeDriverVersion(chrome_version);

        //WebDriverManager: http://automation-remarks.com/selenium-webdriver-manager/index.html
        WebDriverManager.chromedriver().version(chromedriver_version).setup();

    }

    private boolean between(int x, int min, int max){ //Number is between values inclusively
        return x>=min && x<=max;
    }

    // TODO: move the dataset into a separate file or database(ex.: SQLite)
    private String getChromeDriverVersion(int cv){ //Parameter - Chrome's version
        String chromedriver_version = "2.35";
        //Set version of Chromedriver that supports your version of browser
        /*chromedriver releases:
            https://sites.google.com/a/chromium.org/chromedriver/downloads
            https://chromedriver.storage.googleapis.com/2.26/notes.txt
        */
        if(between(cv, 62,64)){
            chromedriver_version = "2.35";
        } else if(between(cv, 61,63)){
            chromedriver_version = "2.34";
        } else if(between(cv, 60,62)){
            chromedriver_version = "2.33";
        } else if(between(cv, 58,60)){
            chromedriver_version = "2.32";
        } else if(between(cv, 56,58)){
            chromedriver_version = "2.29";
        } else if(between(cv, 54,56)){
            chromedriver_version = "2.27";
        } else if(between(cv, 52,54)){
            chromedriver_version = "2.24";
        } else if(between(cv, 49,52)){
            chromedriver_version = "2.22";
        }
        return chromedriver_version;
    }
}
