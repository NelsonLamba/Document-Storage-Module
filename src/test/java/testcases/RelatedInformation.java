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
        test = getTest("TC_Asset Management_RelatedInformation_115");
        new LoginAction(driver).logoutLogin();
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.checkRelatedPageDetail();
    }

    @Test
    public void validationOnSearchField(){
        test = getTest("TC_Asset Management_RelatedInformation_116_117_118_119");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.searchProduct();
        relatedinfo.verifyResetTable();

    }

   @Test()
    public void ValidationOfBreadCrumbs(){
        test = getTest("TC_Asset Management_RelatedInformation_120");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.checkbreadCrumb();


    }
    @Test()
    public void barCodePrintValidation(){
        test = getTest("TC_Asset Management_RelatedInformation_121");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.barCodePrint();
        relatedinfo.verifybarCodePrintPopupPage();

    }
    @Test
    public void downloadBulkBarCodeAndVerifyDownloadedFile(){
        test = getTest("TC_Asset Management_RelatedInformation_122");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.verifydownloadBulkBarCode();

    }
  @Test
    public void checkAndEditProductUniqueNameorCode(){
        test = getTest("TC_Asset Management_RelatedInformation_123");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.clickProductUniqueNameorCode();
        relatedinfo.editUniqueproductdetails();

    }
    @Test
    public void downloadBarImageAndVerifyDownloadedFile(){
        test = getTest("TC_Asset Management_RelatedInformation_124");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.verifyDownladedBarImage();


    }
    @Test
    public void verifyCalibrationCommentpopup(){
        test = getTest("TC_Asset Management_RelatedInformation_125_126");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.checkCalibrationCommentPopup();
        relatedinfo.enterTheDetailsInCalibrationPopup();

    }
    @Test
    public void verifyAuditCommentpopup(){
        test = getTest("TC_Asset Management_RelatedInformation_127_128");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.checkAuditCommentPopup();
        relatedinfo.enterTheDetailsInAuditCommentPopup();


    }
    @Test
    public void editAndChangeStatus(){
        test = getTest("TC_Asset Management_RelatedInformation_129_132");
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
        test = getTest("TC_Asset Management_RelatedInformation_130_131");
       RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.viewHistoryPageValidations();

    }
    @Test
    public void verifyPagination(){
        test = getTest("TC_Asset Management_RelatedInformation_133");
        RelatedInformationAction relatedinfo=new RelatedInformationAction(driver);
        new LoginAction(driver).logoutLogin();
        relatedinfo.navigatetoRelatedProduct();
        relatedinfo.RelatedInformationtab();
        relatedinfo.paginationfunctionality();
    }

}
