package forms;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.JavaScriptUtils;

import java.util.List;

public class Form extends BasePage {

    JavaScriptUtils js = new JavaScriptUtils(driver);

    private By firstName = By.name("firstname");
    private By lastName = By.name("lastname");

    private By mRadio = By.id("sex-0");
    private By fRadio = By.id("sex-1");

    private By yearsOfExperience = By.xpath("//input[@id='exp-0']");

    private By dateInput = By.id("datepicker");

    private By manualTester = By.id("profession-0");
    private By automationTester = By.id("profession-1");

    private By inputFile = By.className("input-file");

    private By submitButton = By.id("submit");

    private By seleniumCommands = By.xpath("//select[@id='selenium_commands']");

    private By continents = By.xpath("//select[@id='continents']");

    public void selectContinent(String continent) {
        WebElement dropdown = driver.findElement(continents);
        Select selectContinents = new Select(dropdown);
        selectContinents.selectByVisibleText(continent);
    }
    public void setManualTester(){
        js.scrollToElement(driver.findElement(manualTester));
        js.scrollToElement(driver.findElement(manualTester));
    }

    public void setmRadio() {
        js.scrollToElement(driver.findElement(mRadio));
        js.clickWithJS(driver.findElement(mRadio));
        delay(1000);
    }
    public void setfRadio() {
        js.scrollToElement(driver.findElement(fRadio));
        js.clickWithJS(driver.findElement(fRadio));
        delay(1000);
    }

    public void selectContinentByVisibleText(String continentName) {
        js.scrollToElement(driver.findElement(continents));
        WebElement dropdown = driver.findElement(continents);
        Select selectContinents = new Select(dropdown);
        selectContinents.selectByVisibleText(continentName);
        BasePage.delay(1000);
    }

    public void selectContinentByValue(String value) {
        js.scrollToElement(driver.findElement(continents));
        WebElement dropdown = driver.findElement(continents);
        Select selectContinents = new Select(dropdown);
        selectContinents.selectByValue(value);
        BasePage.delay(1000);
    }

    public String getSelectedContinent() {
        WebElement dropdown = driver.findElement(continents);
        Select selectContinents = new Select(dropdown);
        return selectContinents.getFirstSelectedOption().getText();
    }

    public void selectYearsOfExperience() {
        js.scrollToElement(driver.findElement(yearsOfExperience));
        js.clickWithJS(driver.findElement(yearsOfExperience));
    }

    public void clickSubmit() {
        js.scrollToElement(driver.findElement(submitButton));
        js.clickWithJS(driver.findElement(submitButton));
        delay(1000);
    }

    public Form uploadFile(String filePath) {
        js.scrollToElement(driver.findElement(inputFile));
        driver.findElement(inputFile).sendKeys(filePath);
        BasePage.delay(1000);
        return this;
    }

    public void setdateInput(String date) {
        driver.findElement(dateInput).sendKeys(date);
    }

    public Form enterFirstName(String name) {
        js.scrollToElement(driver.findElement(firstName));
        driver.findElement(firstName).sendKeys(name);
        BasePage.delay(1000);
        return this;
    }

    public Form selectCommandByVisibleText(String commandName) {
        js.scrollToElement(driver.findElement(seleniumCommands));
        WebElement dropdown = driver.findElement(seleniumCommands);
        Select selectCommands = new Select(dropdown);
        selectCommands.selectByVisibleText(commandName);
        BasePage.delay(1000);
        return this;
    }

    public Form enterLastName(String name) {
        js.scrollToElement(driver.findElement(lastName));
        driver.findElement(lastName).sendKeys(name);
        BasePage.delay(1000);
        return this;
    }

    public Form(WebDriver driver) {
        super(driver);
    }
}
