package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Config;
import utils.WebBasePage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class UpdateTicketPage extends WebBasePage {
    WebDriver driver;
    public UpdateTicketPage(WebDriver driver)
    {
        super(driver,"");
        this.driver=driver;
    }
    public void clickReplyButton()
    {
        sleep(5000);
        waitForVisibilityOfElement(By.cssSelector("#ancreplyloaddata"),10000);
        click(By.cssSelector("#ancreplyloaddata"),"Reply",10);
    }
    public void selectCannedReply()
    {
        selectValueWithText(By.cssSelector("select#ddlReplyTemplate"),"Thank you","Canned Reply",10);
    }
    public void addAttachment()
    {
        driver.findElement(By.cssSelector("#flFile109")).sendKeys(Config.testfilePDF);
    }
    public void enterDescription()
    {
        click(By.cssSelector("#cke_100_label"),"Soursce Icon",15);
        enter(By.cssSelector("textarea.cke_contents_ltr"),"Canned Reply Description","Description",10);
    }
    public void clickSubmitReply()
    {
        click(By.cssSelector("a#aTicketReplySave"),"Submit Reply",10);
    }
    public void verifyReply()
    {
        String reply=getText(By.xpath("//span[contains(text(),'Ticket Reply Sent By')]"),10);
        if(!reply.equals(""))
        {
            System.out.println("Reply Recorded successfully");
        }
        else
        {
            System.out.println("Reply not Recorded");
        }
    }
    public void verifyAttachments()
    {
        waitForVisibilityOfElement(By.xpath("//li//a[contains(text(),'Attachments')]"),20000);
        ArrayList<String>array=new ArrayList<>();
        click(By.xpath("//li//a[contains(text(),'Attachments')]"),"Attachments",10);
        int attachmentCount=getRowCount(By.xpath("//div[text()='1']//following::span//span[@class='sender-name']"),"Attachment Count");
        for(int i=1;i<=attachmentCount;i++)
        {
            String fileName=getText(By.xpath("(//div[text()='1']//following::span//span[@class='sender-name'])["+i+"]"),10);
            array.add(fileName);
        }
        if(array.contains("pdf.pdf"))
        {
            System.out.println("Uploaded Attachemnt is displayed");
        }else
        {
            System.out.println("Uploaded Attachemnt is not displayed");
        }
    }
    public void downloadAttachment()
    {
        try
    {
        click(By.xpath("(//div[text()='1']//following::span[@class='header-action']/a)[1]//i"), "Download", 10);
        sleep(2000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }catch (Exception e)
    {
        System.out.print(e);
    }
    }
    public void clickBackToList()
    {
        click(By.cssSelector("#ticketdetaildheader>div>a>i"),"Back To List",10);
    }
    public void verifyTicketing()
    {
        String tableheader=getText(By.cssSelector("#TICKET_NUMBER"),10);
        if(tableheader.equals("Ticket Number"))
        {
            System.out.println("Ticketing List is Displayed");
        }
        else
        {
            System.out.println("Ticketing List is not Displayed");
        }
    }
}
