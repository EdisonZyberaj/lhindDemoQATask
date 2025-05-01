package tests;

import ButtonPages.ButtonPage;
import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ButtonsTest extends BaseTest {

    public ButtonPage buttonPage;

    private static final String PRACTICE_FORM_URL = "https://demoqa.com/buttons";

    @BeforeMethod
    @Override
    public void loadPage() {
        driver.get(PRACTICE_FORM_URL);
        buttonPage= new ButtonPage(driver);
    }

    @Test
    public void doubleClickMeTest() {
        buttonPage.doubleClickMe();
    }

}
