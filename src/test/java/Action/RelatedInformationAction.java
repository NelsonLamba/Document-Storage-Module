package Action;

import org.openqa.selenium.WebDriver;
import pageobjects.DeployProductPage;
import pageobjects.RelatedInformationPage;

public class RelatedInformationAction  {
    WebDriver driver;
    RelatedInformationPage relatedInformationPage;

    public RelatedInformationAction(WebDriver driver) {
        this.driver = driver;
        relatedInformationPage=new RelatedInformationPage(driver);
    }
    public void navigatetoRelatedProduct()
    {
        relatedInformationPage.clickFullMenu();
        relatedInformationPage.clickAssertManagement();
        relatedInformationPage.clickManageProduct();
        relatedInformationPage.clickRelatedProduct();
    }
public void RelatedInformationtab()
{
    relatedInformationPage.clickRelatedInformationTab();
}

    public void checkRelatedPageDetail()
    {
        relatedInformationPage.checkRelatedPageheaders();
    }

    public void searchProduct() {
        relatedInformationPage.checkSearchbarisAvailable();
        relatedInformationPage.searchUniqueName();
        relatedInformationPage.clickSearchIcon();
        relatedInformationPage.verifyUniqueNameSearch();
    }

    public void verifyResetTable()
    {
        relatedInformationPage.clickResetIcon();
        relatedInformationPage.checksearchBarisEmpty();
    }
public void checkbreadCrumb()
    {
    relatedInformationPage.verifyBreadCrumb();
    }
    public void barCodePrint()
    {
        relatedInformationPage.clickbarCodePrint();
    }
    public void verifybarCodePrintPopupPage()
    {
        relatedInformationPage.checkbarCodePrintPopupPage();
        relatedInformationPage.closebarCodePrintpopup();
    }
public void verifydownloadBulkBarCode()
    {
    relatedInformationPage.downloadBulkBarCode();
    relatedInformationPage.checkDownloadedBulkBarCodePdf();
    }
    public void clickProductUniqueNameorCode()
    {
        relatedInformationPage.clickUniqueCode();
    }
    public void editUniqueproductdetails()
    {
        relatedInformationPage.editUniquename();
        relatedInformationPage.editwarrentyduration();
        relatedInformationPage.acquisitionDate("Future");
        relatedInformationPage.warrentydate("Future");
        relatedInformationPage.editcost();
        relatedInformationPage.editserialnumber();
        relatedInformationPage.editLicensekey();
        relatedInformationPage.editLicensetype();
        relatedInformationPage.editVersion();
        relatedInformationPage.editInstalledMachine();
        relatedInformationPage.editInstalledPath();
        relatedInformationPage.nextAuditDate("Future");
        relatedInformationPage.nextCalibrationdisabledfield();
        relatedInformationPage.nextimagedisabledfield();
        relatedInformationPage.editModelName();
        relatedInformationPage.editModelNumber();
        relatedInformationPage.editBrand();
        relatedInformationPage.editBillNumber();
        relatedInformationPage.editImeiNumber();
        relatedInformationPage.editSimNumber();
        relatedInformationPage.editphonenumber();
        relatedInformationPage.editmobileironredsetup();
        relatedInformationPage.editAccessoryOn();
        relatedInformationPage.editmachinename();
        relatedInformationPage.editdivisionname();
        relatedInformationPage.editStatusdrpdown();
        relatedInformationPage.addAttachment();
        relatedInformationPage.editGPS();
        relatedInformationPage.laptopCarryingBagcheckbox();
        relatedInformationPage.editRFIDdisabledfield();
        relatedInformationPage.editsave();
        relatedInformationPage.clickProductpopupPage();
    }
    public void verifyDownladedBarImage()
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
    relatedInformationPage.chooseCalibrationNextdate("Future");
    relatedInformationPage.selectCalibrationstatus();
    relatedInformationPage.enterCalibrationcomment();
    relatedInformationPage.savepostcalibrationComment();
    relatedInformationPage.clickCalibrationcloseicon();
}
    public void checkAuditCommentPopup(){
        relatedInformationPage.clickAuditComment();
        relatedInformationPage.verifyauditCommentPopup();
    }
    public void enterTheDetailsInAuditCommentPopup()
    {
        relatedInformationPage.chooseauditDate("Old");
        relatedInformationPage.chooseauditNextdate("Future");
        relatedInformationPage.selectAuditStatus();
        relatedInformationPage.enterAuditComment();
        relatedInformationPage.savepostauditComment();
        relatedInformationPage.clickauditcloseicon();
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

    public void paginationfunctionality()
    {
        relatedInformationPage.selectrecordPagination();
        relatedInformationPage.verifyPaginationFunctionalities();
    }


}
