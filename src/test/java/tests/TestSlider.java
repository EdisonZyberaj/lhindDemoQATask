package tests;

import base.BaseTest;
import dragAndDrop.DragAndDrop;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sliderPage.Slider;

public class TestSlider extends BaseTest {

    private Slider slider;
    private static final String URL = "https://demoqa.com/slider";

    @BeforeMethod
    @Override
    public void loadPage() {
        driver.get(URL);
        slider = new Slider(driver);
    }

    @Test
    public void sliderTest() {

        slider.interactSlider(40);
        Assert.assertTrue(slider.verifySliderValue(58));

    }
}