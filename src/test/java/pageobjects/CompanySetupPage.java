package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebBasePage;

public class CompanySetupPage extends WebBasePage {

    WebDriver driver;
    public static String productType;

    public CompanySetupPage(WebDriver driver)
    {
        super(driver,"");
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
    public void enterLocationName(String locationName)
    {
        enter(By.cssSelector("input#LocationName"),locationName,"Location Name",15);
    }
    public void enterAddreesLine1(String addressOne)
    {
        enter(By.cssSelector("input#Address1"),addressOne,"Address Line1",15);
    }
    public void enterCity(String city)
    {
        enter(By.cssSelector("input#City"),city,"City",15);
    }
    public void selectCountry(String country)
    {
        selectValueWithText(By.cssSelector("select#ddlCountry"),country,"Country",15);
    }
    public void saveLocation()
    {
        click(By.cssSelector("a#btnSave"),"Save",15);
    }
    public void sideBarProductType()
    {
        enter(By.cssSelector(".customsearchbox>input"),"Product Type","Menu Search",15);
        click(By.xpath("//ul[@id='upper']//li//a[text()='Product Type']"),"Side Bar Product Type",15);
        wairForLoader(20);
    }
    public void sideBarLocation()
    {
        enter(By.cssSelector(".customsearchbox>input"),"Location","Menu Search",15);
        click(By.xpath("//ul[@id='upper']//li//a[text()='Location']"),"Side Bar Location",15);
        wairForLoader(20);
    }
    public void openEditProductType()
    {
        productType=getText(By.xpath("//table[@id='tblAsset']//tbody//tr[1]//td[4]//a"),15).trim();
        click(By.xpath("//table[@id='tblAsset']//tbody//tr[1]//td[4]//a"),"Edit Product Type",15);
        wairForLoader(20);
    }
    public void saveProductTypeChange()
    {
        click(By.cssSelector("a#btnSave"),"Save",15);
    }
    public void clickProductCostToggle(boolean cost)
    {
        DeployProductPage deployProduct = new DeployProductPage(driver);
        scrollToWebelement(By.xpath("//input[@id='IsItemCostN']//parent::label//span[@class='slider round']"),"ProductCost Toggle");
//        WebElement yes=findElementsVisibility(By.xpath("//input[@id='IsItemCostN']//parent::label//span[@class='slider-yes']"));
//        WebElement no=findElementsVisibility(By.xpath("//input[@id='IsItemCostN']//parent::label//span[@class='slider-no']"));
        boolean option=findElementPresence(By.id("IsItemCostN"),15).isSelected();
        if(cost)
        {
            if (!option) {
                click(By.xpath("//input[@id='IsItemCostN']//parent::label//span[@class='slider round']"), "Product Cost Yes", 15);
                saveProductTypeChange();
                wairForLoader(20);
                deployProduct.handleSuccessPopup();
            }
        }else
        {
            if (option) {
                click(By.xpath("//input[@id='IsItemCostN']//parent::label//span[@class='slider round']"), "Product Cost No", 15);
                saveProductTypeChange();
                wairForLoader(20);
                deployProduct.handleSuccessPopup();
            }
        }
    }
    public void clickInsurancePolicyToggle(boolean policy)
    {
        DeployProductPage deployProduct = new DeployProductPage(driver);
        scrollToWebelement(By.xpath("//input[@id='InsurancePolicyN']//parent::label//span[@class='slider round']"),"ProductCost Toggle");
        //WebElement yes=findElementsVisibility(By.xpath("//input[@id='InsurancePolicyN']//parent::label//span[@class='slider-yes']"));
        //WebElement no=findElementsVisibility(By.xpath("//input[@id='InsurancePolicyN']//parent::label//span[@class='slider-no']"));
        boolean option=findElementPresence(By.id("InsurancePolicyN"),15).isSelected();
        if(policy)
        {
            if (!option) {
                click(By.xpath("//input[@id='InsurancePolicyN']//parent::label//span[@class='slider round']"), "Product Cost Yes", 15);
                saveProductTypeChange();
                wairForLoader(20);
                deployProduct.handleSuccessPopup();
            }
        }else
        {
            if (option) {
                click(By.xpath("//input[@id='InsurancePolicyN']//parent::label//span[@class='slider round']"), "Product Cost No", 15);
                saveProductTypeChange();
                wairForLoader(20);
                deployProduct.handleSuccessPopup();
            }
        }
    }
    public void clickDepreciationToggle(boolean depriciation)
    {
        DeployProductPage deployProduct = new DeployProductPage(driver);
        scrollToWebelement(By.xpath("//input[@id='IsDepreciableN']//parent::label//span[@class='slider round']"),"ProductCost Toggle");
//        WebElement yes=findElementsVisibility(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][9]//div//span[@class='slider-yes']"));
//        WebElement no=findElementsVisibility(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][9]//div//span[@class='slider-no']"));
        boolean option=findElementPresence(By.id("IsDepreciableN"),15).isSelected();
        if(depriciation)
        {
            if (!option) {
                click(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][9]//div//span[@class='slider round']"), "Product Cost Yes", 15);
                saveProductTypeChange();
                wairForLoader(20);
                deployProduct.handleSuccessPopup();
            }
        }else
        {
            if (option) {
                click(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][9]//div//span[@class='slider round']"), "Product Cost No", 15);
                saveProductTypeChange();
                wairForLoader(20);
                deployProduct.handleSuccessPopup();
            }
        }
    }
}
