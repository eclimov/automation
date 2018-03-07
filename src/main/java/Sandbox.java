import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Sandbox extends Page {

    @Test
    public void sandboxMethod() {
        Configuration.reportsFolder = System.getProperty("user.dir")+"/reports";
        /*
        open("/login"); //Local
        $(By.name("username")).setValue("johny");
        $("#submit").click();
        $(".success-message").shouldHave(text("Hello, Johny!"));
        */

        open("https://www.google.md/");
        $("#lst-ib").setValue("search by any string");
        //takeScreenShot("my-test-case");
        $("input[name='btnK']").click();

        $("#lst-ib").shouldNot(visible);
    }
}
