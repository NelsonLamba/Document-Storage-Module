package utils;

import bsh.commands.dir;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static reporting.ComplexReportFactory.*;

public class WebTestBase {

    public WebDriver driver;
    public ExtentTest test;

    @BeforeSuite(alwaysRun = true)
   /* public void CreateTestLogPath() {
        excelpath = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";
        File zipFilePath = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\zipFilePath");
        File downloadFilePath = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\downloadedFiles");
        try {
            FileUtils.cleanDirectory(zipFilePath);
            FileUtils.cleanDirectory(downloadFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

    @AfterSuite(alwaysRun = true)
    public void close() {
        closeReport();
    }

    @Parameters({"browser", "env"})

    @BeforeTest(alwaysRun = true)
    public void setUp(String browser, String env) throws MalformedURLException {

        String url;
        driver = new Drivers().getWebDriver(browser);
        if (System.getProperty("environment") != null) {
            url = System.getProperty("environment");
            driver.get(url);
        } else {
            driver.get("https://sandbox2.talygen.com/");
            driver.manage().window().maximize();
        }
    }

    @BeforeMethod()
    public void beforeMethod(Method method) {
        //test = getTest(method.getDeclaringClass().getSimpleName() + "-" + method.getName(), method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void reportWrapUp(ITestResult result, Method method) {

        if (!result.isSuccess()) {

            String imagePath = System.getProperty("user.dir") + "\\reports\\" + method.getName();
            // generate screenshot as a file object
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                // copy file object to designated location
                FileUtils.copyFile(scrFile, new File(imagePath + ".png"));
                System.out.println(imagePath + ".png");
            } catch (Exception e) {
                Assert.fail("Error while taking screenshot - " + e);
            }

        }
        closeTest(test);
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {

        driver.quit();
    }


}
