package ru.vadimborisov;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {
  private final String REPOSITORY = "eroshenkoam/allure-example";
  private final int ISSUE_ID = 80;

  @Test
  public void testLambdaAttachments() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Open GitHub index page", () -> {
      open("https://github.com/");
      attachment("Source", webdriver().driver().source());
    });

  }

  @Test
  public void testAnnotatedAttachments() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    WebSteps steps = new WebSteps();
    steps.openMainPage();
    steps.takeScreenshot();
  }
}
