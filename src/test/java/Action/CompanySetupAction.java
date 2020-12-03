package Action;

import org.openqa.selenium.WebDriver;
import pageobjects.CompanySetupPage;
import pageobjects.DeployProductPage;

public class CompanySetupAction {
    WebDriver driver;
    CompanySetupPage companySetup;

    public CompanySetupAction(WebDriver driver)
    {
        this.driver=driver;
        companySetup= new CompanySetupPage(driver);
    }
    public void navigateToCompanySetupPage()
    {
        DeployProductPage deployProduct=new DeployProductPage(driver);
        deployProduct.clickFullMenuDropDown();
        companySetup.clickCompanySetupMenu();
        companySetup.clickCompanySetupSubMenu();
    }
    public void navigateSideBarLocation()
    {
        companySetup.sideBarLocation();
    }
    public void getAllLocationList()
    {
        DeployProductPage deployProduct=new DeployProductPage(driver);
        deployProduct.make100PageSize();
        deployProduct.getLocationsFromSetup();
    }
    public void createChildLocation()
    {
        DeployProductPage deployProduct=new DeployProductPage(driver);
        companySetup.clickAddLocationButton();
        companySetup.selectParentLocation();
        companySetup.enterLocationName("Eigth Child Location");
        companySetup.enterAddreesLine1("addressOne");
        companySetup.enterCity("city");
        companySetup.selectCountry("India");
        companySetup.saveLocation();
        deployProduct.handleSuccessPopup();
    }
    public void changeProductCostToggle(boolean productCost)
    {
        companySetup.sideBarProductType();
        companySetup.openEditProductType();
        companySetup.clickProductCostToggle(productCost);
    }
    public void changeInsurranceRefNumToggle(boolean policy)
    {
        companySetup.sideBarProductType();
        companySetup.openEditProductType();
        companySetup.clickInsurancePolicyToggle(policy);
    }
    public void changeDepreciationToggle(boolean depreciation)
    {
        companySetup.sideBarProductType();
        companySetup.openEditProductType();
        companySetup.clickDepreciationToggle(depreciation);
    }
}
