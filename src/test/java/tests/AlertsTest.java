package tests;

import alerts.AlertsPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.ExtentReportManager.class)
public class AlertsTest extends BaseTest {

    private AlertsPage alertsPage;
    private static final String ALERTS_URL = "https://demoqa.com/alerts";

    @BeforeMethod
    @Override
    public void loadPage() {
        driver.get(ALERTS_URL);
        alertsPage = new AlertsPage(driver);
    }

    @Test
    public void testConfirmAlertAccept() {
        alertsPage.clickConfirmAlertAndAccept();
        String resultText = alertsPage.getConfirmResultText();
        Assert.assertTrue(resultText.contains("You selected Ok"),
                "Confirmation result does not indicate 'Ok' was selected");
    }

    @Test
    public void testPromptAlertWithInput() {
        String testInput = "TestUser";
        alertsPage.clickPromptAlertAndEnterText(testInput);
        Assert.assertTrue(alertsPage.isPromptTextEntered(testInput),
                "Prompt result does not contain the entered text: " + testInput);
    }


}