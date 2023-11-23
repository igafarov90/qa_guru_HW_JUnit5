import testData.MainMenu;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.MainPage;
import pages.SearchPage;

import java.util.List;
import java.util.stream.Stream;


@DisplayName("Тесты на поисковый запрос в Baeldung")

public class BaeldungSearchTests extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @ValueSource(strings = {
            "JUnit 4", "JUnit 5", "Spring boot"
    })
    @Tag("WEB")
    @ParameterizedTest(name = "WEB: Для поискового запроса {0} должен отдавать не пустой список карточек")
    void searchResultsShouldNotBeEmptyTest(String searchQuery) {
        mainPage.openPage()
                .clickSearchIcon();
        searchPage.fillSearchInput(searchQuery)
                .checkResultsList(0);
    }

    @Tag("WEB")
    @ParameterizedTest(name = "WEB: Меню навигации содержит таб {0} ")
    @EnumSource(MainMenu.class)
    void navigationMenuShouldHaveTabTest(MainMenu tab) {
        mainPage.openPage()
                .checkMainMenuTabs(tab.getMainMenu());
    }

    @Tag("WEB")
    @ParameterizedTest(name = "WEB: для поискового запроса {0} в списке есть статья с описанием {1} ")
    @CsvFileSource(resources = "searchResultShouldContainExpectedArticle.csv", delimiter = '|')
    void searchResultShouldContainExpectedArticleTest(String searchQuery, String expectedArticle) {
        mainPage.openPage()
                .clickSearchIcon();
        searchPage.fillSearchInput(searchQuery)
                .checkDescriptionArticle(expectedArticle);
            }

    static Stream<Arguments> footerShouldHaveWidgetsTest() {
        return Stream.of(
                Arguments.of(
                        "SERIES",
                        "#menu-series",
                        List.of("JAVA “BACK TO BASICS” TUTORIAL\n" +
                                "JACKSON JSON TUTORIAL\n" +
                                "APACHE HTTPCLIENT TUTORIAL\n" +
                                "REST WITH SPRING TUTORIAL\n" +
                                "SPRING PERSISTENCE TUTORIAL\n" +
                                "SECURITY WITH SPRING\n" +
                                "SPRING REACTIVE TUTORIALS")
                ),
                Arguments.of(
                        "COURSES",
                        "#menu-courses",
                        List.of("ALL COURSES\n" +
                                "ALL BULK COURSES\n" +
                                "ALL BULK TEAM COURSES\n" +
                                "THE COURSES PLATFORM")
                ),
                Arguments.of(
                        "ABOUT",
                        "#menu-about",
                        List.of("ABOUT BAELDUNG\n" +
                                "THE FULL ARCHIVE\n" +
                                "EDITORS\n" +
                                "JOBS\n" +
                                "OUR PARTNERS\n" +
                                "PARTNER WITH BAELDUNG")
                )
        );
    }

    @Tag("WEB")
    @ParameterizedTest(name = "WEB: Подвал сайта содержит виджеты")
    @MethodSource()
    void footerShouldHaveWidgetsTest(String widget, String locator, List<String> list){
        mainPage.openPage()
        .checkFooterWidget(widget,locator,list);
    }

    @Disabled
    @Test
    void exampleDisableTest(){
        System.out.println("qa_guru");
    }

}


