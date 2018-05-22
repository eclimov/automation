import org.testng.annotations.Test;
import pages.Page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Sandbox extends Page {

    @Test
    public void sandboxMethod() {
        /*
        open("/login"); //Local
        $(By.name("username")).setValue("johny");
        $("#submit").click();
        $(".success-message").shouldHave(text("Hello, Johny!"));
        */

        /*
        open("https://www.google.md/");
        $("#lst-ib").setValue("search by any string");
        //takeScreenShot("my-test-case");
        $("input[name='btnK']").click();
        $("#lst-ib").shouldNot(visible);
        */

        /*
        open("https://www.google.md/");
        //login("myLogin", "myPassword");
        $("#lst-ib").setValue("Test").submit();
        $("#lst-ib").should(visible);
        */

        open("https://sites.google.com/a/chromium.org/chromedriver/downloads");
    }
}
