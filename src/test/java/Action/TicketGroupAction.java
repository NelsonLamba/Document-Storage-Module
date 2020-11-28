package Action;

import org.openqa.selenium.WebDriver;
import pageobjects.TicketGroupPage;

public class TicketGroupAction extends TicketGroupPage {
    WebDriver driver;
    public TicketGroupAction(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }
    public void navigateToTicketGroup()
    {
        clickFullMenu();
        clickTicketingOption();
        clickTicketGroup();
    }
    public void addGroup1()
    {
        clickAddGroup();
        enterGroupName(1);
        selectGroupType();
        addUser(1);
        markasDefault();
        enterMaxTicket();
        enterGroupDescription();
        clickSaveGroup();
    }
    public void addGroup2()
    {
        clickAddGroup();
        enterGroupName(2);
        selectGroupType();
        addUser(2);
        markasDefault();
        enterMaxTicket();
        enterGroupDescription();
        clickSaveGroup();
    }
    public void verifyUsersGroup1()
    {
        verifyUsersinGroup("1");
        verifyDefaultUser("1");
    }
    public void verifyUsersGroup2()
    {
        verifyUsersinGroup("2");
        verifyDefaultUser("2");
    }
}
