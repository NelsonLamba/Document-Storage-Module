package Action;
import org.openqa.selenium.WebDriver;
import pageobjects.SLAPage;

public class SLAAction extends SLAPage {
    WebDriver driver;
    public SLAAction(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void createSLA()
    {
        clickFullMenu();
        clickTicketingOption();
        clickSLAOption();
        clickAddIcon();
        enterPolicyName();
        selectPolicyDate();
        enterDescription();
        selectApplyOnSection();
        clickAddTargetButton();
        selectOptionsFromDropdown();
        clickSaveButton();
        clickAddResultButton();
        selectResultType();
        selectServiceBoard();
        saveResult();
        setStartandEndTime();
        enterEndTime();
        selectDays();
        fillTargets();
        fillViolationTimeReminder();
        saveSLA();
    }
    public void verifySLAinTheList()
    {
        verifyCreatedSLA();
    }
}

