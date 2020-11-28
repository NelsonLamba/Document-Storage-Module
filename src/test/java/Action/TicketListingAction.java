package Action;

import org.openqa.selenium.WebDriver;
import pageobjects.TicketListingPage;

public class TicketListingAction extends TicketListingPage {
    WebDriver driver;

    public TicketListingAction(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void validateTicketCount() {
        countInPagination();
        rowCount();
        verifyRecordCount();
    }

    public void verifyStausSort(){
        selectRecordStatus();
        clickSearchButton();
        verifyStatus();
        clickResetButton();
    }

    public void verifyCreatedBySort() {
        selectopenBy();
        clickSearchButton();
        verifyCreatedBy();
        clickResetButton();
    }

    public void verifyUpdatePage() {
        verifytheUpdateScreen();
    }
}


