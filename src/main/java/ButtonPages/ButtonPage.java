package ButtonPages;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class ButtonPage extends BasePage {

    private By doubleClickMe = By.id("doubleClickBtn");
    private By rightClickButton = By.id("#rightClickBtn");
    private By clickMe = By.id("9d6rn");

    public void doubleClickMe() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(doubleClickMe)).doubleClick();
    }

    public void rightClickMe() {
        Actions action = new Actions(driver);
        action.contextClick((WebElement) rightClickButton).perform();
        driver.findElement(rightClickButton).click();
    }

    public void clickMe() {
        driver.findElement(clickMe).click();
    }

    public ButtonPage(WebDriver driver) {
        super(driver);
    }

}
