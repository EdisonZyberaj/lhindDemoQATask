package dragAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.pages.base.BasePage;
import utils.JavaScriptUtils;


public class DragAndDrop extends BasePage {

    private final WebElement draggable = driver.findElement(By.id("draggable"));
    private final WebElement droppable =  driver.findElement(By.id("droppable"));
    JavaScriptUtils js;

    public DragAndDrop(WebDriver driver) {
        super(driver);
        js = new JavaScriptUtils(driver);
    }

    public boolean isDropSuccessful() {
        delay(1000);
        return droppable.getText().equals("Dropped!");
    }

    public DragAndDrop dragAndDrop() {
        js.scrollToElement(droppable);
        new Actions(driver).dragAndDrop(draggable, droppable).perform();
        delay(1000);
        return this;
    }

    public DragAndDrop dragAndDropByOffset() {
        int xOffset = droppable.getLocation().getX() - draggable.getLocation().getX() + 10;
        int yOffset = droppable.getLocation().getY() - draggable.getLocation().getY() + 10;
        new Actions(driver).dragAndDropBy(draggable, xOffset, yOffset).perform();
        delay(1000);
        return this;
    }
}