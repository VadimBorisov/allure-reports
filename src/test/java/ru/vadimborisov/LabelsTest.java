package ru.vadimborisov;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

  @Test
  @Feature("Issue in repository")
  @Story("Create Issue")
  @Owner("borisovvd")
  @Severity(SeverityLevel.BLOCKER)
  @Link(value = "Testing", url = "https://testing.github.com")
  @DisplayName("Create Issue for authorize user")
  public void testStaticLabels() {

  }

  @Test
  public void testDynamicLabels() {
    Allure.getLifecycle().updateTestCase(
            t -> t.setName("Create Issue for authorize user")
    );
    Allure.feature("Issue in repository");
    Allure.story("Create Issue");
    Allure.label("owner", "borisovvd");
    Allure.label("severity", SeverityLevel.CRITICAL.value());
    Allure.link("Testing", "https://testing.github.com");
  }
}
