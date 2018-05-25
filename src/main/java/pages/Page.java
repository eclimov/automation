package pages;

import initialization.Initialization;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getElement;

public class Page extends Initialization {

    // TODO: create other pages, using subclass "Builder" to build a page, based different attributes(selectors selected, arguments passed, etc.)
    // https://stackoverflow.com/questions/1988016/named-parameter-idiom-in-java

    // TODO: Get credentials from file
    public void login(CharSequence login, CharSequence password) {
        $("input[id*='login'], input[name*='login'], input[class*='login']").sendKeys(login);
        $("input[id*='pass'], input[name*='pass'], input[class*='pass']").sendKeys(password);
        $("form[id*='login'], form[name*='login'], form[class*='login']").submit();
    }
}
