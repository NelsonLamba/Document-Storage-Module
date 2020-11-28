package Action;


import org.openqa.selenium.WebDriver;
import pageobjects.ManageServiceBoardPage;
import utils.WebBasePage;


public class ManageServiceBoardAction extends ManageServiceBoardPage {


    WebDriver driver;
    public ManageServiceBoardAction(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void createTicketServiceBoard()
    {
        clickFullMenu();
        clickTicketingOption();
        clickManageServiceBoard();
        clickAddTicket();
        enterBoardName();
        enterSerivceBoardDescription("Board Name-2 Description");
        selectBoardLevel("1");
        selectBoardGroup("1");
        clickAddIcon();
        selectBoardLevel("2");
        selectBoardGroup("2");
        clickSaveButton();
    }
    public void verifyLevelandGroupName()
    {
        verifyLevelGroupName();
    }

}
