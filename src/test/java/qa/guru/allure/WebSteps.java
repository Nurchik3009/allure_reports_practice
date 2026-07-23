package qa.guru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем страницу репозиториев пользователя {profile}")
    public void openProfileRepositories(String profile) {
        open("https://github.com/" + profile + "?tab=repositories");
    }

    @Step("Кликаем по ссылке на репозиторий {repo}")
    public void clickOnRepositoryLink(String repo) {
        $("a[href='" + repo + "']").click();
    }

    @Step("Открываем вкладку Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issueNumber}")
    public void shouldSeeIssueWithNumber(String issueNumber) {
        $("[data-testid='list-row-repo-name-and-number']").shouldHave(Condition.text(issueNumber));
    }
}