package testcases;

import Action.AddProductAction;
import Action.LoginAction;
import org.testng.annotations.Test;
import utils.WebTestBase;

import static reporting.ComplexReportFactory.getTest;

public class AddProduct extends WebTestBase
{
    @Test()
    public void addProduct()
    {
        test = getTest("TC_Asset Management_15_21_27_28");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.addProduct();
        addProductAction.deployTab();
    }
    @Test()
    public void changeStatusWhileCreatingProduct()
    {
        test = getTest("TC_Asset Management_1_3");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.changeStatusWhileCreatingProduct();

    }
    @Test()
    public void duplicateProductNameValidation()
    {
        test = getTest("TC_Asset Management_7_12_13");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.duplicateNameValidation();
    }
    @Test()
    public  void productNameValidation()
    {
        test = getTest("TC_Asset Management_4,6,8,9");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.validationsOnProductName();
    }
    @Test()
    public void productNameFieldValidation()
    {
        test = getTest("TC_Asset Management_5");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.productNamefieldValidation();
    }
    @Test()
    public void barCode()
    {
        test = getTest("TC_Asset Management_19_20");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.dropDownValidation();
    }
    @Test()
    public void productStatusfieldValidation()
    {
        test = getTest("TC_Asset Management_2");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.productStatusValidation();
    }
    @Test()
    public void duplicateCodeValidation()
    {
        test = getTest("TC_Asset Management_12_13");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.duplicateProductCodeValidation();
    }
    @Test()
    public void productCodeValidation()
    {
        test = getTest("TC_Asset Management_11_14");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.validationOnProductCode();
    }

    @Test()
    public void documentValidation()
    {
        test = getTest("TC_Asset Management_29_30");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.documentValidation();
    }
    @Test()
    public void descriptionFieldErrorMessageValidation()
    {
        test = getTest("TC_Asset Management_17");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.errorMsgValidationOnDescriptiopn();
    }
    @Test()
    public void descriptionFieldValidation()
    {
        test = getTest("TC_Asset Management_16_18");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.descriptionFieldValidation();
    }
    @Test()
    public void errorMsgValidationOnAddProductPage()
    {
        test = getTest("TC_Asset Management_11_12_13");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.errorMessageValidation();
    }
    @Test()
    public void mandatoryFieldValidation()
    {
        test = getTest("TC_Asset Management_10_24_25_26");
        AddProductAction addProductAction=new AddProductAction(driver);
        new LoginAction(driver).logoutLogin();
        addProductAction.gotoManageProductPage();
        addProductAction.addNewButton();
        addProductAction.mandatoryFieldValidation();
    }

}
