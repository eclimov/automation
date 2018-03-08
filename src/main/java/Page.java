import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getElement;

public class Page extends Initialization{

    // TODO: Get credentials from file
    static void login(CharSequence login, CharSequence password) {
        $("input[name*='login'], input[id*='login']").sendKeys(login);
        $("input[name*='pass'], input[id*='pass']").sendKeys(password);
        $("form[class*='login'], form[name*='login'], form[id*='login']").submit();
    }
}
