package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pages.base.BasePage;
import java.time.Duration;

public class AlertsPage extends BasePage {

    private final By confirmBoxButton = By.id("confirmButton");
    private final By promptBoxButton = By.id("promtButton");
    private final By confirmResult = By.id("confirmResult");
    private final By promptResult = By.id("promptResult");

    private final WebDriverWait wait;

    public AlertsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public AlertsPage clickConfirmAlertAndAccept() {
        driver.findElement(confirmBoxButton).click();
        driver.switchTo().alert().accept();
        return this;
    }


    public AlertsPage clickPromptAlertAndEnterText(String text) {
        driver.findElement(promptBoxButton).click();
        driver.switchTo().alert().sendKeys(text);
        delay(1000);
        driver.switchTo().alert().accept();
        return this;
    }

    public String getConfirmResultText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmResult)).getText();
    }

    public String getPromptResultText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(promptResult)).getText();
    }

    public boolean isPromptTextEntered(String text) {
        String resultText = getPromptResultText();
        return resultText.contains(text);
    }
}