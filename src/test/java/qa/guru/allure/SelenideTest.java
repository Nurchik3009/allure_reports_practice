package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideTest extends TestBase {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/Nurchik3009?tab=repositories");

        $("a[href='/Nurchik3009/java_base_jenkins_simple_tests']").click();

        $("#issues-tab").click();

        $("[data-testid='list-row-repo-name-and-number']").shouldHave(Condition.text("#1"));
    }
}
