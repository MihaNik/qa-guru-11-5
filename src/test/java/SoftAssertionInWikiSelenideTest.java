import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionInWikiSelenideTest {
    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void softAssertionShouldContainJunit5() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $$("div#wiki-body ul li a").findBy(text("Soft assertions")).click();
        $$("div#wiki-content h4")
                .findBy((text("Using JUnit5 extend test class")))
                .sibling(0)
                .shouldHave(cssClass("highlight-source-java"))
                .shouldHave(text("SoftAssertsExtension"));
    }
}