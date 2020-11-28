package Action;

import org.openqa.selenium.WebDriver;
import pageobjects.AddTicketPage;

public class AddTicketAction extends AddTicketPage  {
    WebDriver driver;
    public AddTicketAction(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }
    public void navigatetoAddTicket()
    {
        clickFullMenu();
        clickTicketingOption();
        ticketingSubMenu();
    }
    public void addTicket()
    {
        clickAddTicketIcon();
        enterTicketSubject();
        selectDepartment();
        selectPriority();
        selectProduct();
        selectCCUsers();
        selectCategory();
        selectTicketFor();
        selectOnBehalf();
        onbehalfUser();
        addMoreDocumentField();
        uploadDocument();
        enterDescription();
        clicSaveDraft();
        clickBackToList();
    }
    public void editTicket()
    {
        movetoEditPage();
        submitTicket();
    }
    public void verifyNavigations()
    {
        verifySuccessMessage();
        clickBackToList();
        verifyTicketListingPage();
    }
}
