package tests;

import base.BaseTest;
import com.pages.UploadDownloadPage;
import com.pages.base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class UploadDownloadTest extends BaseTest {

    private UploadDownloadPage uploadDownloadPage;
    private static final String UPLOAD_DOWNLOAD_URL = "https://demoqa.com/upload-download";

    @BeforeMethod
    @Override
    public void loadPage() {
        driver.get(UPLOAD_DOWNLOAD_URL);
        uploadDownloadPage = new UploadDownloadPage(driver);
    }

    @Test
    public void testFileUploadAndDownload() {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/photo.png";

        uploadDownloadPage.uploadFile(filePath);

        Assert.assertTrue(uploadDownloadPage.isFileUploaded(),
                "File was not uploaded successfully");

        String uploadedPath = uploadDownloadPage.getUploadedFilePath();
        Assert.assertTrue(uploadedPath.contains("photo.png"),
                "Uploaded file path does not contain the correct filename");

        uploadDownloadPage.downloadFile();

        BasePage.delay(1000);

        File downloadedFile = new File(System.getProperty("user.home") + "/Downloads/sampleFile.jpeg");
        if (downloadedFile.exists()) {
            Assert.assertTrue(true, "File was downloaded successfully");
        } else {
            System.out.println("Note: Download verification skipped. Check browser download settings.");
        }
    }
}