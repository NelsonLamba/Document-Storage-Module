package testcases;

import Action.DeployProductAction;
import Action.LoginAction;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import utils.WebTestBase;

import static reporting.ComplexReportFactory.getTest;

public class DeployProduct extends WebTestBase {
    @Test()
    public void Login()
    {
        test = getTest("Asset Management_Login - Start *************************");
        LoginAction login = new LoginAction(driver);
        login.enterCredentials();
        login.submit();
        test = getTest("Asset Management_Login - End *************************");
    }
   /* @Test()
    public void verifyElementsPresence()
    {
        DeployProductAction deployProduct= new DeployProductAction(driver);
        test = getTest("Asset Management_31_32_33_34 - Start *************************");
        deployProduct.navigateToDeployProductPage();
        deployProduct.verifyDeployListing();
        deployProduct.verifySearchandAddElementPresence();
        deployProduct.verifyPreviousandNextElementPresence();
        getTest().log(LogStatus.INFO, "Asset Management_31_32_33_34 - End *************************");
    }*/
   @Test()
    public void verifySearchFieldFunctionality()
   {
       DeployProductAction deployProduct=new DeployProductAction(driver);
       test = getTest("Asset Management_35_36_37 - Start *************************");
       deployProduct.navigateToDeployProductPage();
       deployProduct.searchingFunctionality("New york");
       deployProduct.searchFieldClearFunctionality("New york");
       test = getTest("Asset Management_35_36_37 - End *************************");
   }
}
