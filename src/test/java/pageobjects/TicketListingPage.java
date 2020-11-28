package pageobjects;

import javafx.scene.control.Pagination;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebBasePage;

import java.util.ArrayList;

public class TicketListingPage extends WebBasePage {
    WebDriver driver;
    int TotalCount;
    int RowCount;
    String status="Open";
    String openBy="Anthony";
    public TicketListingPage(WebDriver driver)
    {
        super(driver,"Manage Service Board");
        this.driver=driver;
    }
    public void countInPagination()
    {
        String text=getText(By.xpath("//div[contains(@class,'text-dark')]//label[2]"),10);
        String[] subtext=text.split("\\s");
        String temp=subtext[1];
        TotalCount=Integer.parseInt(temp);
    }
    public void rowCount()
    {
        //selectValueWithValue(By.cssSelector("select#pageSize"),"100","Page Limit",10);
        sleep(2000);
        RowCount=getRowCount(By.xpath("//table[@id='fixTable']//tbody//tr"),"Records");
        WebElement pagination = findElementVisibility(By.cssSelector("ul.pagination"),10);
        int tempCount=0;
        if(pagination!=null)
        {
            String element = driver.findElement(By.xpath("//a[contains(text(),'Next')]")).getAttribute("class");
            while (!element.contains("disabled")) {
                sleep(2000);
                click(By.xpath("//a[contains(text(),'Next')]"), "Next", 8);
                sleep(3000);
                tempCount=getRowCount(By.xpath("//table[@id='fixTable']//tbody//tr"),"Records");
                RowCount=RowCount+tempCount;
                element = driver.findElement(By.xpath("//a[contains(text(),'Next')]")).getAttribute("class");
            }
        }
    }
    public void verifyRecordCount()
    {
        if(TotalCount==RowCount)
        {
            System.out.println("Count in the Pagination "+TotalCount+" is matched with Row Count "+RowCount);
        }
        else
        {
            System.out.println("Count in the Pagination "+TotalCount+" is not matched with Row Count "+RowCount);
        }
    }
    public void selectRecordStatus()
    {
        String value=(status.equals("Open"))?"1111":(status.equals("Closed"))?"1110":(status.equals("Closed and Locked"))?"1113":(status.equals("On Hold"))?"12376":(status.equals("Reopen"))?"2075":(status.equals("Waiting"))?"1112":
                (status.equals("Waiting Resolved"))?"12364":(status.equals("Waiting Response"))?"12363":"";

        sleep(3000);

        clickByJavascript(By.xpath("//label[text()='Ticket Status:']//following::span[1]//button//span"),"Status Dropdown",10);
        clickByJavascript(By.xpath("//input[@value='"+value+"']"),"Check Option",10);
        //selectValueWithValue(By.cssSelector("select#statusId"),value,"Status",15);
    }
    public void clickSearchButton()
    {
        sleep(2000);
        click(By.cssSelector("a#Search"),"Search",10);
    }
    public void clickResetButton()
    {
        sleep(2000);
        click(By.cssSelector("#ResetFilters"),"Reset",10);
    }
    public void selectopenBy()
    {
        String value=(openBy.equals("Anthony"))?"64435":(openBy.equals("Matthew"))?"64436":(openBy.equals("Rodney"))?"64430":"";
        //selectValueWithValue(By.cssSelector("select#raisedById"),value,"Created By",10);
        clickByJavascript(By.xpath("//label[text()='Open By:']//following::span[1]//button//span"),"OpenBy Dropdown",10);
        clickByJavascript(By.xpath("//label[text()='Open By:']//following::input[@value='"+value+"'][1]"),"OpenBy Dropdown",10);
    }
    public void verifyStatus()
    {
        //selectValueWithValue(By.cssSelector("select#pageSize"),"100","Page Limit",10);
        sleep(3000);
        int count=getRowCount(By.xpath("//table[@id='fixTable']//tbody//tr"),"Records");
        ArrayList<String> array=new ArrayList<>();
        for(int i=1;i<=count;i++)
        {
            String status=getText(By.xpath("(//table[@id='fixTable']//tbody//tr//td[5])["+i+"]"),10);
            array.add(status);
            if(i==count)
            {
                countInPagination();
                //WebElement pagination = findElementVisibility(By.cssSelector("ul.pagination"),10);
                if(TotalCount>10) {
                    //WebElement element = findElementClickable(By.cssSelector("a[title='Next']"), 10);
                    sleep(2000);
                    String element = driver.findElement(By.cssSelector("a[title='Next']")).getAttribute("class");
                    if (!element.contains("disabled")) {
                        click(By.cssSelector("a[title='Next']"), "Next", 8);
                        i = 0;
                        sleep(3000);
                        countInPagination();
                        if (TotalCount != 0) {
                            count = getRowCount(By.xpath("//table[@id='fixTable']//tbody//tr"), "Records");
                            continue;
                        }else
                        {
                            System.out.print("List not displayed in the next page");
                            break;
                        }
                    }
                }
            }
        }
        if(array.contains("Draft"))
        {
            System.out.println("The Records are not sorted with Application Status");
        }
        else
        {
            System.out.println("The Records are sorted with Application Status");
        }
    }
    public void verifyCreatedBy()
    {
        int count=getRowCount(By.xpath("//table[@id='fixTable']//tbody//tr"),"Records");
        ArrayList<String> array=new ArrayList<>();
        for(int i=1;i<=count;i++)
        {
            String createdBy=getText(By.xpath("(//table[@id='fixTable']//tbody//tr//td[12]//span)["+i+"]"),10);
            array.add(createdBy);
            if(i==count)
            {
                countInPagination();
                //WebElement pagination = findElementVisibility(By.cssSelector("ul.pagination"),10);
                if(TotalCount>10) {
                    //WebElement element = findElementClickable(By.cssSelector("a[title='Next']"), 10);
                    sleep(2000);
                    String element = driver.findElement(By.cssSelector("a[title='Next']")).getAttribute("class");
                    if (!element.contains("disabled")) {
                        click(By.cssSelector("a[title='Next']"), "Next", 8);
                        i = 0;
                        sleep(3000);
                        countInPagination();
                        if (TotalCount != 0) {
                            count = getRowCount(By.xpath("//table[@id='fixTable']//tbody//tr"), "Records");
                            continue;
                        }else
                        {
                            System.out.print("List not displayed in the next page");
                            break;
                        }
                    }
                }
            }
        }
        if(array.contains("Draft"))
        {
            System.out.println("The Records are not sorted with created by field");
        }
        else
        {
            System.out.println("The Records are sorted with created by field");
        }
    }
    public void verifytheUpdateScreen()
    {
        click(By.xpath("(//a[@class='btnright'])[1]"),"More Option",15);
        click(By.xpath("(//a[@class='btnright']//following::a//span[text()='View'])[1]"),"View",15);
        String element=getText(By.cssSelector("a#abtnChangeTicketStatus"),15);
        if(element.contains("Update"))
        {
            System.out.println("Update Page is Displayed");
        }
        else
        {
            System.out.println("Update Page is not Displayed");
        }
    }
}
