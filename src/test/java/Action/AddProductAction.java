package Action;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.AddProductPage;
import pageobjects.ErrorValidationPage;

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
    public void duplicateNameAndCodeValidation()
    {
        addProductPage.getProductName();
        addProductPage.getProductCode();
        addProductPage.clickAddNewButton();
        addProductPage.productNameValidation();
        addProductPage.productCodeValidation();
    }
    public void dropDownValidation()
    {
        addProductPage.verifyBarCodeDropDown();
    }
    public void ValidationsOnProductName()
    {
        Page:getTest().log(LogStatus.INFO, "Asset Management_ - Start *************************");
        addProductPage.enterProductName100Character();
        addProductPage.enterProductName101Character();
        addProductPage.enterProductNameWithAlphaNumeric();
        addProductPage.entertProductNameWithSpecialCharacter();
        addProductPage.enterProductNameWith1Character();
        getTest().log(LogStatus.INFO, "Asset Management_4,5,6,8,9 - End *************************");

    }

    public void ValidationOnProductCode()
    {
        Page:getTest().log(LogStatus.INFO, "Asset Management_11,14 - Start *************************");
        addProductPage.enterProductCodeWithAlphaNumeric();
        addProductPage.enterProductCode6Character();
        addProductPage.enterProductCode7Character();
        getTest().log(LogStatus.INFO, "Asset Management_11,14 - End *************************");
    }
    public void documentValidation()
    {
        Page:getTest().log(LogStatus.INFO, "Asset Management_30 - Start *************************");
        addProductPage.documentValidation();
        getTest().log(LogStatus.INFO, "Asset Management_30 - End *************************");
    }
    public void errorMsgValidationOnDescriptiopn()
    {
        Page:getTest().log(LogStatus.INFO, "Asset Management_17,18 - Start *************************");
        addProductPage.enterDescription1Character();
        addProductPage.errorMsgValidationOnDescription();
        getTest().log(LogStatus.INFO, "Asset Management_17,18 - End *************************");
    }
    public void ErrorMessageValidation()
    {
        Page:getTest().log(LogStatus.INFO, "Asset Management_24 - Start *************************");
        addProductPage.enterItemName();
        addProductPage.selectBarCodeType();
        addProductPage.clickSaveButton();
        addProductPage.productTypeValidation();
        addProductPage.selectProductType();
        addProductPage.selectBarCodeType();
        addProductPage.clickSaveButton();
        addProductPage.productNameErrorMsgValidation();
        addProductPage.mandatoryFieldValidation();
        addProductPage.verifymandatoryFieldValidation();
        getTest().log(LogStatus.INFO, "Asset Management_24 - End *************************");
    }
    public void createProduct()
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
        addProductPage.enterDescription250Character();
        addProductPage.clickTheCheckBox();
        addProductPage.enterStockValueForompany();
        addProductPage.enterStockValueForEmployee();
        addProductPage.clickSaveButton();
        addProductPage.handleSuccessPopup();
        addProductPage.manageProductPageValidation();
        addProductPage.pCodeValidation();
        addProductPage.goBackToAddProductPage();
    }

    public void deployTab()
    {
        addProductPage.clickNextButton();
    }


}
