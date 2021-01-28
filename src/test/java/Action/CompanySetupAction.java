package Action;

import org.openqa.selenium.WebDriver;
import pageobjects.CompanySetupPage;
import pageobjects.DeployProductPage;

public class CompanySetupAction {
    WebDriver driver;
    CompanySetupPage companySetup;

    public CompanySetupAction(WebDriver driver) {
        this.driver = driver;
        companySetup = new CompanySetupPage(driver);
    }

    public void navigateToCompanySetupPage() {
        companySetup.clickFullMenu();
        companySetup.clickCompanySetupMenu();
        companySetup.clickCompanySetupSubMenu();
    }

    public void navigateSideBarLocation() {
        companySetup.sideBarLocation();
    }

    public void getAllLocationList() {
        DeployProductPage deployProduct = new DeployProductPage(driver);
        deployProduct.make100PageSize();
        deployProduct.getLocationsFromSetup();
    }

    public void createChildLocation() {
        DeployProductPage deployProduct = new DeployProductPage(driver);
        companySetup.clickAddLocationButton();
        companySetup.selectParentLocation();
        companySetup.enterLocationName();
        companySetup.enterAddreesLine1();
        companySetup.enterCity();
        companySetup.selectCountry();
        companySetup.saveLocation();
        deployProduct.handleSuccessPopup();
    }

    public void changeProductCostToggle(boolean productCost) {
        companySetup.sideBarProductType();
        companySetup.openEditProductType();
        companySetup.clickProductCostToggle(productCost);
    }

    public void changeInsuranceRefNumToggle(boolean policy) {
        companySetup.sideBarProductType();
        companySetup.openEditProductType();
        companySetup.clickInsurancePolicyToggle(policy);
    }

    public void changeDepreciationToggle(boolean depreciation) {
        companySetup.sideBarProductType();
        companySetup.openEditProductType();
        companySetup.clickDepreciationToggle(depreciation);
    }
}
