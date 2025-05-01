package forms;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.JavaScriptUtils;

import java.time.Duration;

public class PractiseFormPage extends BasePage {

    JavaScriptUtils js;

    private By firstname = By.id("firstName");
    private By lastname = By.id("lastName");
    private By email = By.id("userEmail");


    private By maleRadioButton = By.cssSelector("input[type='radio'][value='Male']");
    private By femaleRadioButton = By.cssSelector("input[type='radio'][value='Female']");
    private By otherRadioButton = By.cssSelector("input[type='radio'][id='gender-radio-3']");

    private By mobilenumber = By.id("userNumber");
    private By dateOfBirth = By.xpath("//input[@id='dateOfBirthInput']");

    private By subject = By.cssSelector(".subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3");

    private By sportsCheckbox = By.xpath("//label[@for='hobbies-checkbox-1']");
    private By readingCheckbox = By.xpath("//label[@for='hobbies-checkbox-2']");
    private By musicCheckbox = By.xpath("//label[@for='hobbies-checkbox-3']");

    private By uploadPicture = By.id("uploadPicture");
    private By currentAddress = By.id("currentAddress");

    private By stateDropdown = By.id("react-select-3-input");
    private By cityDropdown = By.id("react-select-4-input");

    private By submitButton = By.id("submit");

    private By thanksModalTitle = By.id("example-modal-sizes-title-lg");

    public PractiseFormPage(WebDriver driver) {
        super(driver);
        js = new JavaScriptUtils(driver);
    }

    public PractiseFormPage enterFirstName(String name) {
        js.scrollToElement(driver.findElement(firstname));
        driver.findElement(firstname).sendKeys(name);
        BasePage.delay(1000);
        return this;
    }

    public PractiseFormPage enterLastName(String name) {
        js.scrollToElement(driver.findElement(lastname));
        driver.findElement(lastname).sendKeys(name);
        BasePage.delay(1000);
        return this;
    }

    public PractiseFormPage enterEmail(String emailAddress) {
        js.scrollToElement(driver.findElement(email));
        driver.findElement(email).sendKeys(emailAddress);
        BasePage.delay(1000);
        return this;
    }

    public PractiseFormPage selectGender(String gender) {
        try {
            if (gender.equalsIgnoreCase("Male")) {
                js.clickWithJS(driver.findElement(maleRadioButton));
            } else if (gender.equalsIgnoreCase("Female")) {
                js.clickWithJS(driver.findElement(femaleRadioButton));
            } else if (gender.equalsIgnoreCase("Other")) {
                js.clickWithJS(driver.findElement(otherRadioButton));
            }
        } catch (Exception e) {
            System.out.println("Error clicking gender radio button: " + e.getMessage());
            e.printStackTrace();
        }
        BasePage.delay(1000);
        return this;
    }

    public PractiseFormPage enterMobileNumber(String number) {
        driver.findElement(mobilenumber).sendKeys(number);
        BasePage.delay(1000);
        return this;
    }

    public PractiseFormPage enterDateOfBirth(String date) {
        WebElement dateElement = driver.findElement(dateOfBirth);
        js.clickWithJS(dateElement);
        dateElement.clear();
        dateElement.sendKeys(date);
        dateElement.sendKeys("\n");
        BasePage.delay(1000);
        return this;
    }

    public PractiseFormPage enterSubject(String subjectText) {
        try {
            WebElement subjectElement = driver.findElement(subject);
            js.scrollToElement(subjectElement);
            js.clickWithJS(subjectElement);

            subjectElement.clear();

            subjectElement.sendKeys(subjectText);
            BasePage.delay(1000);

            subjectElement.sendKeys("\n");
            BasePage.delay(500);
        } catch (Exception e) {
            System.out.println("Error entering subject: " + e.getMessage());
            e.printStackTrace();
        }
        return this;
    }


    public PractiseFormPage selectHobbies(boolean sports, boolean reading, boolean music) {
        try {
            if (sports) {
                js.clickWithJS(driver.findElement(sportsCheckbox));
            }
            if (reading) {
                js.clickWithJS(driver.findElement(readingCheckbox));
            }
            if (music) {
                js.clickWithJS(driver.findElement(musicCheckbox));
            }
            BasePage.delay(1000);
        } catch (Exception e) {
            System.out.println("Error clicking hobby checkbox: " + e.getMessage());
            e.printStackTrace();
        }
        return this;
    }

    public PractiseFormPage uploadFile(String filePath) {
        js.scrollToElement(driver.findElement(uploadPicture));
        driver.findElement(uploadPicture).sendKeys(filePath);
        BasePage.delay(1000);
        return this;
    }

    public PractiseFormPage enterCurrentAddress(String address) {
        js.scrollToElement(driver.findElement(currentAddress));
        driver.findElement(currentAddress).sendKeys(address);
        BasePage.delay(1000);
        return this;
    }

    public PractiseFormPage selectState(String state) {
        js.scrollToElement(driver.findElement(stateDropdown));
        WebElement stateElement = driver.findElement(stateDropdown);
        js.clickWithJS(stateElement);
        stateElement.sendKeys(state);
        stateElement.sendKeys("\n");
        BasePage.delay(1000);
        return this;
    }

    public PractiseFormPage selectCity(String city) {
        js.scrollToElement(driver.findElement(cityDropdown));
        WebElement cityElement = driver.findElement(cityDropdown);
        js.clickWithJS(cityElement);
        cityElement.sendKeys(city);
        cityElement.sendKeys("\n");
        BasePage.delay(1000);
        return this;
    }

    public PractiseFormPage submitForm() {
        try {
            WebElement button = driver.findElement(submitButton);
            js.scrollToElement(button);
            js.clickWithJS(button);
            BasePage.delay(1000);
        } catch (Exception e) {
            System.out.println("Error submitting form: " + e.getMessage());
            e.printStackTrace();
        }
        return this;
    }

    public boolean isFormSubmittedSuccessfully() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement modalTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(thanksModalTitle));

            return modalTitle.getText().contains("Thanks for submitting the form");

        } catch (Exception e) {
            System.out.println("Error checking form submission: " + e.getMessage());
            return false;
        }
    }

}