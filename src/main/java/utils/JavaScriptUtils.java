package utils;

import com.pages.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    private final WebDriver driver;

    public JavaScriptUtils(WebDriver driver) {
        this.driver = driver;
    }


    public  void clickWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        BasePage.delay(500);
        js.executeScript("arguments[0].click();", element);
    }


    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        BasePage.delay(5000);
    }
}