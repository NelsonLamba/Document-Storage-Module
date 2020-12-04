package testcases;

import Action.CompanySetupAction;
import Action.DeployProductAction;
import Action.LoginAction;
import org.testng.annotations.Test;
import utils.WebTestBase;

import static reporting.ComplexReportFactory.getTest;

public class DeployProduct extends WebTestBase {

    @Test
    public void verifyElementsPresence()
    {
        DeployProductAction deployProduct= new DeployProductAction(driver);
        test = getTest("Asset Management_31_32_33_34");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.verifyDeployListing();
        deployProduct.verifySearchandAddElementPresence();
        deployProduct.verifyPreviousandNextElementPresence();
    }
   @Test
    public void verifySearchFieldFunctionality()
   {
       DeployProductAction deployProduct=new DeployProductAction(driver);
       test = getTest("Asset Management_35_36_37");
       new LoginAction(driver).logoutLogin();
       deployProduct.navigateToDeployProductPage();
       deployProduct.searchingFunctionality();
       deployProduct.searchFieldClearFunctionality();
   }
   @Test
   public void previousAndNextButtonVerification()
   {
       DeployProductAction deployProduct=new DeployProductAction(driver);
       test = getTest("Asset Management_39_40_43");
       new LoginAction(driver).logoutLogin();
       deployProduct.navigateToDeployProductPage();
       deployProduct.breadCrumbValidation();
       deployProduct.nextButtonFunctionality();
       deployProduct.previousButtonFunctionality();
   }
   @Test
    public void verifyDeployedProduct()
   {
       DeployProductAction deployProduct=new DeployProductAction(driver);
       test = getTest("Asset Management_38_41");
       new LoginAction(driver).logoutLogin();
       deployProduct.navigateToDeployProductPage();
       deployProduct.navigateToCreateProductPage();
       deployProduct.addDeployPageVerification();
       deployProduct.verifyAddedDeployProduct();
   }
   @Test
   public void productEditPageValidation()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        test = getTest("Asset Management_44_53");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.editPageVerification();
    }

    @Test
    public void mandatoryFieldValidation()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        test = getTest("Asset Management_45_111");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.errorMessageValidation();
    }
    @Test
    public void verifyLocationDropdown()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        test = getTest("Asset Management_46_47_48_50_52_20");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.locationDropdownVerification();
        deployProduct.locationDropdownSearchFuctionality();
        deployProduct.selectAndClearLocation();
    }
    @Test
    public void verifyLocationDropdownValues()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        CompanySetupAction comapnuSetup=new CompanySetupAction(driver);
        test = getTest("Asset Management_49_51");
        new LoginAction(driver).logoutLogin();
        comapnuSetup.navigateToCompanySetupPage();
        comapnuSetup.navigateSideBarLocation();
        comapnuSetup.createChildLocation();
        comapnuSetup.getAllLocationList();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyLocationDropdownValues();
    }
    @Test
    public void verifyQuantityFieldFunctionality()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        test = getTest("Asset Management_54_55_56_57");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyQuantityField();
    }
    @Test
    public  void verifyModelandVendorManufaturerFiels()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        test = getTest("Asset Management_58_59_60_61");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyModelandVendorNameField();
        deployProduct.verifyManufacturerNameField();
    }
    @Test
    public void verifyProductCostField()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        CompanySetupAction comapnuSetup=new CompanySetupAction(driver);
        test = getTest("Asset Management_62_63_64_65_66_67_68");
        new LoginAction(driver).logoutLogin();
        comapnuSetup.navigateToCompanySetupPage();
        comapnuSetup.changeProductCostToggle(true);
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyProductCostFieldBehaviour("enable");
        comapnuSetup.navigateToCompanySetupPage();
        comapnuSetup.changeProductCostToggle(false);
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyProductCostFieldBehaviour("disable");
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyProductCostField();
    }

    @Test
    public void verifyReferencePurchaseOrder()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        test = getTest("Asset Management_69_70_71");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyReferenceField();
    }
    @Test
    public void verifyProductOrderDateField()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        test = getTest("Asset Management_72_73_74_78");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyDateField();
        deployProduct.verifyProductDateAsCurrentDate();
        deployProduct.verifyProductDateAsOldDate();
        deployProduct.verifyProductDateFutureDate();
    }
   @Test
    public void verifyInvoiceNumberField()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        test = getTest("Asset Management_75_76_77");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyInvoiceNumberFieldFunctionality();
    }
     @Test
    public void verifyInvoiceDateField()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        test = getTest("Asset Management_79_80");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyInvoiceDateAsCurrentDate();
        deployProduct.verifyInvoiceDateAsOldDate();
        deployProduct.verifyInvoiceDateFutureDate();
    }
    @Test
    public void verifyInsurenceFields()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        CompanySetupAction comapnuSetup=new CompanySetupAction(driver);
        test = getTest("Asset Management_81_82_83_84_85_86");
        new LoginAction(driver).logoutLogin();
        comapnuSetup.navigateToCompanySetupPage();
        comapnuSetup.changeInsurranceRefNumToggle(false);
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyInsurenceRefNumFieldBehaviour("disable");
        deployProduct.verifyInsurerNameFieldBehaviour("disable");
        comapnuSetup.navigateToCompanySetupPage();
        comapnuSetup.changeInsurranceRefNumToggle(true);
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyInsurenceRefNumFieldBehaviour("enable");
        deployProduct.verifyInsurerNameFieldBehaviour("enable");
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyInsuranceNumandInsurerNameField();
    }
    @Test
    public void verifyInsurenceDateField() {
        DeployProductAction deployProduct = new DeployProductAction(driver);
        CompanySetupAction comapnuSetup = new CompanySetupAction(driver);
        test = getTest("Asset Management_87_88_89_90_91");
        new LoginAction(driver).logoutLogin();
        comapnuSetup.navigateToCompanySetupPage();
        comapnuSetup.changeInsurranceRefNumToggle(false);
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyInsurenceDateFieldBehaviour("disable");
        comapnuSetup.navigateToCompanySetupPage();
        comapnuSetup.changeInsurranceRefNumToggle(true);
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyInsurenceDateFieldBehaviour("enable");
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyInsuranceValidDateFunctionality();
    }
    @Test
    public void verifyWarrantyDateField()
    {
        DeployProductAction deployProduct=new DeployProductAction(driver);
        test = getTest("Asset Management_92_93_94");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifySelectedWarrantyDate();
        deployProduct.verifyPastWarrantyDate();
        deployProduct.verifyFutureWarrantyDate();
    }
    @Test
    public void verifyInsurenceDateFieldBehaviour() {
        DeployProductAction deployProduct = new DeployProductAction(driver);
        CompanySetupAction comapnuSetup = new CompanySetupAction(driver);
        test = getTest("Asset Management_95_96_97_98_99");
        new LoginAction(driver).logoutLogin();
        comapnuSetup.navigateToCompanySetupPage();
        comapnuSetup.changeDepreciationToggle(false);
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyDepreciationRuleFieldBehaviour("disable");
        comapnuSetup.navigateToCompanySetupPage();
        comapnuSetup.changeDepreciationToggle(true);
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyDepreciationRuleFieldBehaviour("enable");
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyDepreciationDropdown();
    }
    @Test
    public void verifyProductLifeField() {
        DeployProductAction deployProduct = new DeployProductAction(driver);
        test = getTest("Asset Management_100_101_102_103_104");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifyProducLifeField();
    }
    @Test
    public void verifySalvageCostField() {
        DeployProductAction deployProduct = new DeployProductAction(driver);
        test = getTest("Asset Management_105_106_107_108");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.verifySalvageCostField();
    }
    @Test
    public void verifyAddToListFunctionality()
    {
        DeployProductAction deployProduct = new DeployProductAction(driver);
        test = getTest("Asset Management_109_110");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.createProductToDeploy();
        deployProduct.addToListFunctionality();
    }
    @Test
    public void popupButtonsFunctionality()
    {
        DeployProductAction deployProduct = new DeployProductAction(driver);
        test = getTest("Asset Management_112_113_114");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.navigateToCreateProductPage();
        deployProduct.closeButtonFunctionality();
        deployProduct.navigateToCreateProductPage();
        deployProduct.createProductToDeploy();
        deployProduct.cancelButtonFunctionality();
        deployProduct.navigateToCreateProductPage();
        deployProduct.createProductToDeploy();
        deployProduct.saveButtonFunctionality();
    }
    @Test
    public void verifyPaginationFunctionality() {
        DeployProductAction deployProduct = new DeployProductAction(driver);
        test = getTest("Asset Management_42");
        new LoginAction(driver).logoutLogin();
        deployProduct.navigateToDeployProductPage();
        deployProduct.verifyPagination();
    }
}
