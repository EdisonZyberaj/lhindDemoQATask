package sliderPage;
import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.JavaScriptUtils;
import org.openqa.selenium.interactions.Actions;


public class Slider  extends  BasePage{

    private By sliderElement = By.xpath("//input[@type='range']");
    private By sliderValueLocator = By.id("sliderValue");

    JavaScriptUtils js;
    Actions actions;

    public Slider(WebDriver driver) {
         super(driver);
         js=new JavaScriptUtils(driver);
         actions=new Actions(driver);
    }

    public void interactSlider(int offset) {
        js.scrollToElement(driver.findElement(sliderElement));
        WebElement sliderElement1 = driver.findElement(sliderElement);
        actions.clickAndHold(sliderElement1).moveByOffset(offset,0).release().perform();
        actions.perform();
    }

    public boolean verifySliderValue(int offset) {
        System.out.println("slider value"+offset);
        System.out.println("slider value"+ driver.findElement(sliderValueLocator).getAttribute("value"));
        return driver.findElement(sliderValueLocator).getAttribute("value").equals(String.valueOf(offset));
    }


}
