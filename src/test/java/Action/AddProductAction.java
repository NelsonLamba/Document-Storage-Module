package Action;

import org.openqa.selenium.WebDriver;
import pageobjects.AddProductPage;

import static reporting.ComplexReportFactory.getTest;

public class AddProductAction
{
    WebDriver driver;
    AddProductPage addProductPage;
    public AddProductAction(WebDriver driver)
    {
        this.driver=driver;
        addProductPage = new AddProductPage(driver);
    }
    public void gotoManageProductPage()
    {
        addProductPage.clickFullMenuDropDown();
        addProductPage.clickAssetManagement();
        addProductPage.clickManageProduct();
    }

    public void addNewButton()
    {
        addProductPage.clickAddNewButton();
    }
    public void duplicateNameValidation()
    {
        addProductPage.getProductName();
        addProductPage.clickAddNewButton();
        addProductPage.productNameValidation();

    }
    public void duplicateProductCodeValidation()
    {
        addProductPage.getProductCode();
        addProductPage.getProductTYpe();
        addProductPage.clickAddNewButton();
        addProductPage.duplicateProductCodeValidation();
    }
    public void dropDownValidation()
    {
        addProductPage.verifyBarCodeDropDown();
    }
    public void productStatusValidation()
    {
        addProductPage.validateStatus();
    }
    public void validationsOnProductName()
    {
        addProductPage.enterProductNameHundredCharacter();
        addProductPage.enterProductNameWithAlphaNumeric();
        addProductPage.entertProductNameWithSpecialCharacter();
        addProductPage.enterProductNameWithOneCharacter();
    }
    public void productNamefieldValidation()
    {
        addProductPage.enterProductNameOneHundreadOneCharacter();
    }

    public void validationOnProductCode()
    {
        addProductPage.enterProductCodeWithAlphaNumeric();
        addProductPage.enterProductCodeSixCharacter();
    }
    public void documentValidation()
    {
        addProductPage.documentValidation();
        addProductPage.uploadDocuValidation();
    }
    public void errorMsgValidationOnDescriptiopn()
    {
        addProductPage.errorMsgValidationOnDescription();
    }
    public void descriptionFieldValidation()
    {
        addProductPage.enterDescriptionOneCharacter();
        addProductPage.enterDescriptionTwoHundredFiftyCharacter();

    }
    public void errorMessageValidation()
    {
        addProductPage.enterItemName();
        addProductPage.selectBarCodeType();
        addProductPage.clickSaveButton();
        addProductPage.productTypeValidation();
        addProductPage.selectProductType();
        addProductPage.selectBarCodeType();
        addProductPage.clickSaveButton();
        addProductPage.productNameErrorMsgValidation();
    }
    public void mandatoryFieldValidation()
    {
        addProductPage.mandatoryFieldValidation();
        addProductPage.verifymandatoryFieldValidation();
    }
    public void changeStatusWhileCreatingProduct()
    {
        addProductPage.selectProductType();
        addProductPage.enterItemName();
        addProductPage.selectBarCodeType();
        addProductPage.changeProductStatus();
    }
    public void addProduct()
    {
        addProductPage.selectProductType();
        addProductPage.enterItemName();
        addProductPage.selectBarCodeType();
        addProductPage.selectStatus();
        addProductPage.selectAudit();
        addProductPage.selectImageCapture();
        addProductPage.selectCalibration();
        addProductPage.enterProductCode();
        addProductPage.uploadDocument();
        addProductPage.enterDescription();
        addProductPage.clickTheCheckBox();
        addProductPage.enterStockValueForompany();
        addProductPage.enterStockValueForEmployee();
        addProductPage.clickSaveButton();
        addProductPage.handleSuccessPopup();
        addProductPage.manageProductPageValidation();
        addProductPage.defaultProductCodeValidation();
        addProductPage.goBackToAddProductPage();
    }

    public void deployTab()
    {
        addProductPage.clickNextButton();
    }


}
