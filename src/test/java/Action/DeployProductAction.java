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

    public void navigateToDeployProductPage()
    {
        deployProduct.clickFullMenuDropDown();
        deployProduct.clickAssetManagement();
        deployProduct.clickManageProduct();
        deployProduct.openProduct("145hhh");
        deployProduct.navigateToDeployTab();
    }
    public void verifyDeployListing()
    {
//        deployProduct.openProduct("145hhh");
//        deployProduct.navigateToDeployTab();
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
        deployProduct.verifySearchedProduct(searchItem);
    }
    public void searchFieldClearFunctionality(String searchItem)
    {
        //deployProduct.enterInSearchField(searchItem);
        deployProduct.clickClearSearch();
        deployProduct.verifyClearedSearch();
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
        deployProduct.clickAddDeployButton();
        deployProduct.selectLocationFromDropdown();
        deployProduct.enterQuantity(quantity);
        deployProduct.enterUnitPrice(unitPrice);
        deployProduct.enterModel(modelName);
        deployProduct.enterManufacturer(manufacturer);
        deployProduct.enterVendor(vendor);
        deployProduct.enterProductCost(cost);
        deployProduct.enterPurchaseOrder(purchaseOrder);
        deployProduct.clickOrderDateField();
        deployProduct.selectDate("Order",date);
        deployProduct.enterInvoiceNumber(invoiceNumber);
        deployProduct.clickInvoiceDateField();
        deployProduct.selectDate("Invoice",date);
        deployProduct.enterInsuranceNumber(insurenceNumber);
        deployProduct.enterInsurarName(insurarName);
        deployProduct.clickInsuranceDateField();
        deployProduct.selectDate("Insurance",date);
        deployProduct.clickWarrantyDateField();
        deployProduct.selectDate("Warranty",date);
        deployProduct.selectDepreciationRule(depreciationRule);
        deployProduct.enterProductLife(productLife);
        deployProduct.enterSalvageCost(salvageCost);
        deployProduct.clickAddListButton();
        deployProduct.clickSaveButton();
        deployProduct.handleSuccessPopup();
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
