package pageobjects;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Drivers;
import utils.PropertiesLoader;
import utils.WebBasePage;

import java.io.File;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static reporting.ComplexReportFactory.getTest;

public class AttachmentsPage extends WebBasePage {
    WebDriver driver;
    private final static String FILE_NAME = System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties";
    private static Properties prop = new PropertiesLoader(FILE_NAME).load();
    String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
    public static String termsAndCondition="No";
    public static int filesInDirectory;
    public AttachmentsPage(WebDriver driver)
    {
        super(driver,"");
        this.driver=driver;
    }

    public void navigateToAttachmentTab()
    {
        WebElement attachmentTab=findElementClickable(By.xpath("//div[@class='left-menu-tab']//ul[@id='myTab']//li//a[text()='Attachments ']"),20);
        if(attachmentTab!=null) {
            click(By.xpath("//div[@class='left-menu-tab']//ul[@id='myTab']//li//a[text()='Attachments ']"), "Attachments Tab", 15);
            getTest().log(LogStatus.PASS,"User can able to click \"Attachment Tab\"");
        }else
        {
            getTest().log(LogStatus.FAIL,"User not able to click \"Attachment Tab\"");
        }
    }
    public void enterAttachmentName()
    {
        enter(By.cssSelector("#txtAttachment"),prop.getProperty("attachmentNameAlphaNumeric"),"Attachment Name",15);
    }
    public void attachmentNameAlphaNumeric()
    {
        enterAttachmentName();
        String actualText=getAtribute(By.cssSelector("#txtAttachment"),"value",15);
        if(actualText.equals(prop.getProperty("attachmentNameAlphaNumeric")))
        {
            getTest().log(LogStatus.PASS,"\"Attachement Name\" field accepted the alpha numeric data as expected and Accepted Data : "+actualText);
        }
        else
        {
            getTest().log(LogStatus.PASS,"\"Attachement Name\" field not accepts the alpha numeric data as expected and Entered Data : "+prop.getProperty("attachmentNameAlphaNumeric"));
        }
    }
    public void termAnsConditions()
    {
        findElementVisibility(By.cssSelector(".custom-control"),20);
        clickByJavascript(By.cssSelector("div.custom-checkbox>input[name='IsTermsAndCondition']"),"Terms and Conditions",15);
        String check=findElementPresence(By.cssSelector("input.rowTermsCondition"),20).getAttribute("checked");
        if(check.equals("true"))
        {
            getTest().log(LogStatus.PASS,"\"Terms and Conditions\" checkbox is present as clickable");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"\"Terms and Conditions\" checkbox is present as not clickable");
        }
    }
    public void verifyChooseFileClickable()
    {
        WebElement chooseFile=findElementClickable(By.cssSelector("#divFiles>div>.custom-file>div>.input-group-append>span>label"),20);
        if(chooseFile!=null)
        {
            getTest().log(LogStatus.PASS,"\"Choose File\" is present as clickable");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"\"Choose File\" is not present as clickable");
        }
    }
    public void verifyAddMoreFileClickable()
    {
        WebElement addMoreFile=findElementClickable(By.cssSelector("div>#addMore"),20);
        if(addMoreFile!=null)
        {
            getTest().log(LogStatus.PASS,"\"Add More Files\" is present as clickable");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"\"Add More Files\" is not present as clickable");
        }
    }
    public void verifyClearFileClickable()
    {
        WebElement clearFile=findElementClickable(By.cssSelector("div>.clear"),20);
        if(clearFile!=null)
        {
            getTest().log(LogStatus.PASS,"\"Clear File\" is present as clickable");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"\"Clear File\" is not present as clickable");
        }
    }
    public void verifySaveButtonClickable()
    {
        WebElement saveButton=findElementClickable(By.cssSelector("a#btnSave"),20);
        if(saveButton!=null)
        {
            getTest().log(LogStatus.PASS,"\"Save Button\" is present as clickable");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"\"Save Button\" is not present as clickable");
        }
    }
    public void verifyCancelButtonClickable()
    {
        WebElement cancelButton=findElementClickable(By.cssSelector("a#btnCancel"),20);
        if(cancelButton!=null)
        {
            getTest().log(LogStatus.PASS,"\"Cancel Button\" is present as clickable");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"\"Cancel Button\" is not present as clickable");
        }
    }
    public void verifyPreviousButtonClickable()
    {
        WebElement previousButton=findElementClickable(By.cssSelector("a#Previous"),20);
        if(previousButton!=null)
        {
            getTest().log(LogStatus.PASS,"\"Previous Button\" is present as clickable");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"\"Previous Button\" is not present as clickable");
        }
    }
    public void verifyAttachmentsDetails()
    {
        SimpleDateFormat gmtDateFormat = new SimpleDateFormat("M/d/yyyy");
        gmtDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date=gmtDateFormat.format(new Date());
        String attachmentName=prop.getProperty("attachmentNameAlphaNumeric");
        String fileName=prop.getProperty("testfileDoc");

        String [] expectedArray;
                if(termsAndCondition.equals("No"))
                {
                    expectedArray= new String[]{attachmentName, fileName, termsAndCondition};
                }
                else
                {
                    expectedArray= new String[]{attachmentName, fileName, termsAndCondition,date};
                }
                int i=1;
                for(Object expected:expectedArray)
                {
                    List <WebElement> tableElement=findMultipleElement(By.xpath("//table[@id='example']//tbody//tr[1]//td"),20);
                    String actualTableContent=tableElement.get(i).getText().trim();
                    if(i==4)
                    {
                        String[] actualContentArray=actualTableContent.split(" ");
                        actualTableContent=actualContentArray[0];
                    }
                    if(expected.equals(actualTableContent))
                    {
                        getTest().log(LogStatus.PASS,expected+" data is displayed as expected in the attachment list");
                    }
                    else if (i==tableElement.size() && !expected.equals(actualTableContent))
                    {
                        getTest().log(LogStatus.FAIL,expected+" data is not displayed in the attachment list");
                    }
                    i++;
                }
    }
    public void verifyDownloadIconClickable()
    {
        scrollToWebelement(By.xpath("//table[@id='example']//tbody//tr[1]//td//a[@class='downloadfile']"),"Download");
        WebElement downloadIcon=findElementClickable(By.xpath("//table[@id='example']//tbody//tr[1]//td//a[@class='downloadfile']"),20);
        if(downloadIcon!=null)
        {
            getTest().log(LogStatus.PASS,"\"Download Icon\" is present as clickable");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"\"Download Icon\" is not present as clickable");
        }
    }
    public void verifyDeleteIconClickable()
    {
        WebElement deleteIcon=findElementClickable(By.xpath("//table[@id='example']//tbody//tr[1]//td//a[@class='deletefile']"),20);
        if(deleteIcon!=null)
        {
            getTest().log(LogStatus.PASS,"\"Delete Icon\" is present as clickable");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"\"Delete Icon\" is not present as clickable");
        }
    }
    public void verifyRemoveIconClickable()
    {
        clickAddMoreAttachment();
        WebElement removeIcon= findElementClickable(By.xpath("//div//a[contains(@class,'actionicons remove')]"),20);
        if(removeIcon!=null)
        {
            getTest().log(LogStatus.PASS,"\"Remove Icon\" is present as clickable");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"\"Remove Icon\" is not present as clickable");
        }
    }
    public void selectTermsAndConditionsYes()
    {
        termsAndCondition="Yes";
        clickByJavascript(By.cssSelector("div.custom-checkbox>input[name='IsTermsAndCondition']"),"Terms and Conditions",15);
    }
    public void uploadAttachment()
    {
        uploadDoc(By.cssSelector("div>input#flFile"), filePath + prop.getProperty("testfileDoc"), "Upload Attachment", 10);
    }
    public void clickAddMoreAttachment()
    {
            int recordsCount=findMultipleElement(By.xpath("//table[@id='example']//tbody//tr//td//a[@class='deletefile']"),20).size();
            if(recordsCount>=3)
            {
                while(recordsCount!=0) {
                    click(By.xpath("//table[@id='example']//tbody//tr[1]//td//a[@class='deletefile']"), "Delete", 20);
                    click(By.cssSelector("button.btn-success"), "Confirmation", 20);
                    waitForVisibilityOfElement(By.cssSelector("div.alert-success"), 20);
                    click(By.cssSelector("#closenotifymessage"), "Close Popup", 15);
                    recordsCount=findMultipleElement(By.xpath("//table[@id='example']//tbody//tr//td//a[@class='deletefile']"),20).size();
                }
            }
            click(By.cssSelector("a#addMore"),"Add More",15);
    }
    public void clickRemoveAttachmentField()
    {
        click(By.xpath("//div//a[contains(@class,'actionicons remove')]"),"Remove Attachment",20);
    }
    public void clickMinusIcon()
    {
        click(By.cssSelector("div>.clear"),"Clear Attachment",15);
    }
    public void clickCancelButton()
    {
        click(By.cssSelector("a#btnCancel"),"Cancel",15);
    }
    public void closeConfirmationTermsAndCondition()
    {
        List <WebElement> termsAndConditionFromTable=findMultipleElement(By.xpath("//table[@id='example']//tbody//tr//td[4]//span"),15);
        List <String> result=new ArrayList<>();
        for(WebElement element:termsAndConditionFromTable)
        {
            if(element.getText().equals("Yes"))
            {
                result.add("true");
            }
            else
            {
                result.add("false");
            }
        }
        if(result.contains("true"))
        {
            click(By.cssSelector("a#btnSave"),"Save",15);
            waitForVisibilityOfElement(By.cssSelector("div.alert-warning"),20);
            click(By.cssSelector("div.modal-confirm-footer>button.btn-success"),"Ok",15);
        }
        else
        {
            click(By.cssSelector("a#btnSave"),"Save",15);
        }
    }
    public void clickSaveButton()
    {
        closeConfirmationTermsAndCondition();
        wairForLoader(20);
    }
    public void clickPreviousButton()
    {
        click(By.cssSelector("a#Previous"),"Cancel",15);
    }
    public void clickDeleteIcon()
    {
        click(By.xpath("//table[@id='example']//tbody//tr[1]//td//a[@class='deletefile']"),"Delete",15);
    }
    public void confirmAttchmentDelete()
    {
        waitForVisibilityOfElement(By.cssSelector("div.notifybox"),20);
        click(By.cssSelector("div.modal-confirm-footer>button.btn-success"),"Ok",20);
    }
    public void clickDownloadButton()
    {
        String downloadPath = Drivers.path;
        String fileName = prop.getProperty("testfileDoc");
        File dir = new File(downloadPath + fileName);
        if (dir.exists()) {
            dir.delete();
        }
        File[] dir2 = new File(downloadPath).listFiles();
        filesInDirectory=dir2.length;
        scrollToWebelement(By.xpath("//table[@id='example']//tbody//tr[1]//td//a[@class='downloadfile']"),"Download");
        click(By.xpath("//table[@id='example']//tbody//tr[1]//td//a[@class='downloadfile']"),"Download",20);
    }
    public void verifyPlusIconFunctionality()
    {
        int attachmentNameFieldCountBefore=findMultipleElement(By.cssSelector("#txtAttachment"),15).size();
        clickAddMoreAttachment();
        int attachmentNameFieldCountAfter=findMultipleElement(By.cssSelector("#txtAttachment"),15).size();
        if(attachmentNameFieldCountBefore<attachmentNameFieldCountAfter)
        {
            getTest().log(LogStatus.PASS,"Field for add more attachment is displayed when click on the \"Add More Attchment\" icon");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"Field for add more attachment is not displayed when click on the \"Add More Attchment\" icon");
        }
    }
    public void verifyCrossIconFunctionality()
    {
        int attachmentNameFieldCountBefore=findMultipleElement(By.cssSelector("#txtAttachment"),15).size();
        clickRemoveAttachmentField();
        int attachmentNameFieldCountAfter=findMultipleElement(By.cssSelector("#txtAttachment"),15).size();
        if(attachmentNameFieldCountBefore>attachmentNameFieldCountAfter)
        {
            getTest().log(LogStatus.PASS,"Additional attachment field is not displayed as expected when click on the \"Remove More Attchment\" icon");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"Additional attachment field is not displayed as expected when click on the \"Remove More Attchment\" icon");
        }
    }
    public void verifyMinusIconFunctionality()
    {
        String attachedFileNameBefore=getAtribute(By.cssSelector("div>input#flFile"),"value",15);
        clickMinusIcon();
        String attachedFileNameAfter=getAtribute(By.cssSelector("div>input#flFile"),"value",15);
        if(attachedFileNameAfter.equals(""))
        {
            getTest().log(LogStatus.PASS,"Already attached file is removed as expected when click \"Clear Attachment\" icon");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"Already attached file is not removed as expected when click \"Clear Attachment\" icon");
        }
    }
    public void verifyManageProductPage()
    {
        WebElement manageProductPageHeader=findElementVisibility(By.xpath("//div[@class='theme-primary partition']//span[text()='Product List']"),20);
        if(manageProductPageHeader.isDisplayed())
        {
            getTest().log(LogStatus.PASS,"Manage Product page is displayed as expected when click \"Cancel\" button");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"Manage Product page is not displayed as expected when click \"Cancel\" button");
        }
    }
    public void verifyPreviousButtonFunctionality()
    {
        waitForVisibilityOfElement(By.xpath("//div[@class='theme-primary partition-full']//span[text()='Related Information']"),20);
        WebElement relatedInformationPage=findElementVisibility(By.xpath("//div[@class='theme-primary partition-full']//span[text()='Related Information']"),20);
        if(relatedInformationPage.isDisplayed())
        {
            getTest().log(LogStatus.PASS,"Related Information page is displayed as expected when click \"Previous\" button");
        }
        else
        {
            getTest().log(LogStatus.FAIL,"Related Information page is not displayed as expected when click \"Previous\" button");
        }
    }
    public void verifyDownloadedFile()
    {
        String downloadPath = Drivers.path;
        String fileName = prop.getProperty("testfileDoc");
        File dir = new File(downloadPath + fileName);
        waitTillNewFile(dir.toString(), filesInDirectory);
        boolean dirContents = dir.exists();
        if (dirContents) {
            getTest().log(LogStatus.PASS, "File is downloaded and exist in the folder");
            logger.info("File is downloaded and exist in the folder");
        } else {
            getTest().log(LogStatus.FAIL, "File is not exist in the folder");
            logger.info("File is not exist in the folder");
        }
    }
    public void verifyDeleteFunctionality()
    {
        int attachmentCountBeforeDelete=findMultipleElement(By.xpath("//table[@id='example']//tbody//tr"),20).size();
        clickDeleteIcon();
        int attachmentCountAfterDelete=findMultipleElement(By.xpath("//table[@id='example']//tbody//tr"),20).size();
        int expectedCount=attachmentCountBeforeDelete-1;
        if(expectedCount==attachmentCountAfterDelete)
        {
            getTest().log(LogStatus.PASS,"Attachment is removed from the list as expected when click on the \"Delete\" icon");
        }
        else
        {
            getTest().log(LogStatus.PASS,"Attachment is not removed from the list as expected when click on the \"Delete\" icon");
        }
    }
}
