package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("ios")
public class IosTests extends TestBase {

    @Test
    @DisplayName("Ios simple test")
    void test01() {
        step("Click Text Button", () -> {
            $(accessibilityId("Text Button")).click();
        });

        step("Click Text Input", () -> {
            $(accessibilityId("Text Input")).click();
            $(accessibilityId("Text Input")).sendKeys("hello@browserstack.com");
        });

        step("Click Text Output", () -> {
            $(accessibilityId("Text Output")).click();

            assertEquals("hello@browserstack.com", $(accessibilityId("Text Input")).getText());
        });
    }
}