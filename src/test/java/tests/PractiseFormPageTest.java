package tests;

import base.BaseTest;
import com.pages.base.BasePage;
import forms.PractiseFormPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class PractiseFormPageTest extends BaseTest {

    private PractiseFormPage formPage;
    private static final String PRACTICE_FORM_URL = "https://demoqa.com/automation-practice-form";

    @BeforeMethod
    @Override
    public void loadPage() {
        driver.get(PRACTICE_FORM_URL);
        formPage = new PractiseFormPage(driver);
    }

    @Test
    public void testStudentRegistrationForm() {

        String firstName = "Edison";
        String lastName = "Zyberaj";
        String email = "Edison.Zyberaj@example.com";
        String gender = "Male";
        String mobile = "1234567890";
        String dateOfBirth = "30 Apr 2025";
        String currentAddress = "123 Test Street, Test City";
        String state = "Uttar Pradesh";
        String city = "Lucknow";

        String filePath = new File("C:\\Users\\dell\\IdeaProjects\\Lhind-SeleniumTask2\\src\\main\\resources\\photo.png").getAbsolutePath();

        formPage.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .selectGender(gender)
                .enterMobileNumber(mobile)
                .enterDateOfBirth(dateOfBirth)
                .enterSubject("Computer Science")
                .selectHobbies(true, true, false)
                .uploadFile(filePath)
                .enterCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .submitForm();

        BasePage.delay(3000);

        Assert.assertTrue(formPage.isFormSubmittedSuccessfully(),
                "Form was not submitted successfully");
    }

    @Test
    public void testRequiredFieldsOnly() {
        String firstName = "John";
        String lastName = "Smith";
        String gender = "Male";
        String mobile = "9876543210";

        formPage.enterFirstName(firstName);

        BasePage.delay(1000);
        formPage.enterLastName(lastName);

        BasePage.delay(1000);
        formPage.selectGender(gender);

        BasePage.delay(1000);
        formPage.enterMobileNumber(mobile);
        BasePage.delay(1000);
        formPage.submitForm();

        Assert.assertTrue(formPage.isFormSubmittedSuccessfully(),
                "Form was not submitted successfully");
    }
}