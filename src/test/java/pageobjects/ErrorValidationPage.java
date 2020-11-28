package pageobjects;

import com.relevantcodes.extentreports.LogStatus;
import javafx.scene.effect.Bloom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.v6.A;
import utils.Config;
import utils.Errors;
import utils.PropertiesLoader;
import utils.WebBasePage;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static reporting.ComplexReportFactory.getTest;
import static utils.Errors.*;

public class ErrorValidationPage extends WebBasePage
{
    WebDriver driver;
    AddProductPage addProductPage=new AddProductPage(driver);
    private final static String FILE_NAME = System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties";
    private static Properties prop = new PropertiesLoader(FILE_NAME).load();

     public static String pName;
     public static String proCode;
     Config config;
    public ErrorValidationPage(WebDriver driver)
    {
        super(driver,"Dashboard Page");
        this.driver=driver;
        this.config=new Config();
    }

     public void mandatoryFieldValidation()
    {
        click(By.cssSelector("a#btnSave"),"save button",60);
        String productTypeErrorMsg=getText(By.xpath("(//select[@id='AssetTypeId']//following::span)[1]"),10);
        String productNameErrorMsg=getText(By.xpath("(//input[@id='Name']//following::span)[1]"),10);
        String barcodetypeErrorMsg=getText(By.xpath("(//select[@id='BarcodeTypeId']//following::span)[1]"),10);
        String errorMsg= Errors.productTypeRequired;
        String errorMsgs= productNameReuired;
        String errorMsgg= barcodeTypeRequired;
        if(errorMsg.equals(productTypeErrorMsg) && errorMsgs.equals(productNameErrorMsg) && errorMsgg.equals(barcodetypeErrorMsg))
        {
            getTest().log(LogStatus.PASS, "Error Message is successfully displayed ");
            logger.info("Error Message is successfully displayed as "+errorMsg);
            logger.info("Error Message is successfully displayed as "+errorMsgs);
            logger.info("Error Message is successfully displayed as "+errorMsgs);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Error Message is successfully displayed ");
            logger.info("Error Messgae is not displayed");
        }
    }
    public void documentValidation()
    {
        scrollDown();
        driver.findElement(By.cssSelector("input#flFileDisplay")).sendKeys(Config.testfiletiff);
        String documentErrorMsg=Errors.uploadValidDocuments;
        String docErrorMsg=getText(By.xpath("//label[@for='flFileDisplay']//following::small"),10);
        if(documentErrorMsg.equals(docErrorMsg))
        {
            getTest().log(LogStatus.PASS, "Error Message is successfully displayed ");
            logger.info("Error Message is displayed successfully displayed as "+documentErrorMsg);

        }
        else
        {
            getTest().log(LogStatus.FAIL, "Error Message is successfully displayed ");
            logger.info("Error Message is not displayed");

        }

    }
    public void getProductCode()
    {
        String productCode=getText(By.xpath("//table[@id='tablelistingdata']/tbody/tr[2]/td[4]//span"),10);
         proCode=productCode.substring(4,10);
    }
    public void productCodeValidation()
    {

        String pCodeErrorMsg;
        enter(By.cssSelector("div>input#ItemCode"),proCode,"product code",10);

        String errormsg=Errors.duplicateProductCode;
        pCodeErrorMsg=getText(By.xpath("(//div[contains(@class,'input-group ')]//following::small)[1]"),60);
        if (pCodeErrorMsg.equals(errormsg))
        {
            getTest().log(LogStatus.PASS, "Error Message is successfully displayed ");
            logger.info("Error Message is successfully displaed as "+errormsg);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Error Message is not successfully displayed ");
            logger.info("Error Message is not Displayed");
        }
    }
    public void getProductName()
    {
        String productName=getText(By.xpath("(//a[normalize-space(@id)='ancEditAssetType'])[1]"),10);
        pName=productName;
    }
    public void productNameValidation()
    {
        String duplicateNameErrorMsg;
        enter(By.cssSelector("div>input#Name"), pName, "Product Name", 10);
        click(By.xpath("//label[@for='BarcodeTypeId']"),"bcarcode",10);
        String nameerrorMsg=Errors.duplicateItemName;
        duplicateNameErrorMsg=getText(By.xpath("(//input[@id='Name']//following::span)[1]"),50);
        if(duplicateNameErrorMsg.equals(nameerrorMsg))
        {
            getTest().log(LogStatus.PASS, "Error Message is successfully displayed ");
            logger.info("Error Message is successfully displayed as "+nameerrorMsg);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Error Message is not successfully displayed ");
            logger.info("Error Message is not displayed");
        }

    }
    public void errorMsgValidationOnDescription()
    {
        waitForVisibilityOfElement(By.cssSelector("textarea#Description"),30);
        String errorMsg=Errors.descriptionErrorMsg;
        enter(By.cssSelector("textarea#Description"),prop.getProperty("description251Character"),"description",10);
        click(By.cssSelector("input#for_Employee"),"For company",10);
        String descriptionErrorMsg=getText(By.xpath("(//label[@for='Description']//following::span)[1]"),10);
        if(descriptionErrorMsg.equals(errorMsg))
        {
            getTest().log(LogStatus.PASS, "Error Message is successfully displayed ");
            logger.info("Error Messgae is successfully displayed as "+errorMsg);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Error Message isNot  successfully displayed ");
            logger.info("Error Message is not displayed");
        }
        driver.navigate().refresh();
    }
    public void productNameErrorMsgValidation()
    {
        String errorMsgs= productNameReuired;
        String pNameErrorMsg=getText(By.xpath("(//input[@id='Name']//following::span)[1]"),10);
        if(errorMsgs.equals(pNameErrorMsg) )
        {
            getTest().log(LogStatus.PASS, "Error Message is successfully displayed ");
            logger.info("Error Message is successfully displayed as "+errorMsgs);

        }
        else
        {
            getTest().log(LogStatus.FAIL, "Error Messgae is not displayed");
            logger.info("Error Messgae is not displayed");
        }
        driver.navigate().refresh();
    }
    public void verifymandatoryFieldValidation()
    {

        List expectedErrors=new ArrayList();
        expectedErrors.add(productTypeRequired);
        expectedErrors.add(productNameReuired);
        expectedErrors.add(barcodeTypeRequired);

        int i=0;
        int mandatoryFieldCount=driver.findElements(By.xpath("//div[@class='row']//span[@class='text-danger' and text()='*']")).size();
        List<WebElement> errorMessageLocator=driver.findElements(By.xpath("//span[@class='invalid-feedback']"));
        if(mandatoryFieldCount==errorMessageLocator.size())
        {
            for (WebElement element:errorMessageLocator) {
                for (Object expected:expectedErrors) {
                    i++;
                    if(element.getText().equals(expected))
                    {
                        getTest().log(LogStatus.PASS, expected+" error message is displayed as expected");
                        logger.info(expected+" error message is displayed as expected");
                        break;
                    }
                    else if (i==errorMessageLocator.size()&&!element.getText().equals(expected))
                    {
                        getTest().log(LogStatus.FAIL, expected+" error message is not displayed as expected");
                        logger.info(expected+" error message is not displayed as expected");
                    }
                }
            }
        }
    }

    public void productTypeValidation()
    {
        String errorMsgs= productTypeRequired;
        String productTypeErrorMsg=getText(By.xpath("(//select[@id='AssetTypeId']//following::span)[1]"),10);
        if(errorMsgs.equals(productTypeErrorMsg) )
        {
            getTest().log(LogStatus.PASS, "Error Message is successfully displayed ");
            logger.info("Error Message is successfully displayed as "+errorMsgs);

        }
        else
        {
            getTest().log(LogStatus.FAIL, "Error Messgae is not displayed");
            logger.info("Error Messgae is not displayed");
        }
        driver.navigate().refresh();
    }
}
