package testcases;

import Action.LoginAction;
import Action.RelatedInformationAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.WebTestBase;

import static reporting.ComplexReportFactory.getTest;

public class RelatedInformation extends WebTestBase {
    @Test
    public void checkRelatedPageDetail(){
        test = getTest("TC_Asset Management_115 - Related Information Section");
        new LoginAction(driver).logoutLogin();
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.checkRelatedPageDetail();
    }

    @Test
    public void validationOnSearchField(){
        test = getTest("TC_Asset Management_116_117_118_119 - verify Search button functionality");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.searchProduct();
        relatedinfo.verifyResetTable();

    }

   @Test()
    public void ValidationOfBreadCrumbs(){
        test = getTest("TC_Asset Management_120 - Related Information - verify Reset button functionality");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.checkbreadCrumb();


    }
    @Test()
    public void barCodePrintValidation(){
        test = getTest("TC_Asset Management_121 - Related Information - Verify BarCodePrint Functionality");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.barCodePrint();
        relatedinfo.verifybarCodePrintPopupPage();

    }
    @Test
    public void downloadBulkBarCodeAndVerifyDownloadedFile(){
        test = getTest("TC_Asset Management_122 - Related Information - Verify downloadBulkBarCode Functionality");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.verifydownloadBulkBarCode();

    }
  @Test
    public void checkAndEditProductUniqueNameorCode(){
        test = getTest("TC_Asset Management_123 - Related Information - Edit the UniqueName and Code Details");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.clickProductUniqueNameorCode();//edit function added
        relatedinfo.editUniqueproductdetails();

    }
    @Test
    public void downloadBarImageAndVerifyDownloadedFile(){
        test = getTest("TC_Asset Management_124 - Related Information - Verify DownloadBarImage Functionality");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.verifyDownladedBarImage();


    }
    @Test
    public void verifyCalibrationCommentpopup(){
        test = getTest("TC_Asset Management_125_126 - Related Information - Verify CalibrationCommentpopup Page");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.checkCalibrationCommentPopup();
        relatedinfo.enterTheDetailsInCalibrationPopup();

    }
    @Test
    public void verifyAuditCommentpopup(){
        test = getTest("TC_Asset Management_127_128 - Related Information - Verify AuditCommentpopup Page");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.checkAuditCommentPopup();
        relatedinfo.enterTheDetailsInAuditCommentPopup();


    }
    @Test
    public void editAndChangeStatus(){
        test = getTest("TC_Asset Management_129_132 - Related Information - Verify EditStatus Functionality");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.statusSection();
        relatedinfo.selectStatusDropDown();

    }
    @Test
    public void viewHistoryPageValidations()
    {
        test = getTest("TC_Asset Management_130_131 - Related Information - Header validation on View History,ProductInformation tab and Pending checkOut List");
       RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.viewHistoryPageValidations();

    }
    @Test
    public void verifyPagination(){
        test = getTest("TC_Asset Management_133 - Related Information - Verify Pagination Functionality");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.paginationfunctionality();
        relatedinfo.checkRecordscount();
    }

}
