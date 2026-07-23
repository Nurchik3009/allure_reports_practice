package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class StepsTest extends TestBase {
    private static final int ISSUE = 1;

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу репозиториев пользователя", () -> {
            open("https://github.com/Nurchik3009?tab=repositories");
        });

        step("Кликаем по ссылке на нужный репозиторий", () -> {
            $("a[href='/Nurchik3009/java_base_jenkins_simple_tests']").click();
        });

        step("Открываем вкладку issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие issue с номером #" + ISSUE, () -> {
            $("[data-testid='list-row-repo-name-and-number']").shouldHave(Condition.text("#1"));
        });
    }
}