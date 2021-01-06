package Action;

import org.openqa.selenium.WebDriver;
import pageobjects.RelatedInformationPage;

public class RelatedInformationAction  {
    WebDriver driver;
    RelatedInformationPage relatedInformationPage;

    public RelatedInformationAction(WebDriver driver) {
        this.driver = driver;
        relatedInformationPage=new RelatedInformationPage(driver);
    }
    public void navigateToRelatedProduct()
    {
        relatedInformationPage.clickFullMenu();
        relatedInformationPage.clickAssertManagement();
        relatedInformationPage.clickManageProduct();
        relatedInformationPage.clickRelatedProduct();
    }
public void RelatedInformationTab()
{
    relatedInformationPage.clickRelatedInformationTab();
}

    public void checkRelatedPageDetail()
    {
        relatedInformationPage.checkRelatedPageHeaders();
    }

    public void searchProduct() {
        relatedInformationPage.checkSearchBarIsAvailable();
        relatedInformationPage.searchUniqueName();
        relatedInformationPage.clickSearchIcon();
        relatedInformationPage.verifyUniqueNameSearch();
    }

    public void verifyResetTable()
    {
        relatedInformationPage.clickResetIcon();
        relatedInformationPage.checksearchBarisEmpty();
    }
public void checkBreadCrumb()
    {
    relatedInformationPage.verifyBreadCrumb();
    }
    public void barCodePrint()
    {
        relatedInformationPage.clickBarCodePrint();
    }
    public void verifyBarCodePrintPopupPage()
    {
        relatedInformationPage.checkbarCodePrintPopupPage();
        relatedInformationPage.closeBarCodePrintPopup();
    }
public void verifyDownloadBulkBarCode()
    {
    relatedInformationPage.downloadBulkBarCode();
    relatedInformationPage.checkDownloadedBulkBarCodePdf();
    }
    public void clickProductUniqueNameOrCode()
    {
        relatedInformationPage.clickUniqueCode();
    }
    public void editUniqueProductDetails()
    {
        relatedInformationPage.editUniqueName();
        relatedInformationPage.editWarrentyDuration();
        relatedInformationPage.acquisitionDate("Future");
        relatedInformationPage.warrantyDate("Future");
        relatedInformationPage.editcost();
        relatedInformationPage.editserialnumber();
        relatedInformationPage.editLicenseKey();
        relatedInformationPage.editLicenseType();
        relatedInformationPage.editVersion();
        relatedInformationPage.editInstalledMachine();
        relatedInformationPage.editInstalledPath();
        relatedInformationPage.nextAuditDate("Future");
        relatedInformationPage.nextCalibrationDisabledField();
        relatedInformationPage.nextimageDisabledField();
        relatedInformationPage.editModelName();
        relatedInformationPage.editModelNumber();
        relatedInformationPage.editBrand();
        relatedInformationPage.editBillNumber();
        relatedInformationPage.editImeiNumber();
        relatedInformationPage.editSimNumber();
        relatedInformationPage.editphonenumber();
        relatedInformationPage.editMobileIronredSetup();
        relatedInformationPage.editAccessoryOn();
        relatedInformationPage.editMchineName();
        relatedInformationPage.editDivisionName();
        relatedInformationPage.editStatusdrpdown();
        relatedInformationPage.addAttachment();
        relatedInformationPage.editGPS();
        relatedInformationPage.laptopCarryingBagCheckBox();
        relatedInformationPage.editRFIDdisabledField();
        relatedInformationPage.editSave();
        relatedInformationPage.clickProductPopupPage();
    }
    public void verifyDownloadedBarImage()
    {
        relatedInformationPage.downloadBarImageIcon();
        relatedInformationPage.checkDownloadedBarImage();
    }
public void checkCalibrationCommentPopup(){
    relatedInformationPage.clickCalibrationComment();
    relatedInformationPage.verifyCommentPopup();
}
public void enterTheDetailsInCalibrationPopup()
{
    relatedInformationPage.chooseCalibrationStartDate("Old");
    relatedInformationPage.chooseCalibrationNextDate("Future");
    relatedInformationPage.selectCalibrationStatus();
    relatedInformationPage.enterCalibrationComment();
    relatedInformationPage.savePostCalibrationComment();
    relatedInformationPage.clickCalibrationCloseIcon();
}
    public void checkAuditCommentPopup(){
        relatedInformationPage.clickAuditComment();
        relatedInformationPage.verifyAuditCommentPopup();
    }
    public void enterTheDetailsInAuditCommentPopup()
    {
        relatedInformationPage.chooseAuditDate("Old");
        relatedInformationPage.chooseAuditNextdate("Future");
        relatedInformationPage.selectAuditStatus();
        relatedInformationPage.enterAuditComment();
        relatedInformationPage.savePostAuditComment();
        relatedInformationPage.clickAuditCloseIcon();
    }

    public void statusSection()
    {
        relatedInformationPage.clickEditStatus();

    }
    public void selectStatusDropDown()
    {
        relatedInformationPage.changeStatus();

    }
public void viewHistoryPageValidations()
{
    relatedInformationPage.viewHistoryValidations();
}

    public void paginationFunctionality()
    {
        relatedInformationPage.selectRecordPagination();
        relatedInformationPage.verifyPaginationFunctionalities();
    }


}
