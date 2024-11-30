package ru.vadimborisov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
  private final String REPOSITORY = "eroshenkoam/allure-example";
  private final int ISSUE_ID = 80;

  @Test
  public void testLambdaStep() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Open GitHub index page", () -> {
      open("https://github.com/");
    });
    step("Search repository " + REPOSITORY, () -> {
      $(".header-search-button").click();
      $("#query-builder-test").setValue(REPOSITORY).submit();
    });
    step("Click on repository link " + REPOSITORY, () -> {
      $(linkText(REPOSITORY)).click();
    });
    step("Open issues tab", () -> {
      $("#issues-tab").click();
    });
    step("Checking for availability Issue with # " + ISSUE_ID, () -> {
      $(withText("#" + ISSUE_ID)).should(Condition.exist);
    });
  }

  @Test
  public void annotatedStepsTest() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    WebSteps steps = new WebSteps();
    steps.openMainPage();
    steps.searchRepository(REPOSITORY);
    steps.clickOnRepositoryLink(REPOSITORY);
    steps.openIssuesTab();
    steps.shouldSeeIssueWithNumber(ISSUE_ID);
  }
}
