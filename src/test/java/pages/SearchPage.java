package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    private final SelenideElement inputSearch = $("[id=\"search\"]"),
            articleContent = $(".post-inner");
    private final ElementsCollection resultList = $$(".archive-columns article");

    public SearchPage fillSearchInput(String value) {
        inputSearch.setValue(value)
                .pressEnter();

        return this;
    }

    public void checkResultsList(int value) {
        resultList.shouldBe(sizeGreaterThan(value));

    }

    public void checkDescriptionArticle(String value) {
        articleContent.shouldHave(Condition.text(value));

    }
}
