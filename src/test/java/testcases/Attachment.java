package testcases;

import Action.AttachmentsAction;
import Action.LoginAction;
import org.testng.annotations.Test;
import utils.WebTestBase;

import static reporting.ComplexReportFactory.getTest;

public class Attachment extends WebTestBase {

    /*@Test
    public void verifyElementClickableOne()
    {
        AttachmentsAction attachmentsAction=new AttachmentsAction(driver);
        test = getTest("Asset Management_138_139_140");
        new LoginAction(driver).logoutLogin();
        attachmentsAction.navigateToAttachmentPage();
        attachmentsAction.verifyFieldClickable();
    }
    @Test
    public void verifyElementClickableTwo()
    {
        AttachmentsAction attachmentsAction=new AttachmentsAction(driver);
        test = getTest("Asset Management_134_135_136_137");
        new LoginAction(driver).logoutLogin();
        attachmentsAction.navigateToAttachmentPage();
        attachmentsAction.nameCheckBoxUpload();
    }
   @Test
    public void verifyAttachmentListDetails()
    {
        AttachmentsAction attachmentsAction=new AttachmentsAction(driver);
        test = getTest("Asset Management_141_144");
        new LoginAction(driver).logoutLogin();
        attachmentsAction.navigateToAttachmentPage();
        attachmentsAction.addAttachmentToList();
        attachmentsAction.verifyAttachmentList();
    }*/
     @Test
    public void verifyDownloadAndDeleteFunctions()
    {
        AttachmentsAction attachmentsAction=new AttachmentsAction(driver);
        test = getTest("Asset Management_145_146");
        new LoginAction(driver).logoutLogin();
        attachmentsAction.navigateToAttachmentPage();
//        attachmentsAction.addAttachmentToList();
        attachmentsAction.downloadFunctionality();
        attachmentsAction.deleteFunctionality();
    }
    /*@Test
    public void verifyPreviousAndCancel()
    {
        AttachmentsAction attachmentsAction = new AttachmentsAction(driver);
        test = getTest("Asset Management_142_143");
        new LoginAction(driver).logoutLogin();
        attachmentsAction.navigateToAttachmentPage();
        attachmentsAction.previousButtonFunctionality();
        attachmentsAction.cancelButtonFunctionality();
    }*/
}
