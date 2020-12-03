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
    public void navigateToCreateProductPage()
    {
        deployProduct.clickAddDeployButton();
    }
    public void verifyDeployListing()
    {
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
    public void searchFieldClearFunctionality()
    {
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
    public void verifyAddedDeployProduct() {
        deployProduct.createDeployProduct("1","1","Automation three","Teser",
                "Tester","10","100","0001","current","0001",
                "Tester",2,"2","10");
        deployProduct.make100PageSize();
        deployProduct.verifyCreatedDeployProduct();
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
    public void errorMessageValidation()
    {
        deployProduct.clearUnitPriceField();
        deployProduct.clickAddListButton();
        deployProduct.verifymandatoryFieldValidation();
    }
    public void locationDropdownVerification()
    {
        deployProduct.clickLocationDropdown();
        deployProduct.verifyLocationDropdown();
    }
    public void locationDropdownSearchFuctionality()
    {
        deployProduct.verifySearchFieldinLocationDropdown();
        deployProduct.enterInLocationSearch("Location5");
        deployProduct.verifyLocationSearch("Location5");
    }
    public void selectAndClearLocation()
    {
        deployProduct.selectLocationValueFromDropdown();
        deployProduct.verifySelectedLocation("Location5");
        deployProduct.clearLocationSelection();
        deployProduct.verifyClearedLocation();
    }
    public void verifyLocationDropdownValues()
    {
        deployProduct.clickLocationDropdown();
        deployProduct.verifyLocations("parent");
        deployProduct.verifyLocations("child");
    }
    public void verifyQuantityField()
    {
        deployProduct.verifyQuantityMinimumChar();
        deployProduct.verifyQuantityCharandSpclChar();
        deployProduct.verifyQuantityMaxChar();
    }
    public void verifyModelandVendorNameField()
    {
        deployProduct.verifyModelFieldValidation("A1b2C3");
        deployProduct.verifyVendorFieldValidation("A1b2C3");
    }
    public void verifyManufacturerNameField()
    {
        deployProduct.verifyManufacturerFieldValidation("A1b2C3");
        deployProduct.verifyManufacturerFieldValidation("A1!b2@");
    }
    public void verifyProductCostFieldBehaviour(String condition)
    {
        deployProduct.verifyProductCostFieldBehaviour(condition);
        deployProduct.clickCloseButton();
    }
    public void verifyInsurenceRefNumFieldBehaviour(String condition)
    {
        deployProduct.verifyInsuranceRefNumFieldBehaviour(condition);
        deployProduct.clickCloseButton();
    }
    public void verifyInsurenceDateFieldBehaviour(String condition)
    {
        deployProduct.verifyInsuranceDateFieldBehaviour(condition);
        deployProduct.clickCloseButton();
    }
    public void verifyInsurerNameFieldBehaviour(String condition)
    {
        deployProduct.verifyInsurerNameFieldBehaviour(condition);
        deployProduct.clickCloseButton();
    }
    public void verifyProductCostField()
    {
        deployProduct.productCostNumbersOnly();
        deployProduct.productCostCharandSpclChar();
        deployProduct.productCostMinimum();
        deployProduct.productCostMaximum();
        deployProduct.productCostMoreThanMaximum();
    }
    public void verifyReferenceField()
    {
        deployProduct.verifyReferenceNumberFieldPesence();
        deployProduct.verifyRefernceNumberAlphaNumeric();
        deployProduct.verifyRefernceNumberSpclChar();
    }
    public void verifyDateField()
    {
        deployProduct.verifyOrderDateFieldPresence();
        deployProduct.verifyInvoiceDateFieldPresence();
    }
    public void verifyProductDateAsCurrentDate()
    {
        deployProduct.clickOrderDateField();
        deployProduct.verifyWithCurrentDate("Product");
    }
    public void verifyProductDateAsOldDate()
    {
        deployProduct.clickOrderDateField();
        deployProduct.verifyWithOldDate("Product");
    }
    public void verifyProductDateFutureDate()
    {
        deployProduct.clickOrderDateField();
        deployProduct.verifyNotClickableFutureDate();
    }
    public void verifyInvoiceNumberFieldFunctionality()
    {
        deployProduct.verifyInvoiceNumberFieldPresence();
        deployProduct.verifyInvoiceNumberAlphaNumeric();
        deployProduct.verifyInvoiceNumberSpclChar();
    }
    public void verifyInvoiceDateAsCurrentDate()
    {
        deployProduct.clickInvoiceDateField();
        deployProduct.verifyWithCurrentDate("Invoice");
    }
    public void verifyInvoiceDateAsOldDate()
    {
        deployProduct.clickInvoiceDateField();
        deployProduct.verifyWithOldDate("Invoice");
    }
    public void verifyInvoiceDateFutureDate()
    {
        deployProduct.clickInvoiceDateField();
        deployProduct.verifyNotClickableFutureDate();
    }
    public void verifyInsuranceNumandInsurerNameField()
    {
        deployProduct.verifyInsuranceNumberAlphaNumeric();
        deployProduct.verifyInsurerNameAlphaNumeric();
    }
    public void verifyInsuranceValidDateFunctionality()
    {
        deployProduct.clickInsuranceDateField();
        deployProduct.verifyWithCurrentDate("Insurance");
        deployProduct.clickInsuranceDateField();
        deployProduct.verifyClickableFutureDate("Insurance");
    }
    public void verifySelectedWarrantyDate()
    {
        deployProduct.clickWarrantyDateField();
        deployProduct.verifyWithCurrentDate("Warranty");
    }
    public void verifyPastWarrantyDate()
    {
        deployProduct.clickWarrantyDateField();
        deployProduct.verifyNotClickablePastDate();
    }
    public void verifyFutureWarrantyDate()
    {
        deployProduct.verifyClickableFutureDate("Warranty");
    }
    public void verifyDepreciationRuleFieldBehaviour(String depreciation)
    {
        deployProduct.verifyDepreciationRuleField(depreciation);
        deployProduct.clickCloseButton();
    }
    public void verifyDepreciationDropdown()
    {
        deployProduct.verifyDepreciarionDropdown();
    }
    public void verifyProducLifeField()
    {
        deployProduct.verifyProductLifeMandatory();
        deployProduct.verifyProductLifeNumeric();
        deployProduct.verifyProductLifeAlphaNumeric();
        deployProduct.verifyProductLifeMaximumChar();
    }
    public void verifySalvageCostField()
    {
        deployProduct.verifySalvageCostNumeric();
        deployProduct.verifySalvageCostCharandSpclChar();
        deployProduct.verifySalvageCostMaxChar();
        deployProduct.verifySalvageCostMorethanMaxChar();
    }
    public void cancelButtonFunctionality()
    {
        deployProduct.clickAddListButton();
        deployProduct.clickCancelButton();
        deployProduct.verifyCancelButtonFunctionality();
    }
    public void saveButtonFunctionality()
    {
        deployProduct.clickAddListButton();
        deployProduct.clickSaveButton();
        deployProduct.handleSuccessPopup();
        deployProduct.verifyCreatedDeployProduct();
    }
    public void closeButtonFunctionality()
    {
        deployProduct.clickCloseButton();
        deployProduct.verifyCloseButtonFunctionality();
    }
    public void createProductToDeploy()
    {
        deployProduct.clickLocationDropdown();
        deployProduct.selectLocationValueFromDropdown();
        deployProduct.enterQuantity("1");
        deployProduct.enterUnitPrice("1");
        deployProduct.enterModel("Automation Model Test");
        deployProduct.enterManufacturer("Automation Manufacturer Test");
        deployProduct.enterVendor("Automation Vendor Test");
        deployProduct.enterProductCost("10");
        deployProduct.enterPurchaseOrder("100");
        deployProduct.clickOrderDateField();
        deployProduct.selectDate("Current");
        deployProduct.enterInvoiceNumber("123456");
        deployProduct.clickInvoiceDateField();
        deployProduct.selectDate("Current");
        deployProduct.enterInsuranceNumber("123456");
        deployProduct.enterInsurarName("Automation Insurar Name");
        deployProduct.clickInsuranceDateField();
        deployProduct.selectDate("Future");
        deployProduct.clickWarrantyDateField();
        deployProduct.selectDate("Future");
        deployProduct.selectDepreciationRule(2);
        deployProduct.enterProductLife("2");
        deployProduct.enterSalvageCost("20");
    }
    public void addToListFunctionality()
    {
        deployProduct.verifyAddToListButton();
        deployProduct.clickAddListButton();
        deployProduct.verifyDeployList("Automation Model Test");
    }
    public void verifyPagination()
    {
        deployProduct.VerifyPaginationFunctionalities();
    }
}
