package tests;

import alerts.AlertsPage;
import base.BaseTest;
import forms.Form;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {

    private Form form;
    private static final String URL = "https://www.techlistic.com/p/selenium-practice-form.html";

    @BeforeMethod
    @Override
    public void loadPage() {
        driver.get(URL);
        form = new Form(driver);
    }

    @Test
    public void testForm() {

        String fname = "Edison";
        String lname = "Zyberaj";
        String date = "30 Apr 2025";

        form.enterFirstName(fname);
        form.enterLastName(lname);
        form.setmRadio();
        form.selectYearsOfExperience();
        form.setdateInput(date);
        form.setManualTester();
        // getAbsolutePath();
        form.uploadFile("C:\\Users\\dell\\IdeaProjects\\Lhind-SeleniumTask2\\src\\main\\resources\\photo.png");
        form.selectContinent("Asia");
        form.selectCommandByVisibleText("Navigation Commands");
        form.clickSubmit();

    }

}
