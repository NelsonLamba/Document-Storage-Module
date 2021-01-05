package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertiesLoader;
import utils.WebBasePage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class CompanySetupPage extends WebBasePage {

    WebDriver driver;
    public static String productType;
    String pattern = "yyyyMMddHHmmss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String dateValue = simpleDateFormat.format(new Date());
    private final static String FILE_NAME = System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties";
    private static Properties prop = new PropertiesLoader(FILE_NAME).load();

    public CompanySetupPage(WebDriver driver)
    {
        super(driver,"Company setup page");
        this.driver=driver;
    }

    public void clickCompanySetupMenu()
    {
        click(By.cssSelector("[data-name='COMPANY']>a"),"Company Setup menu",15);
    }
    public void clickCompanySetupSubMenu()
    {
        click(By.xpath("//ul[contains(@class,'submenu')]//a[text()='Company Setup']"),"Company Setup Sub Menu",15);
    }
    public void clickAddLocationButton()
    {
        scrollToWebelement(By.cssSelector("span#showHideMenuParent"),"Add Location");
        click(By.cssSelector("a#ancCreateLocation"),"Add Location",15);
    }
    public void selectParentLocation()
    {
        click(By.cssSelector("div#divmultilevelselect>div>div"),"Parent Location Dropdown",15);
        click(By.xpath("//ul[@id='CompantLocationSelect']//li[@class='parentli'][1]//span"),"Parent Location Value",15);
    }
    public void enterLocationName()
    {
        enter(By.cssSelector("input#LocationName"),prop.getProperty("childLocationName")+dateValue,"Location Name",15);
    }
    public void enterAddreesLine1()
    {
        enter(By.cssSelector("input#Address1"),"Address Line1","Address Line1",15);
    }
    public void enterCity()
    {
        enter(By.cssSelector("input#City"),"City","City",15);
    }
    public void selectCountry()
    {
        selectValueWithText(By.cssSelector("select#ddlCountry"),"India","Country",15);
    }
    public void saveLocation()
    {
        click(By.cssSelector("a#btnSave"),"Save",15);
    }
    public void sideBarProductType()
    {
        findElementVisibility(By.cssSelector(".customsearchbox>input"),15);
        enter(By.cssSelector(".customsearchbox>input"),"Product Type","Menu Search",15);
        click(By.xpath("//ul[@id='upper']//li//a[text()='Product Type']"),"Side Bar Product Type",15);
        waitForLoader(20);
    }
    public void sideBarLocation()
    {
        enter(By.cssSelector(".customsearchbox>input"),"Location","Menu Search",15);
        click(By.xpath("//ul[@id='upper']//li//a[text()='Location']"),"Side Bar Location",15);
        waitForLoader(20);
    }
    public void openEditProductType()
    {
        productType=getText(By.xpath("//table[@id='tblAsset']//tbody//tr[1]//td[4]//a"),15).trim();
        click(By.xpath("//table[@id='tblAsset']//tbody//tr[1]//td[4]//a"),"Edit Product Type",15);
        waitForLoader(20);
    }
    public void saveProductTypeChange()
    {
        click(By.cssSelector("a#btnSave"),"Save",15);
    }
    public void confirmationPopup()
    {
            findElementsVisibility(By.cssSelector("div.modal-confirm-footer"));
            click(By.cssSelector("div.modal-confirm-footer>button"), "Confirmation Ok", 15);
    }
    public void clickProductCostToggle(boolean cost)
    {
        DeployProductPage deployProduct = new DeployProductPage(driver);
        scrollToWebelement(By.xpath("//input[@id='IsItemCostN']//parent::label//span[@class='slider round']"),"ProductCost Toggle");
        boolean option=findElementPresence(By.id("IsItemCostN"),15).isSelected();
        if(cost)
        {
            if (!option) {
                click(By.xpath("//input[@id='IsItemCostN']//parent::label//span[@class='slider round']"), "Product Cost Yes", 15);
                saveProductTypeChange();
                waitForLoader(20);
                deployProduct.handleSuccessPopup();
            }
        }else
        {
            if (option) {
                boolean depreciationOption=findElementPresence(By.id("IsDepreciableN"),15).isSelected();
                if(depreciationOption)
                {
                    click(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][9]//div//span[@class='slider round']"), "Product Cost No", 15);
                }
                click(By.xpath("//input[@id='IsItemCostN']//parent::label//span[@class='slider round']"), "Product Cost No", 15);
                saveProductTypeChange();
                waitForLoader(20);
                deployProduct.handleSuccessPopup();
            }
        }
    }
    public void clickInsurancePolicyToggle(boolean policy)
    {
        DeployProductPage deployProduct = new DeployProductPage(driver);
        scrollToWebelement(By.xpath("//input[@id='InsurancePolicyN']//parent::label//span[@class='slider round']"),"ProductCost Toggle");
        boolean option=findElementPresence(By.id("InsurancePolicyN"),15).isSelected();
        if(policy)
        {
            if (!option) {
                click(By.xpath("//input[@id='InsurancePolicyN']//parent::label//span[@class='slider round']"), "Product Cost Yes", 15);
                saveProductTypeChange();
                waitForLoader(20);
                deployProduct.handleSuccessPopup();
            }
        }else
        {
            if (option) {
                click(By.xpath("//input[@id='InsurancePolicyN']//parent::label//span[@class='slider round']"), "Product Cost No", 15);
                saveProductTypeChange();
                waitForLoader(20);
                deployProduct.handleSuccessPopup();
            }
        }
    }
    public void clickDepreciationToggle(boolean depriciation)
    {
        DeployProductPage deployProduct = new DeployProductPage(driver);
        scrollToWebelement(By.xpath("//input[@id='IsDepreciableN']//parent::label//span[@class='slider round']"),"ProductCost Toggle");
        boolean option=findElementPresence(By.id("IsDepreciableN"),15).isSelected();
        if(depriciation)
        {
            if (!option) {
                boolean productCost=findElementPresence(By.id("IsItemCostN"),15).isSelected();
                if(!productCost)
                {
                    click(By.xpath("//input[@id='IsItemCostN']//parent::label//span[@class='slider round']"), "Product Cost Yes", 15);
                }
                click(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][9]//div//span[@class='slider round']"), "Product Cost Yes", 15);
                saveProductTypeChange();
                waitForLoader(20);
                deployProduct.handleSuccessPopup();
            }
        }else
        {
            if (option) {
                click(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][9]//div//span[@class='slider round']"), "Product Cost No", 15);
                saveProductTypeChange();
                waitForLoader(20);
                deployProduct.handleSuccessPopup();
            }
        }
    }
}
