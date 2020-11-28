package pageobjects;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Errors;
import utils.PropertiesLoader;
import utils.WebBasePage;
import utils.Config;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static reporting.ComplexReportFactory.getTest;
import static utils.Errors.*;
import static utils.Errors.productTypeRequired;

public class AddProductPage extends WebBasePage
{
    private final static String FILE_NAME = System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties";
    private static Properties prop = new PropertiesLoader(FILE_NAME).load();
    public static String pName;
    public static String proCode;
    WebDriver driver;

    public AddProductPage(WebDriver driver)
    {
        super(driver,"Dashboard Page");
        this.driver=driver;
    }
    public String defaultPcode;
    public void clickFullMenuDropDown()
    {
        click(By.cssSelector("a#navbarDropdownPortfolio"),"Ful Menu",10);
    }
    public void clickAssetManagement()
    {
        click(By.cssSelector("#menuitem3 > a"),"Asset Management",10);
    }
    public void clickManageProduct()
    {
        click(By.xpath("(//ul[contains(@class,'submenu clschild')]//a[@id='cadmin_messageboard_link'])[2]"),"Manage Product",10);
    }
    public void clickAddNewButton()
    {
       click(By.xpath("//i[@class='fa fa-plus']"),"Add New",80);
    }
    public void verifyBarCodeDropDown()
    {
        click(By.cssSelector("div>select#BarcodeTypeId"),"Product Type",15);
        List<WebElement> barcodeOption=driver.findElements(By.xpath("//select[@id='BarcodeTypeId']//option"));
        int i=0;
        String expectedCodeType[]={"Select","Barcode","QR"};
    for (WebElement element:barcodeOption)
        {
            for (String expected:expectedCodeType)
            {
                i++;
                if(element.getText().equals(expected))
                {
                    getTest().log(LogStatus.PASS, "BarCode Dropdown values are displayed as expected");
                    logger.info("BarCode Dropdown values are displayed as expected");
                    break;
                }
                else if(i==expectedCodeType.length && !element.getText().equals(expected))
                {
                    getTest().log(LogStatus.FAIL, "BarCode Dropdown values are Not Displayed as expected");
                    logger.info("BarCode Dropdown values are displayed as expected");
                }

            }

        }
    }
    public void selectProductType()
    {
        waitForVisibilityOfElement(By.cssSelector("div>select#AssetTypeId"),30);
        selectValueWithIndex(By.cssSelector("div>select#AssetTypeId"),1,"Product Type",10);
    }
    public void enterProductName100Character()
    {
        enter(By.cssSelector("div>input#Name"), prop.getProperty("productName100Charc"), "Product Name", 10);
    }
    public void enterProductName101Character()
    {
        enter(By.cssSelector("div>input#Name"), prop.getProperty("productName101Charc"), "Product Name", 10);
        click(By.xpath("//label[@for='BarcodeTypeId']"),"bcarcode",10);
    }
    public void enterItemName()
    {
            enter(By.cssSelector("div>input#Name"),prop.getProperty("productName"), "Product Name", 10);
    }
    public void enterProductNameWithAlphaNumeric()
    {
        enter(By.cssSelector("div>input#Name"),prop.getProperty("productNameAlphaNumeric"), "Product Name", 10);

    }
    public void entertProductNameWithSpecialCharacter()
    {
        enter(By.cssSelector("div>input#Name"),prop.getProperty("ProductNameSpecialCharacter"), "Product Name", 10);

    }
    public void selectBarCodeType()
    {
        selectValueWithIndex(By.cssSelector("select#BarcodeTypeId"),1,"Barcode type",10);
    }
    public void validateStatus()
    {
        String status=getText(By.xpath("//select[@id='StatusId']"),10);
          String pStatus=status.substring(0,6);
        if(pStatus.equals("Active"))
        {
            getTest().log(LogStatus.PASS, "Status is Validated successfully on Add product Page");
            logger.info("Status is Validated successfully on Add product Page");
        }
        else
            {
                getTest().log(LogStatus.FAIL, "Status is updated wrongly on Add product Page");
                logger.info("Status is updated wrongly on Add product Page");
            }
    }
    public void selectStatus()
    {
        validateStatus();
        selectValueWithIndex(By.cssSelector("select#StatusId"),0,"satatus",10);
    }
    public void selectAudit()
    {
        selectValueWithIndex(By.cssSelector("select#AuditFrequency"),1,"Audit",10);
    }
    public void selectImageCapture()
    {
        selectValueWithIndex(By.cssSelector("select#ImageCaptureFrequency"),1,"Image frequency",10);
    }
    public void selectCalibration()
    {
        selectValueWithIndex(By.cssSelector("select#CalibrationFrequency"),1,"calibration",10);
    }
    public void enterProductCode6Character()
    {
        enter(By.cssSelector("div>input#ItemCode"),prop.getProperty("productCode6Charcter"),"product code",10);
    }
    public void enterProductCode7Character()
    {
        enter(By.cssSelector("div>input#ItemCode"),prop.getProperty("ProductCodeWith7Character"),"product code",10);
    }
    public void enterProductCode()
    {
        defaultPcode=getAtribute(By.cssSelector("input#txtitemtypecode"),"value",30);
        enter(By.cssSelector("div>input#ItemCode"),prop.getProperty("productCode"),"product code",10);
    }
    public void enterProductCodeWithAlphaNumeric()
    {
        enter(By.cssSelector("div>input#ItemCode"),prop.getProperty("productCodeAlphaNumeric"),"product code",10);
    }
    public void enterProductNameWith1Character()
    {
      enter(By.cssSelector("div>input#Name"),prop.getProperty("productName1Character"),"product code",10);
    }
    public void uploadDocument()
    {
    driver.findElement(By.cssSelector("input#flFileDisplay")).sendKeys(Config.testfilejpg);
        String docName=getText(By.xpath("(//div//input[@type='text'])[14]"),20);
    driver.findElement(By.cssSelector("input#flFileDisplay")).sendKeys(Config.testfilePDF);
        String doc2Name=getText(By.xpath("(//div//input[@type='text'])[14]"),20);
        if(docName.equals(doc2Name))
        {
            getTest().log(LogStatus.PASS, "Newly uploaded Document is not reflected");
            logger.info("Newly uploaded Document is not reflected");
        }
        else if(doc2Name.equals(Config.testfilePDFfileName))
        {
            getTest().log(LogStatus.FAIL, "Document upload field i sworking as expected");
            logger.info("Document upload field i sworking as expected");
        }

    }
    public void enterDescription250Character()
    {
        enter(By.cssSelector("textarea#Description"),prop.getProperty("description250Character"),"description",10);
    }
    public void enterDescription1Character()
    {
        enter(By.cssSelector("textarea#Description"),prop.getProperty("description1Character"),"description",10);
    }
    public void clickTheCheckBox()
    {
        clickByJavascript(By.cssSelector("input#CreateUniqueNameListing"),"unique name",10);
    }
    public void enterStockValueForompany()
    {
        enter(By.cssSelector("input#for_Company"),prop.getProperty("companyStock"),"For company",10);
    }
    public void enterStockValueForEmployee()
    {
        enter(By.cssSelector("input#for_Employee"),prop.getProperty("employeeStock"),"For company",10);
    }
    public void clickNextButton()
    {
//        click(By.cssSelector("a#btnNext"),"Next button",10);

        waitForVisibilityOfElement(By.xpath("(//span[@class='p-name text-white'])[3]"),30);
        String deployTab=getText(By.xpath("(//span[@class='p-name text-white'])[3]"),10);
        String deployProduct=prop.getProperty("deployTab");
        if(deployProduct.equals(deployTab))
        {
            getTest().log(LogStatus.PASS, "Deploy Product Tab is displayed succfully ");
            logger.info("Deploy Product Tab is displayed succfully");
        }
        else
        {
            getTest().log(LogStatus.PASS, "Deploy Product Tab is not displayed succfully ");
            logger.info("Deploy product Tab is not displayed");
        }

    }
    public void clickSaveButton()
    {
        click(By.cssSelector("a#btnSave"),"Save",10);
    }
    public void goBackToAddProductPage()
    {
     click(By.xpath("//table[@id='tablelistingdata']/tbody/tr[2]/td[5]"),"Product Name",10);
    }
    public void manageProductPageValidation()
    {
        waitForVisibilityOfElement(By.xpath("//table[@id='tablelistingdata']/tbody/tr[@class='low-bar odd'][1]/td[5]/span"),30);
        String pCode=prop.getProperty("productCode");
        String pName=prop.getProperty("productName");
        String productName=getText(By.xpath("//table/tbody/tr[2]/td[5]"),15);
        String productCode=getText(By.xpath("//table/tbody/tr[2]/td[4]"),15);
        if(pName.equals(productName)&& pCode.contains(productCode))
        {
            getTest().log(LogStatus.PASS, "Product List Page is displayed");
            logger.info("Product List Page is displayed");
        }
        else
        {
            getTest().log(LogStatus.PASS, "Product List Page is Not displayed");
            logger.info("Product List Page is not displayed");
        }


    }
    public void handleSuccessPopup()
    {
        String popupText="Product has been successfully added.";
        String alertText=getText(By.xpath("//div[@role='alert']"),10);
        if(popupText.contains(alertText))
        {
            click(By.xpath("//i[@class='fa fa-times text-secondary']"),"Close Popup",15);
        }
    }

    public void pCodeValidation()
    {
        String productCode=getText(By.xpath("//table[@id='tablelistingdata']/tbody/tr[2]/td[4]//span"),10);
        if(productCode.contains(defaultPcode))
        {
            getTest().log(LogStatus.PASS, "Default product code is displayed as expected");
            logger.info("Default product code is displayed as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Default product code is not displayed as expected");
            logger.info("Default product code is not displayed as expected");
        }

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
