package Action;

import org.openqa.selenium.WebDriver;
import pageobjects.DeployProductPage;

public class DeployProductAction {
    WebDriver driver;
    DeployProductPage deployProduct;

    public DeployProductAction(WebDriver driver)
    {
        this.driver=driver;
        this.deployProduct= new DeployProductPage(driver);
    }

    public void verifyDeployListing()
    {
        deployProduct.openProduct("145hhh");
        deployProduct.navigateToDeployTab();
        deployProduct.verifyListingColumnHeader();
    }
    public void verifySearchandAddElementPresence()
    {
        deployProduct.verifySearchBar();
        deployProduct.verifyDepolyProductAddButton();
    }
    public void verifyPreviousandNextElementPresence()
    {
        deployProduct.verifyPreviousButton();
        deployProduct.verifyNextButton();
    }
    public void searchingFunctionality(String searchItem)
    {
        deployProduct.enterInSearchField(searchItem);
        deployProduct.clickSearchButton();
    }
    public void searchFieldClearFunctionality(String searchItem)
    {
        deployProduct.enterInSearchField(searchItem);
        deployProduct.clickClearSearch();
    }
    public void addDeployPageVerification()
    {
        deployProduct.verifyAddDeployProductPage();
    }
    public void nextButtonFunctionality()
    {
        deployProduct.clickNextButton();
        deployProduct.verifyNextPage();
    }
    public void previousButtonFunctionality()
    {
        deployProduct.clickPreviousButton();
        deployProduct.verifyPreviousPage();
    }
    public void verifyAddedDeployProduct(String quantity,String unitPrice,String modelName,String manufacturer,
                                         String vendor,String cost,String purchaseOrder,String invoiceNumber,String date,
                                         String insurenceNumber,String insurarName,int depreciationRule,String productLife,String salvageCost)
    {
        deployProduct.addDeployProduct(quantity,unitPrice,modelName,manufacturer,vendor,cost,purchaseOrder,invoiceNumber,date,
                insurenceNumber,insurarName,depreciationRule,productLife,salvageCost);
        deployProduct.verifyDeployList();
        deployProduct.verifyCreatedDeployProduct(modelName);
    }
    public void breadCrumbValidation()
    {
        deployProduct.verifyBreadCrumb();
    }
    public void editPageVerification()
    {
        deployProduct.navigateToProductEditMode();
        deployProduct.verifyEditMode();
    }
}
