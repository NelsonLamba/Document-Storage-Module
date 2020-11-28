package testcases;

import Action.*;

import org.testng.annotations.Test;
import utils.WebTestBase;

public class TestTicketing extends WebTestBase {

    @Test(priority = 0)
    public void Login()
    {
        LoginAction login = new LoginAction(driver);
        login.enterCredentials();
        login.submit();
    }
    @Test(priority = 1)
    public void AddTicketing()
    {
        AddTicketAction addTicket=new AddTicketAction(driver);

        addTicket.navigatetoAddTicket();
        addTicket.addTicket();
        addTicket.editTicket();
        addTicket.verifyNavigations();
    }
    @Test(priority = 2)
    public void TicketListing()
    {
        AddTicketAction addticket=new AddTicketAction(driver);
        TicketListingAction ticketlist=new TicketListingAction(driver);

        addticket.navigatetoAddTicket();
        ticketlist.validateTicketCount();
        ticketlist.verifyStausSort();
        ticketlist.verifyCreatedBySort();
        ticketlist.verifyUpdatePage();
    }
//    @Test(priority = 4)
//    public void UpdateTicket()
//    {
//        UpdateTicketAction updateTicket=new UpdateTicketAction(driver);
//        updateTicket.sendReply();
//        updateTicket.verifyandDownloadAttachment();
//        updateTicket.verifyTicketingPage();
//    }
//    @Test(priority = 5)
//    public void TicketGroup()
//    {
//        TicketGroupAction ticketGroup=new TicketGroupAction(driver);
//
//        ticketGroup.navigateToTicketGroup();
//        ticketGroup.addGroup1();
//        ticketGroup.verifyUsersGroup1();
//        ticketGroup.addGroup2();
//        ticketGroup.verifyUsersGroup2();
//    }
//    @Test(priority = 6)
//    public void ManagaeServiceBoard()
//    {
//        ManageServiceBoardAction manageserviceboar=new ManageServiceBoardAction(driver);
//
//       manageserviceboar.createTicketServiceBoard();
//        manageserviceboar.verifyLevelandGroupName();
//    }
//    @Test(priority = 7)
//    public void SLA()
//    {
//        SLAAction sla = new SLAAction(driver);
//
//        sla.createSLA();
//        sla.verifySLAinTheList();
//    }
}
