import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.testng.annotations.*;

public class TestClass {
    @Test
    public void userCanLoginByUsername() {
        Configuration.reportsFolder = System.getProperty("user.dir")+"/reports";
        /*
        open("/login"); //Local
        $(By.name("username")).setValue("johny");
        $("#submit").click();
        $(".success-message").shouldHave(text("Hello, Johny!"));
        */

        open("https://www.google.md/");
        $("#lst-ib").setValue("Искать");
        //takeScreenShot("my-test-case");
        $("input[name='btnK']").click();

        $("#lst-ib").shouldNot(visible);

    }
}
