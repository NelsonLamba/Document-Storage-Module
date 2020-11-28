package Action;

import org.openqa.selenium.WebDriver;
import pageobjects.UpdateTicketPage;

public class UpdateTicketAction extends UpdateTicketPage {
    WebDriver driver;
    public UpdateTicketAction(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }
    public void sendReply()
    {
        clickReplyButton();
        selectCannedReply();
        addAttachment();
        enterDescription();
        clickSubmitReply();
    }
    public void verifyandDownloadAttachment()
    {
        verifyReply();
        verifyAttachments();
        downloadAttachment();
    }
    public void verifyTicketingPage()
    {
        clickBackToList();
        verifyTicketing();
    }

}
