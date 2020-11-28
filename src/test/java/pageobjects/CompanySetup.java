package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.justin.BaseTestCase;
import utils.WebBasePage;

public class CompanySetup extends WebBasePage {

    WebDriver driver;
    public static String productType;
    DeployProduct deployProduct;
    public CompanySetup(WebDriver driver)
    {
        super(driver,"Company Setup Page");
        this.driver=driver;
        this.deployProduct=new DeployProduct(driver);
    }

    public void clickCompanySetupSubMenu()
    {
        click(By.xpath("//ul[contains(@class,'submenu')]//a[text()='Company Setup']"),"Company Setup Sub Menu",15);
    }
    public void clickAddLocationButton()
    {
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
        click(By.xpath("//div[@class='mCSB_container']//ul//li//a[text()='Product Type']"),"Side bar Product Type",15);
    }
    public void openEditProductType()
    {
        productType=getText(By.xpath("//table//tbody//tr[1]//td[4]"),15).trim();
        click(By.xpath("//table//tbody//tr[1]//td[4]"),"Edit Product Type",15);
    }
    public void clickProductCostToggle(boolean cost)
    {
        WebElement yes=findElementsVisibility(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][5]//div//span[@class='slider-yes']"));
        WebElement no=findElementsVisibility(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][5]//div//span[@class='slider-no']"));
        if(cost)
        {
            if (yes == null) {
                click(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][5]//div//span[@class='slider round']"), "Product Cost Yes", 15);
            }
        }else
        {
            if (no == null) {
                click(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][5]//div//span[@class='slider round']"), "Product Cost No", 15);
            }
        }
        deployProduct.handleSuccessPopup();
    }
    public void clickInsurancePolicyToggle(boolean policy)
    {
        WebElement yes=findElementsVisibility(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][1]//div//span[@class='slider-yes']"));
        WebElement no=findElementsVisibility(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][1]//div//span[@class='slider-no']"));
        if(policy)
        {
            if (yes == null) {
                click(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][1]//div//span[@class='slider round']"), "Product Cost Yes", 15);
            }
        }else
        {
            if (no == null) {
                click(By.xpath("//span[text()='Deployment Properties:']//following::div[@class='form-group'][1]//div//span[@class='slider round']"), "Product Cost No", 15);
            }
        }
        deployProduct.handleSuccessPopup();
    }
}
