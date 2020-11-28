package pageobjects;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebBasePage;

public class SLAPage extends WebBasePage{
    WebDriver driver;
    public SLAPage(WebDriver driver){
        super(driver,"Manage Service Board");
        this.driver=driver;
    }
    String groupName1="Group1";String groupName2="Group2";
    String policyName=NameGenerator();String PolicyDescription=" Policy Description 001";
    String ApplyON="On Create";String dropdown1="department";String dropdown2="Equal To";
    String dropdowb3="Sales";String endTime="10:00";String startTime="07:00";
    String StartAMPM="AM";String EndAMPM="PM";String StartDay="Monday";
    String EndDate="Friday";String Priority="High";String responseTime="40";String responseTimeType="Minute";
    String responseTimeApproach="10";String responseTimeApproachType="Minute";String resolveTime="3";
    String resolveTimeType="Hour";String resolveTimeApproach="1";String resolveTimeApproachType="Hour";
    String violationResponseTime="1";String violationResponseTimeType="Hour";
    String violationResolveTime="2";String violationResolveTimeType="Hour";String HODorCA="HOD";
    String notifyTo="Matthew";String boardName="Board Name-1";

    public void clickFullMenu()
    {
        click(By.cssSelector("a#navbarDropdownPortfolio"),"Full Menu",5);
    }
    public void clickTicketingOption()
    {
        click(By.cssSelector("a[data-original-title='Ticketing']>.parentcube>span"),"Ticketing",5);
    }
    public void clickSLAOption()
    {
        click(By.cssSelector("a[data-original-title='SLA']"),"CLA",5);
    }
    public void clickAddIcon()
    {
        click(By.cssSelector("#ancCreateFeedBack"),"Add New",10);
    }
    public void enterPolicyName()
    {
        enter(By.cssSelector("div.form-group>input#PolicyName"),policyName,"Policy Name",8);
    }
    public void selectPolicyDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String today=dtf.format(now);
        click(By.xpath("(//input[@id='txtPolicyDate']//following::span)[1]"),"Date",8);
        click(By.xpath("//td[@data-day='"+today+"']"),"Current Date",8);
    }
    public void enterDescription()
    {
        enter(By.cssSelector("textarea#PolicyDescription"),PolicyDescription,"Policy Description",5);
    }
    public void selectApplyOnSection()
    {
        String id=(ApplyON=="On Create")?"rdo_0":(ApplyON=="On Resolve")?"rdo_1":(ApplyON=="On Transfer")?"rdo_2":(ApplyON=="On Update")?"rdo_3":"";
        clickByJavascript(By.xpath("//label[@for='"+id+"']"),ApplyON,5);
    }
    public void clickAddTargetButton()
    {
        click(By.cssSelector("#litarger_0>p>a.addtarget_btn"),"Add Target",5);
    }
    public void selectOptionsFromDropdown()
    {
        selectValueWithText(By.cssSelector("#RuleTarget_0__FieldId"),dropdown1,"Dropdown Option1",8);
        selectValueWithText(By.cssSelector("#RuleTarget_0__OperatorId"),dropdown2,"Dropdown Option2",8);
        click(By.xpath("//ul[contains(@class,'backgroundEDEDED')]//button[@title='Select']"),"Dropdown 3",5);
        click(By.xpath("//ul[contains(@class,'backgroundEDEDED')]//label[contains(text(),'"+dropdowb3+"')]"),"Dropdown Option3",8);

    }
    public void clickSaveButton()
    {
        click(By.cssSelector("a#btnSaveTarget"),"Save",8);
    }
    public void clickAddResultButton()
    {
        click(By.cssSelector("#litargerresult_0>p>a"),"Add Target",8);
    }
    public void selectResultType()
    {
        selectValueWithText(By.cssSelector("select#ddlwarningMessageTypeId"),"Assign To","Result Type",10);
    }
    public void selectServiceBoard()
    {
        selectValueWithText(By.cssSelector("select#ddlResultChainIds"),boardName,"Service Board Name",8);
    }
    public void saveResult()
    {
        click(By.cssSelector("a#btnSaveTargetResult"),"Save",8);
    }

    public void setStartandEndTime() {
        click(By.cssSelector("div[data-target='#StartTime']>span"), "Start Time", 8);
        click(By.cssSelector(".timepicker-hour"), "Time", 8);
        String[] time1 = startTime.split(":");
        click(By.xpath("//td[text()='" + time1[0] + "']"), time1[0], 8);
        click(By.cssSelector(".timepicker-minute"), "Minute", 5);
        click(By.xpath("//td[text()='" + time1[1] + "']"), time1[1], 8);
        String ampm=getText(By.cssSelector(".btn-primary"),10);
        if(!ampm.equals(StartAMPM)) {
            click(By.cssSelector("button[title='Toggle Period']"), "Toggle Period", 5);
        }
        click(By.cssSelector("div[data-target='#StartTime']>span"), "Start Time", 8);

    }
    public void enterEndTime()
    {
        click(By.cssSelector("div[data-target='#EndTime']>span"), "End Time", 8);
        click(By.cssSelector(".timepicker-hour"), "Time", 8);
        String[] time2 = endTime.split(":");
        click(By.xpath("//td[text()='" + time2[0] + "']"), time2[0], 8);
        click(By.cssSelector(".timepicker-minute"), "Minute", 5);
        click(By.xpath("//td[text()='" + time2[1] + "']"), time2[1], 8);
        String ampm=getText(By.cssSelector(".btn-primary"),10);
        if(!ampm.equals(EndAMPM)){
            click(By.cssSelector("button[title='Toggle Period']"), "Toggle Period", 5);
        }
        click(By.cssSelector("div[data-target='#EndTime']>span"), "Start Time", 8);

    }
    public void selectDays()
    {
        //(//input[@name='SLAWeekdays']//following::label)[1]
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Monday", 1);
        map.put("Tuesday", 2);
        map.put("Wednesday", 3);
        map.put("Thursday", 4);
        map.put("Friday", 5);
        map.put("Saturday", 6);
        map.put("Sunday", 7);
        map.put("HoliyDay",8);

        int Day1=map.get(StartDay);
        int Day2=map.get(EndDate);

        for (int i=Day1;i<=Day2;i++)
        {
            click(By.xpath("(//input[@name='SLAWeekdays']//following::label)["+i+"]"),"WeekDays",8);
        }
    }
    String str="{\"training_modules\":[{\"training_module_id\":\"tester\",\"is_dynamically_assigned\":false}]}";
    public void fillTargets()
    {
        String id=(Priority.equals("High"))?"chk_20":(Priority.equals("Low"))?"chk_21":"";
        clickByJavascript(By.xpath("//input[@id='"+id+"']//following::label[1]"),"Priority",8);
        selectValueWithValue(By.cssSelector("#ListTarget_0__ResponseTime"),responseTime,"Response Time",8);
        selectValueWithValue(By.cssSelector("#ListTarget_0__ResponseTimeType"),responseTimeType,"Response Time Type",8);
        selectValueWithValue(By.cssSelector("#ListTarget_0__ResponseTimeApproach"),responseTimeApproach,"Response Time Approach",8);
        selectValueWithValue(By.cssSelector("#ListTarget_0__ResponseTimeApproachType"),responseTimeApproachType,"Response Time Approach Type",8);
        selectValueWithValue(By.cssSelector("#ListTarget_0__ResolveTime"),resolveTime,"Resolve Time",8);
        selectValueWithValue(By.cssSelector("#ListTarget_0__ResolveTimeType"),resolveTimeType,"Resolve Time Type",8);
        selectValueWithValue(By.cssSelector("#ListTarget_0__ResolveTimeApproach"),resolveTimeApproach,"Resolve Time Approach",8);
        selectValueWithValue(By.cssSelector("#ListTarget_0__ResolveTimeApproachType"),resolveTimeApproachType,"Resolve Time Approach",8);

    }
    public void fillViolationTimeReminder()
    {
        selectValueWithValue(By.cssSelector("select#ViolationResponseTime"),violationResponseTime,"Violation Response Time",8);
        selectValueWithValue(By.cssSelector("select#policySLAReminderResponse_TimeApproachesType"),violationResponseTimeType,"violation Resolve Time Type",8);
        selectValueWithValue(By.cssSelector("select#ViolationResolveTime"),violationResolveTime,"Violation Response Time",8);
        selectValueWithValue(By.cssSelector("select#policySLAReminderResolve_TimeApproachesType"),violationResolveTimeType,"violation Resolve Time Type",8);
        String staff=(HODorCA.toLowerCase().equals("hod"))?"HOD":(HODorCA.toLowerCase().equals("ca"))?"CA":"";
        clickByJavascript(By.cssSelector("input#policySLAReminderResponse_Is"+staff),"Response Notify To"+staff,8);
        String toID=(notifyTo.contains("Anthony"))?"64435":(notifyTo.contains("Matthew"))?"64436":(notifyTo.contains("Rodney"))?"64430":"";
        selectValueWithValue(By.cssSelector("select#ResponseAssignToIds"),toID,"Response Notify To",10);
        clickByJavascript(By.cssSelector("input#policySLAReminderResolve_Is"+staff),"Resolve Notify To"+staff,8);
        selectValueWithValue(By.cssSelector("select#ResolveAssignToIds"),toID,"Resolve Notify To",10);
    }
    public void saveSLA()
    {
        click(By.cssSelector(".search-btm-btn>a[data-original-title='Save']"),"Save",10);
    }
    public void verifyCreatedSLA()
    {
        ArrayList<String>list=new ArrayList<>();
        int SLACount=getRowCount(By.xpath("//table[contains(@class,'table-sorting')]//tbody//tr"),"SLA Row");
        for(int i=1;i<=SLACount;i++)
        {
            String ActualSLAName = getText(By.xpath("//table[contains(@class,'table-sorting')]//tbody//tr["+i+"]//td[2]//a"), 10);
            list.add(i-1,ActualSLAName);
        }
        if(list.contains(policyName))
        {
            System.out.println("Created SLA is displayed in the List");
        }
        else
        {
            System.out.println("Created SLA is not displayed in the List");
        }
    }
}
