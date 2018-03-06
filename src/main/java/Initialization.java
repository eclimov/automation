import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

public class Initialization {
    @BeforeTest
    public void beforeTest(){
        Configuration.browser = "chrome";
        String chromedriver_version = "2.34"; //Set version of Chromedriver that supports your version of browser
        /*chromedriver releases:
            https://sites.google.com/a/chromium.org/chromedriver/downloads
            https://chromedriver.storage.googleapis.com/2.26/notes.txt
        */

        //WebDriverManager: http://automation-remarks.com/selenium-webdriver-manager/index.html
        WebDriverManager.chromedriver().version(chromedriver_version).setup();

    }
}
