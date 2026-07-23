package qa.guru.allure;

import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest extends TestBase {

    WebSteps steps = new WebSteps();

    @Test
    public void testAnnotatedSteps() {
        steps.openProfileRepositories("Nurchik3009");
        steps.clickOnRepositoryLink("/Nurchik3009/java_base_jenkins_simple_tests");
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber("#1");
    }
}