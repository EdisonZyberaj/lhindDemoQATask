package com.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.JavaScriptUtils;

public class UploadDownloadPage extends BasePage {
    private By uploadFileInput = By.id("uploadFile");
    private By downloadButton = By.id("downloadButton");
    private By uploadedFilePath = By.id("uploadedFilePath");

    private JavaScriptUtils js;

    public UploadDownloadPage(WebDriver driver) {
        super(driver);
        this.js = new JavaScriptUtils(driver);
    }

    public UploadDownloadPage uploadFile(String filePath) {
        try {
            WebElement uploadElement = driver.findElement(uploadFileInput);
            js.scrollToElement(uploadElement);
            uploadElement.sendKeys(filePath);
            delay(1000);
        } catch (Exception e) {
            System.out.println("Error uploading file: " + e.getMessage());
            e.printStackTrace();
        }
        return this;
    }

    public UploadDownloadPage downloadFile() {
        try {
            WebElement downloadElement = driver.findElement(downloadButton);
            js.clickWithJS(downloadElement);
            delay(1000);
        } catch (Exception e) {
            System.out.println("Error downloading file: " + e.getMessage());
            e.printStackTrace();
        }
        return this;
    }

    public boolean isFileUploaded() {
        return driver.findElement(uploadedFilePath).isDisplayed();
    }

    public String getUploadedFilePath() {
        return driver.findElement(uploadedFilePath).getText();
    }
}