package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebBasePage;

import java.util.ArrayList;

public class TicketGroupPage extends WebBasePage {
    WebDriver driver;
    String userAddinGroup;
    String group1Name=NameGenerator();
    String groupType="Routing";

    public TicketGroupPage(WebDriver driver)
    {
        super(driver,"");
        this.driver=driver;
    }
    public void clickFullMenu()
    {
        click(By.cssSelector("a#navbarDropdownPortfolio"),"Full Menu",5);
    }
    public void clickTicketingOption()
    {
        click(By.cssSelector("a[data-original-title='Ticketing']>.parentcube>span"),"Ticketing",5);
    }
    public void clickTicketGroup()
    {
        click(By.xpath("//a[text()='Ticket Group']"),"Ticket Group",10);
    }
    public void clickAddGroup()
    {
        click(By.cssSelector("a[data-original-title='Add Group']"),"Add Ticket Group",20);
    }

    String group2Name=NameGenerator();
    public void enterGroupName(int group)
    {
        String groupName=(group==1)?group1Name:(group==2)?group2Name:"";
        enter(By.cssSelector("#TicketGroupName"),groupName,"Group Name",10);
    }
    public void selectGroupType()
    {
        String id=(groupType.equals("Call"))?"#rdo_0":(groupType.equals("Routing"))?"#rdo_1":"";
        clickByJavascript(By.cssSelector(id),"Group Type",10);
    }
    public void addUser(int Iteration)
    {
        String id=(Iteration==1)?"btnAdd_64435":(Iteration==2)?"btnAdd_64436":"";
        click(By.cssSelector("#"+id),"Add Action of User",10);
        userAddinGroup=getText(By.xpath("//a[@id='"+id+"']/preceding::td[2]"),10);
    }
    public void markasDefault()
    {
        clickByJavascript(By.cssSelector("#rdo_2"),"Mark as Default",10);
    }
    public void enterMaxTicket()
    {
        enter(By.cssSelector("td>input#maxticketassign"),"10","Max Ticket Assign",10);
    }
    public void enterGroupDescription()
    {
        enter(By.cssSelector("#Description"),"Group Desction","Group Description",10);
    }
    public void clickSaveGroup()
    {
        click(By.cssSelector("div>a#aGroupTicketSave"),"Group Save",10);
        sleep(8000);
    }
    public void verifyUsersinGroup(String group)
    {
        String groupName=(group.equals("1"))?group1Name:(group.equals("2"))?group2Name:"";
        String userinTable=getText(By.xpath("//td//a[contains(text(),'"+groupName+"')]//following::td[2]//span"),10);
        if(userinTable.equals(userAddinGroup))
        {
            System.out.println("User Added to the Group is displayed in the table");
        }
        else
        {
            System.out.println("User Added to the Group is not displayed in the table");
        }
    }
    public void verifyDefaultUser(String group)
    {
        String groupName=(group.equals("1"))?group1Name:(group.equals("2"))?group2Name:"";
        String defaultUserinTable=getText(By.xpath("//td//a[contains(text(),'"+groupName+"')]//following::td[3]//span"),10);
        if(defaultUserinTable.equals(userAddinGroup))
        {
            System.out.println("Selected Default User in the Group creation is displayed in the table");
        }
        else
        {
            System.out.println("Selected Default User in the Group creation is not displayed in the table");
        }
    }

}
