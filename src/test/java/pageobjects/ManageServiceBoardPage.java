package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.v6.B;
import utils.WebBasePage;

import java.util.Dictionary;

public class ManageServiceBoardPage extends WebBasePage
{
    WebDriver driver;
    public ManageServiceBoardPage(WebDriver driver){
        super(driver,"Manage Service Board");
        this.driver=driver;
    }
    String boardName=NameGenerator();
    String groupName1="Group-1";
    String groupName2="Group-2";

    public void clickFullMenu()
    {
        click(By.cssSelector("a#navbarDropdownPortfolio"),"Full Menu",5);
    }
    public void clickTicketingOption()
    {
        click(By.cssSelector("a[data-original-title='Ticketing']>.parentcube>span"),"Ticketing",5);
    }
    public void clickManageServiceBoard()
    {
        click(By.cssSelector("a[data-original-title='Manage Service Board']"),"Manage Service Board",5);
    }
    public void clickAddTicket()
    {
        click(By.cssSelector("#aAddticket"),"Add Ticket Service Board",10);
    }
    public void enterBoardName()
    {
        enter(By.cssSelector("input[name='TicketChainName']"),boardName,"Ticket Service Board Name",10);
    }
    public void enterSerivceBoardDescription(String boardDescription)
    {
        enter(By.cssSelector("#Description"),boardDescription,"Description",5);
    }
    public void selectBoardLevel(String boardLevel)
    {
        String level=(!boardLevel.equals("1"))?"_"+boardLevel:"";
        selectValueWithValue(By.cssSelector("select#GroupLevelId"+level),boardLevel,"Board Level",10);
    }
    public void selectBoardGroup(String boardGroup)
    {
        String value=(boardGroup.equals("1"))?"192":(boardGroup.equals("2"))?"193":"";
        String group=(!boardGroup.equals("1"))?"_"+boardGroup:"";
        selectValueWithValue(By.cssSelector("select#ddlTicketGroupIds"+group),value,"Board Group",10);
    }
    public void clickAddIcon()
    {
        click(By.cssSelector("a#btnAdd"),"Add Icon",5);
    }
    public void clickSaveButton()
    {
        click(By.cssSelector(".search-btm-btn>a#aChainTicketSave"),"Save",5);
    }
    public void verifyLevelGroupName()
    {
        String Field="";
        String boardLevel1=getText(By.xpath("(//table[@id='tblTicketChain']//td//a[contains(text(),'"+boardName+"')]//following::td//span)[1]"),5);
        String boardLevel2=getText(By.xpath("(//table[@id='tblTicketChain']//td//a[contains(text(),'"+boardName+"')]//following::td//span)[2]"),5);
        String actualGroup1=getText(By.xpath("(//table[@id='tblTicketChain']//td//a[contains(text(),'"+boardName+"')]//following::td//span)[3]"),5);
        String actualGroup2=getText(By.xpath("(//table[@id='tblTicketChain']//td//a[contains(text(),'"+boardName+"')]//following::td//span)[4]"),5);
        if(boardLevel1.equals("Level1")&&boardLevel2.equals("Level2")&&actualGroup1.equals("Group-"+groupName1)&&actualGroup2.equals("Group-"+groupName2))
        {
            System.out.println("Levels and Groups are Copied as Expected");
        }else {
            Field = (!boardLevel1.equals("Level1")) ? "Level1" : (!boardLevel2.equals("Level2")) ? "Level2" : actualGroup1.equals(groupName1)?"Group1":actualGroup2.equals(groupName2)?"Group2":"";
            System.out.println(Field+" is Not Displayed in the Ticket Service Board List");
        }
    }
}
