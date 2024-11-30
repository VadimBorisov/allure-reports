package ru.vadimborisov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

  @Step("Open GitHub index page")
  public void openMainPage() {
    open("https://github.com/");
  }

  @Step("Search repository {repo}")
  public void searchRepository(String repo) {
    $(".header-search-button").click();
    $("#query-builder-test").setValue(repo).submit();
  }

  @Step("Click on repository link {repo}")
  public void clickOnRepositoryLink(String repo) {
    $(linkText(repo)).click();
  }

  @Step("Open issues tab")
  public void openIssuesTab() {
    $("#issues-tab").click();
  }

  @Step("Checking for availability Issue with #{number}")
  public void shouldSeeIssueWithNumber(int number) {
    $(withText("#" + number)).should(Condition.exist);
  }

  @Attachment(value = "screenshot", type = "image/png", fileExtension = "png")
  public byte[] takeScreenshot() {
    return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
  }
}
