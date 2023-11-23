package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement searchIcon = $("[aria-label=\"search\"]");
    private final SelenideElement mainMenu = $(".nav--menu");
    public final ElementsCollection widgets = $$("h4");
    public final ElementsCollection listFooterMenu = $$("ul");


    public MainPage openPage() {
        open("https://www.baeldung.com/");

        return this;
    }

    public void clickSearchIcon() {
        searchIcon.click();
    }

    public void checkMainMenuTabs(String value) {
        mainMenu.shouldHave(text(value));
    }

    public void checkFooterWidget(String widget, String locator, List<String> list) {
        $$(locator).shouldHave(texts(list));
        $(locator).preceding(0).shouldHave(text(widget));
    }
}
