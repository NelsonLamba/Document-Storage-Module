package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.*;

public class AddTicketPage extends WebBasePage {
    WebDriver driver;
    public AddTicketPage(WebDriver driver)
    {
        super(driver,"Dashboard Page");
        this.driver=driver;
    }
    String ticketSubject=NameGenerator();
    String department="Sales";
    String priority="High";
    String product="Others";
    String ticketCategory="Router";
    String Ticketfor="OnBehalf";
    String UserorClient="User";
    String user="Matthew";


    public void clickFullMenu()
    {
        click(By.cssSelector("a#navbarDropdownPortfolio"),"Full Menu",5);
    }
    public void clickTicketingOption()
    {
        click(By.cssSelector("a[data-original-title='Ticketing']>.parentcube>span"),"Ticketing",5);
    }
    public void ticketingSubMenu()
    {
        click(By.xpath("//a[text()='Ticketing']"),"Ticketing Sub Menu",5);
    }
    public void clickAddTicketIcon()
    {
        click(By.cssSelector("a#aAddticket"),"Add Ticket",5);
    }
    public void enterTicketSubject()
    {
        enter(By.cssSelector("input#TicketSubject"),ticketSubject,"Subject",8);
    }
    public void selectDepartment()
    {
        String value=(department.equals("Accounts"))?"24184":(department.equals("Human Resource"))?"24185":(department=="Sales")?"24183":(department=="Support")?"24189":"";
        selectValueWithValue(By.cssSelector("#DepartmentId"),value,"Department",10);
    }
    public void selectPriority()
    {
        String value=(priority.equals("High"))?"22492":(priority.equals("Low"))?"22493":"";
        selectValueWithValue(By.cssSelector("#PriorityId"),value,"Department",10);
    }
    public void selectProduct()
    {
        String value=(product.equals("Others"))?"74":"";
        selectValueWithValue(By.cssSelector("#ProductId"),value,"Department",10);
    }
    public void selectCCUsers()
    {
        click(By.xpath("//label[text()='CC Users:']//following::button[1]"),"CC User",5);
        click(By.xpath("(//input[@class='checkmultiselect'])[3]"),"User",8);
    }
    public void selectCategory()
    {
        click(By.xpath("//label[text()='Ticket Category:']"),"Title",10);
        String value=(ticketCategory.equals("Peripherals"))?"6786":(ticketCategory.equals("Router"))?"6787":"";
        selectValueWithValue(By.cssSelector("#TicketCategoryId"),value,"Department",10);
    }
    public void selectTicketFor()
    {
        String id=(Ticketfor.equals("Self"))?"#rdo_0":(Ticketfor.equals("OnBehalf"))?"#rdo_1":"";
        clickByJavascript(By.cssSelector(id),"Ticket For",8);
    }
    public void selectOnBehalf()
    {
        String id=(UserorClient.equals("User"))?"#rdo_2":(UserorClient.equals("Client"))?"#rdo_3":"";
        clickByJavascript(By.cssSelector(id),"Ticket For",8);
    }
    public void onbehalfUser()
    {
        String value=(user.contains("Anthony"))?"64435":(user.contains("Matthew"))?"64436":"";
        selectValueWithValue(By.cssSelector("select#OnBehalfUserId"),value,"Behalf User",10);
    }
    public void addMoreDocumentField()
    {
        click(By.cssSelector("a#addMore"),"Add More Document",5);
    }
    public void uploadDocument()
    {
        driver.findElement(By.cssSelector("div>input#flFile")).sendKeys(Config.testfilePDF);
        driver.findElement(By.cssSelector("#flFile110")).sendKeys(Config.testfileDoc);
    }
    public void enterDescription()
    {
        click(By.cssSelector("#cke_12"),"Source",8);
        enter(By.cssSelector(".cke_source"),"Add Ticketing Description","Description",8);
    }
    public void clicSaveDraft()
    {
        click(By.cssSelector("a#btnSaveDraft"),"Save as Draft",8);
    }
    public void clickBackToList()
    {
        click(By.cssSelector("a#btnback"),"Back To List",10);
    }
    public void movetoEditPage()
    {
        click(By.xpath("(//a[text()='"+ticketSubject+"']//following::a[@class='btnright'])[1]"),"Option Arrow",8);
        click(By.xpath("(//a[text()='"+ticketSubject+"']//following::span[contains(text(),'Edit')])[1]"),"Edit",5);
    }
    public void submitTicket()
    {
        click(By.cssSelector("a#btnSaveTicket"),"Submit",10);
    }
    public void verifySuccessMessage()
    {
        String successMessage=getText(By.cssSelector("#divAddTicket>div>p"),10);
        if(successMessage.contains("Ticket has been successfully Submitted"))
        {
            System.out.print("Success Message is Displayed");
        }
        else
        {
            System.out.print("Success Message is not Displayed");
        }
    }
    public void verifyTicketListingPage()
    {
        String elementinListingPage=getText(By.cssSelector("span#showHideMenuParent"),10);
        if(elementinListingPage.equals("TICKETING"))
        {
            System.out.print("Ticket Listing Page is Successfully Displayed");
        }
        else
        {
            System.out.print("Ticket Listing Page is not Displayed");
        }
    }
}
