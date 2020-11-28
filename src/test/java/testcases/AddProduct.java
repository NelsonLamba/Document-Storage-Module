package testcases;

import Action.AddProductAction;
import Action.LoginAction;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import utils.WebTestBase;

import static reporting.ComplexReportFactory.getTest;

public class AddProduct extends WebTestBase
{
//    @Test()
//    public void duplicateProductNameAndCodeValidation()
//    {
//        test = getTest("TC_Asset Management_7_12_13- Related Information - Verify CalibrationCommentpopup Page");
//        AddProductAction addProductAction=new AddProductAction(driver);
//        new LoginAction(driver).logoutLogin();
//        addProductAction.gotoManageProductPage();
//        addProductAction.duplicateNameAndCodeValidation();
//    }
//    @Test()
//    public void barCode()
//    {
//        test = getTest("TC_Asset Management_19 - Related Information - Verify CalibrationCommentpopup Page");
//        AddProductAction addProductAction=new AddProductAction(driver);
//        new LoginAction(driver).logoutLogin();
//        addProductAction.gotoManageProductPage();
//        addProductAction.addNewButton();
//        addProductAction.dropDownValidation();
//    }
//    @Test()
//    public  void productNameFieldValidation()
//    {
//        test = getTest("TC_Asset Management_4,5,6,8,9 - Related Information - Verify CalibrationCommentpopup Page");
//        AddProductAction addProductAction=new AddProductAction(driver);
//        new LoginAction(driver).logoutLogin();
//        addProductAction.gotoManageProductPage();
//        addProductAction.addNewButton();
//        addProductAction.ValidationsOnProductName();
//    }
//    @Test()
//    public void producCodeFieldValidation()
//    {
//        test = getTest("TC_Asset Management_7_12_13 - Related Information - Verify CalibrationCommentpopup Page");
//        AddProductAction addProductAction=new AddProductAction(driver);
//        new LoginAction(driver).logoutLogin();
//        addProductAction.gotoManageProductPage();
//        addProductAction.addNewButton();
//        addProductAction.ValidationOnProductCode();
//    }
//    @Test()
//    public void documentValidation()
//    {
//        test = getTest("TC_Asset Management_7_12_13 - Related Information - Verify CalibrationCommentpopup Page");
//        AddProductAction addProductAction=new AddProductAction(driver);
//        new LoginAction(driver).logoutLogin();
//        addProductAction.gotoManageProductPage();
//        addProductAction.addNewButton();
//        addProductAction.documentValidation();
//    }
//    @Test()
//    public void descriptionFieldValidation()
//    {
//        test = getTest("TC_Asset Management_17_18 - Related Information - Verify CalibrationCommentpopup Page");
//        AddProductAction addProductAction=new AddProductAction(driver);
//        new LoginAction(driver).logoutLogin();
//        addProductAction.gotoManageProductPage();
//        addProductAction.addNewButton();
//        addProductAction.errorMsgValidationOnDescriptiopn();
//    }
//    @Test()
//    public void errorMsgValidationOnAddProductPage()
//    {
//        test = getTest("TC_Asset Management_11_12_13_24_25_26 - Related Information - Verify CalibrationCommentpopup Page");
//        AddProductAction addProductAction=new AddProductAction(driver);
//        new LoginAction(driver).logoutLogin();
//        addProductAction.gotoManageProductPage();
//        addProductAction.addNewButton();
//        addProductAction.ErrorMessageValidation();
//    }

    @Test()
    public void addProduct()
    {
        test = getTest("TC_Asset Management_27_End-to-End - Related Information - Verify CalibrationCommentpopup Page");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.createProduct();
        addProductAction.deployTab();
    }



}
