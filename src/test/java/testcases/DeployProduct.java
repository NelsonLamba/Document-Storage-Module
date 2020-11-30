package testcases;

import Action.LoginAction;
import Action.DeployProductAction;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import utils.WebTestBase;

import static reporting.ComplexReportFactory.getTest;

public class DeployProduct extends WebTestBase {

    @Test()
    public void Login()
    {
        LoginAction login = new LoginAction(driver);
        login.enterCredentials();
        login.submit();
    }
    /*@Test()
    public void verifyElementsPresence()
    {
        test = getTest("Asset Management_31_32_33_34 - Start *************************");
        DeployProductAction deployProduct= new DeployProductAction(driver);
        deployProduct.verifyDeployListing();
        deployProduct.verifySearchandAddElementPresence();
        deployProduct.verifyPreviousandNextElementPresence();
        getTest().log(LogStatus.INFO, "Asset Management_31_32_33_34 - End *************************");
    }*/
}
