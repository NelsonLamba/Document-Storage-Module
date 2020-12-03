package pageobjects;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import utils.WebBasePage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static reporting.ComplexReportFactory.getTest;

public class DeployProductPage extends WebBasePage {
    WebDriver driver;
    public static List<String>parentLocationNameList=new ArrayList<>();
    public static List<String>childLocationNameList=new ArrayList<>();
    public static String inputDate;
    public static String modelNameFromPopup;
    CompanySetupPage companySetup;
    public DeployProductPage(WebDriver driver)
    {
        super(driver,"");
        this.driver=driver;
        companySetup=new CompanySetupPage(driver);
    }

    public void clickFullMenuDropDown()
    {
        click(By.cssSelector("a#navbarDropdownPortfolio"),"Ful Menu",10);
    }
    public void clickAssetManagement()
    {
        click(By.cssSelector("#menuitem3 > a"),"Asset Management",10);
    }
    public void clickManageProduct()
    {
        click(By.xpath("(//ul[contains(@class,'submenu clschild')]//a[@id='cadmin_messageboard_link'])[2]"),"Manage Product",10);
    }
    public void navigateToDeployTab()
    {
        click(By.cssSelector("ul#myTab>li:nth-child(2)>a"),"Deploy Tab",10);
    }
    public void openProduct(String productName)
    {
        click(By.xpath("//table[@id='tablelistingdata']//tbody//tr//td[5]//a[contains(text(),'"+productName+"')]"),"Product",15);
    }
    public void verifyListingColumnHeader()
    {
        int i=0;
        List expecteListHeader=new ArrayList();
        expecteListHeader.add("Location");
        expecteListHeader.add("Model");
        expecteListHeader.add("Ref. PurchaseOrder");
        expecteListHeader.add("Order Date");
        expecteListHeader.add("Deployment Type");
        expecteListHeader.add("Deployed By");
        expecteListHeader.add("Deployed At");
        expecteListHeader.add("Quantity");
        expecteListHeader.add("Product Cost/Qty");


        List<WebElement> listHeader=findMultipleElement(By.xpath("//table[@id='deployItemsTable']//tr//th//span"),15);
        for (WebElement actual:listHeader) {
            List<String> expectedValues=expecteListHeader;
            for (Object expected:expectedValues ) {
                i++;
                String text2=actual.getText();
                String text1=expected.toString();
                if(actual.getText().equals(expected))
                {
                    getTest().log(LogStatus.PASS, "The \""+expected+"\" Header is displayed in the Deploy listing page");
                    logger.info("The \""+expected+"\" Header is displayed in the Deploy listing page");
                    i=0;
                    break;
                }
                else if(i==listHeader.size()&&!actual.getText().equals(expected))
                {
                    getTest().log(LogStatus.FAIL, "The \""+expected+"\" Header is not displayed in the Deploy listing page");
                    logger.info("The \""+expected+"\" Header is not displayed in the Deploy listing page");
                }
            }
        }
    }
    public void verifySearchBar()
    {
        WebElement searchBar=findElementVisibility(By.cssSelector("input#assetSearch"),15);
        if(searchBar!=null)
        {
            getTest().log(LogStatus.PASS, "\"Search Bar\" is displayed in the Deploy product page");
            logger.info("\"Search Bar\" is displayed in the Deploy product page");
        }
        else
            {
            getTest().log(LogStatus.FAIL, "\"Search Bar\" is not displayed in the Deploy product page");
            logger.info("\"Search Bar\" is not displayed in the Deploy product page");
        }
    }
    public void verifyDepolyProductAddButton()
    {
        WebElement addButton=findElementVisibility(By.cssSelector(".theme-primary>span>a>i"),15);
        if(addButton!=null)
        {
            getTest().log(LogStatus.PASS, "\"Deploy Product Add Button\" is displayed in the Deploy product page");
            logger.info("\"Deploy Product Add Button\" is displayed in the Deploy product page");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "\"Deploy Product Add Button\" is not displayed in the Deploy product page");
            logger.info("\"Deploy Product Add Button\" is not displayed in the Deploy product page");
        }
    }
    public void verifyNextButton()
    {
        WebElement nextButton=findElementVisibility(By.cssSelector("a#btnNext"),15);
        if(nextButton!=null)
        {
            getTest().log(LogStatus.PASS, "\"Next Button\" is displayed in the Deploy product page");
            logger.info("\"Next Button\" is displayed in the Deploy product page");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "\"Next Button\" is not displayed in the Deploy product page");
            logger.info("\"Next Button\" is not displayed in the Deploy product page");
        }
    }
    public void verifyPreviousButton()
    {
        WebElement nextButton=findElementVisibility(By.cssSelector("a#Previous"),15);
        if(nextButton!=null)
        {
            getTest().log(LogStatus.PASS, "\"Previous Button\" is displayed in the Deploy product page");
            logger.info("\"Previous Button\" is displayed in the Deploy product page");
        }
        else
        {
            getTest().log(LogStatus.PASS, "\"Previous Button\" is not displayed in the Deploy product page");
            logger.info("\"Previous Button\" is not displayed in the Deploy product page");
        }
    }
    public void enterInSearchField(String searchItem)
    {
        enter(By.cssSelector("input#assetSearch"),searchItem,"Search Field",15);
    }
    public void clickSearchButton()
    {
        click(By.cssSelector("a#aSearchAsset"),"Search Button",15);
        wairForLoader(20);
    }

    public void verifySearchedProduct(String searchItem)
    {
        List<WebElement> searchedProduct=findMultipleElement(By.cssSelector("table#deployItemsTable>tbody>tr>td>a"),20);
        for (WebElement locators:searchedProduct) {
            if(locators.getText().equals(searchItem))
            {
                getTest().log(LogStatus.PASS, "Searched location list is Displayed");
                logger.info("Searched location list is Displayed");
                break;
            }
            else
            {
                getTest().log(LogStatus.PASS, "Searched location list is not Displayed");
                logger.info("Searched location list is not Displayed");
            }
        }
    }
    public  void clickClearSearch()
    {
        findElementsVisibility(By.cssSelector("a#aUN_ClearSearch")).click();
    }
    public void verifyClearedSearch()
    {
        wairForLoader(30);
        String searchfield=getAtribute(By.cssSelector("input#assetSearch"),"value",15);
        if(searchfield.equals("")) {
            logger.info("Search field is cleared successfully");
            getTest().log(LogStatus.PASS, "Search field is cleared successfully");
        }
        else {
            logger.info("Search field is not cleared successfully");
            getTest().log(LogStatus.FAIL, "Search field is not cleared successfully");
        }

    }
    public void clickAddDeployButton()
    {
        //scrollToWebelement(By.cssSelector("a#ancDeployItems"),"Add Deploy");
       // click(By.cssSelector("a#ancDeployItems"),"Add Deploy",15);
        findElementVisibility(By.cssSelector("a#ancDeployItems"),15).click();
    }
    public void verifyAddDeployProductPage()
    {
        WebElement addToListButton=findElementVisibility(By.cssSelector("a#btn_AddRow"),15);
        if(addToListButton!=null) {
            getTest().log(LogStatus.PASS, "The \"Add Deploy Product\" page is displayed");
            logger.info("The \"Add Deploy Product\" page is displayed");
        }
        else {
            getTest().log(LogStatus.PASS, "The \"Add Deploy Product\" page is displayed");
            logger.info("The \"Add Deploy Product\" page is displayed");
        }
    }
    public void clickNextButton()
    {
        click(By.cssSelector("a#btnNext"),"Next Button",15);
    }
    public void verifyNextPage()
    {
        //waitForLoad(20);
        waitForVisibilityOfElement(By.xpath("//div[@class='theme-primary partition-full']//span[text()='Related Information']"),20);
        WebElement relatedInformationHeader=findElementVisibility(By.xpath("//div[@class='theme-primary partition-full']//span[text()='Related Information']"),15);
        if(relatedInformationHeader!=null) {
            getTest().log(LogStatus.PASS, "\"Related Information page\" is displayed when click Next button in \"Deploy Product page\"");
            logger.info("\"Related Information page\" is displayed when click Next button in \"Deploy Product page\"");
        }
        else {
            getTest().log(LogStatus.FAIL, "\"Related Information page\" is not displayed when click Next button in \"Deploy Product page\"");
            logger.info("\"Related Information page\" is not displayed when click Next button in \"Deploy Product page\"");
        }
    }
    public void clickPreviousButton()
    {
        click(By.cssSelector("a#Previous"),"Previous Button",15);
    }
    public void verifyPreviousPage()
    {
        scrollToWebelement(By.xpath("//div[@class='theme-primary partition-full']//span[text()='Deploy Product']"),"Deploy Product");
        WebElement relatedInformationHeader=findElementVisibility(By.xpath("//div[@class='theme-primary partition-full']//span[text()='Deploy Product']"),15);
        if(relatedInformationHeader!=null) {
            getTest().log(LogStatus.PASS, "\"Deploy Product page\" is displayed when click previous button in \"Related Information page\"");
            logger.info("\"Deploy Product page\" is displayed when click previous button in \"Related Information page\"");
        }
        else {
            getTest().log(LogStatus.FAIL, "\"Deploy Product page\" is not displayed when click previous button in \"Related Information page\"");
            logger.info("\"Deploy Product page\" is not displayed when click previous button in \"Related Information page\"");
        }
    }
    public void selectLocationValueFromDropdown()
    {
        findElementsVisibilityByClick(By.xpath("//ul[@id='CompantLocationSelect']//li[@class='parentli']//a"));
    }
    public void verifySelectedLocation(String expectedLocation)
    {
        String actualSelectedLocation=getText(By.cssSelector("div#divmultilevelselectLocation>div>div>span.CompantLocationSelectselected"),15);
        if(actualSelectedLocation.equals(expectedLocation))
        {
            getTest().log(LogStatus.PASS, "User can able to select the location from dropdown and it is selected");
            logger.info("User can able to select the location from dropdown and it is selected");
        }else
        {
            getTest().log(LogStatus.FAIL, "Selected Location is not displayed in the dropdown field");
            logger.info("Selected Location is not displayed in the dropdown field");
        }
    }
    public void enterQuantity(String quantity)
    {
        enter(By.cssSelector("div>input#Quantity"),quantity,"Quantity",15);
    }
    public void enterUnitPrice(String unitPrice)
    {
        enter(By.cssSelector("div>input#UnitPrice"),unitPrice,"Unit Price",15);
    }
    public void enterModel(String model)
    {
        enter(By.cssSelector("div>input#Model"),model,"Model",15);
        getModelNameFromPopup();
    }
    public void enterManufacturer(String manufacturer)
    {
        enter(By.cssSelector("div>input#Manufacturer"),manufacturer,"Manufacturer",15);
    }
    public void enterVendor(String vendor)
    {
        enter(By.cssSelector("div>input#Vendor"),vendor,"Vendor",15);
    }
    public void enterProductCost(String cost)
    {
        enter(By.cssSelector("div>input#AssetCost"),cost,"AssetCost",15);
    }
    public void enterPurchaseOrder(String purchaseOrder)
    {
        enter(By.cssSelector("div>input#PurchaseOrder"),purchaseOrder,"PurchaseOrder",15);
    }
    public void enterInvoiceNumber(String invoiceNumber)
    {
        enter(By.cssSelector("div>input#InvoiceNumber"),invoiceNumber,"Invoice Number",15);
    }
    public void selectInvoiceDate(String invoiceDate)
    {
        enter(By.cssSelector("div>input#InvoiceDate"),invoiceDate,"Invoice Date",15);
    }
    public void enterInsuranceNumber(String insuranceNumber)
    {
        enter(By.cssSelector("div>input#InsuranceRefNumber"),insuranceNumber,"Insurance Reference Number",15);
    }
    public void enterInsurarName(String insurarName)
    {
        enter(By.cssSelector("div>input#InsurerName"),insurarName,"InsurerName",15);
    }
    public void enterInsuranceValidity(String insuranceValidity)
    {
        enter(By.cssSelector("div>input#txtInsuranceToDate"),insuranceValidity,"Insurance Validity",15);
    }
    public void enterWarrantyDuration(String warrantyDuration)
    {
        enter(By.cssSelector("div>input#txtWarrantyDuration"),warrantyDuration,"Warranty Duration",15);
    }
    public void selectDepreciationRule(int index)
    {
        selectValueWithIndex(By.cssSelector("div>select#depreciationId"),index,"Depreciation Rule",15);
    }
    public void enterProductLife(String year)
    {
        enter(By.cssSelector("div>input#ItemLife"),year,"Product Life",15);
    }
    public void enterSalvageCost(String salvageCost)
    {
        enter(By.cssSelector("div>input#SalvageCost"),salvageCost,"Salvage Cost",15);
    }
    public void clickAddListButton()
    {
        click(By.cssSelector("div>a#btn_AddRow"),"Add to List",15);
    }
    public void getModelNameFromPopup()
    {
        modelNameFromPopup=findElementVisibility(By.cssSelector("div>input#Model"),15).getAttribute("value");
    }
    public void clickSaveButton()
    {
        click(By.cssSelector("a#saveBtnn"),"Save",15);
    }
    public void handleSuccessPopup()
    {
        waitForVisibilityOfElement(By.cssSelector("div.alert-success"),20);
        click(By.cssSelector("#closenotifymessage"),"Close Popup",15);
    }
    public void verifyCreatedDeployProduct()
    {
        waitForLoad(20);
        List<WebElement> deployedProductlist=findMultipleElement(By.xpath("//table[@id='deployItemsTable']//tbody//tr//td[2]//span"),15);
        for (WebElement element:deployedProductlist) {
            if(element.getText().equals(modelNameFromPopup))
            {
                getTest().log(LogStatus.PASS, "Created \"Deploy Product\" is displayed in the list");
                logger.info("Created \"Deploy Product\" is displayed in the list");
                break;
            }
            else
            {
                getTest().log(LogStatus.FAIL, "Created \"Deploy Product\" is not displayed in the list");
                logger.info("Created \"Deploy Product\" is not displayed in the list");
            }
        }
    }
    public void changeRecordsPerPage(String count)
    {
        selectValueWithValue(By.cssSelector("pageSize"),count,"Page Size",15);
    }
    public void verifyRecordsPerPage(int count)
    {
        int recordCount=findMultipleElement(By.cssSelector("//table[@id='deployItemsTable']//tbody//tr"),15).size();
        if(recordCount<=count)
        {
            getTest().log(LogStatus.PASS, "Records are displayed according to the selected page size");
            logger.info("Records are displayed according to the selected page size");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Records are not displayed according to the selected page size");
            logger.info("Records are not displayed according to the selected page size");
        }
    }
    public void verifyBreadCrumb()
    {
        WebElement breadCrumb=findElementVisibility(By.cssSelector(".breadcrumb"),15);
        if(breadCrumb!=null)
        {
            getTest().log(LogStatus.PASS, "BreadCrumb is displayed in the Deploy Product listing page");
            logger.info("BreadCrumb is displayed in the Deploy Product listing page");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "BreadCrumb is not displayed in the Deploy Product listing page");
            logger.info("BreadCrumb is not displayed in the Deploy Product listing page");
        }
    }
    public void navigateToProductEditMode()
    {
        click(By.xpath("//table[@id='deployItemsTable']//tbody//tr[1]//td//a"),"Location Name",15);
    }
    public void verifyEditMode()
    {
        String locationDisabled=getAtribute(By.cssSelector("#LocationName"),"disabled",15);
        String saveButton=getAtribute(By.cssSelector("a#saveBtnn"),"class",15);
        if(locationDisabled.equals("true") && saveButton.equals("btn btn-success"))
        {
            getTest().log(LogStatus.PASS, "Deploy Product popup is displayed in edit mode");
            logger.info("Deploy Product popup is displayed in edit mode");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Deploy Product popup is not displayed in edit mode");
            logger.info("Deploy Product popup is not displayed in edit mode");
        }
    }
    public void clearUnitPriceField()
    {
        enter(By.cssSelector("div>input#UnitPrice"),"","Unit Price",15);
    }
    public void verifymandatoryFieldValidation() {
        int i = 0;
        List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"), 15);
        String []expectedValue = {"Location","Quantity","Product Cost/Qty","Unit Price"};
        for (Object expected : expectedValue) {
            WebElement asteriskField=findElementVisibility(By.xpath("//label[text()='"+expected+":']//span"),15);
            if(asteriskField!=null)
            {
                getTest().log(LogStatus.PASS, "The Asterisk symbol is displayed for "+expected+" field");
                logger.info("The Asterisk symbol is displayed for "+expected+" field");
            }
            else {
                getTest().log(LogStatus.FAIL, "The Asterisk symbol is not displayed for "+expected+" field");
                logger.info("The Asterisk symbol is not displayed for "+expected+" field");
            }
            List<WebElement> expectedElements=errorMessageLocator;
            for (WebElement element : expectedElements) {
                i++;
                String actualText = element.getText();
                String expectedText = expected.toString();
                if (actualText.indexOf(expectedText)!=-1) {
                    getTest().log(LogStatus.PASS, "Error message for \""+expected+"\" field is displayed as expected");
                    logger.info("Error message for \""+expected+"\" field is displayed as expected");
                    i=0;
                    break;
                } else if (i == expectedValue.length && !element.getText().contains(expectedText)) {
                    getTest().log(LogStatus.FAIL, "Error message for \""+expected+"\" field is not displayed");
                    logger.info("Error message for \""+expected+"\" field is displayed as expected");
                }
            }
        }
    }
    public void clickLocationDropdown()
    {
        click(By.cssSelector("div#divmultilevelselectLocation>div>div"),"Location Dropdown",15);
    }
    public void verifyLocationDropdown()
    {
        WebElement locationDropdown=findElementVisibility(By.cssSelector("#CompantLocationSelect>li>ol"),15);
        if(locationDropdown!=null)
        {
            getTest().log(LogStatus.PASS, "Location Dropdown values are displayed as expected");
            logger.info("Location Dropdown values are displayed as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Location Dropdown values are not displayed as expected");
            logger.info("Location Dropdown values are not displayed as expected");
        }
    }
    public void verifySearchFieldinLocationDropdown()
    {
        WebElement searchField=findElementVisibility(By.cssSelector("#CompantLocationSelect>li.mainelevel"),15);
        if(searchField!=null)
        {
            getTest().log(LogStatus.PASS, "Search field is displayed in the Location dropdown");
            logger.info("Search field is displayed in the Location dropdown");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Search field is not displayed in the Location dropdown");
            logger.info("Search field is not displayed in the Location dropdown");
        }
    }
    public void enterInLocationSearch(String searchLocation)
    {
        enter(By.cssSelector("#CompantLocationSelect>li.mainelevel>input"),searchLocation,"Location Search",15);
    }
    public void verifyLocationSearch(String searchLocation)
    {
        WebElement searchResult=findElementVisibility(By.xpath("//li//a//span[text()='"+searchLocation+"']"),15);
        if(searchResult!=null)
        {
            getTest().log(LogStatus.PASS, "Search result for location is displayed as expected");
            logger.info("Search result for location is displayed as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Search result for location is not displayed as expected");
            logger.info("Search result for location is not displayed as expected");
        }
    }
    public void navigateToCompanySetup()
    {
        click(By.cssSelector("[data-name='COMPANY']>a"),"Company Setup",15);
    }
    public void navigateToLocationSetup()
    {
        click(By.cssSelector("[data-original-title='Location']"),"Location Setup",15);
    }
    public void make100PageSize()
    {
        selectValueWithValue(By.cssSelector("select#pageSize"),"100","Page Size",15);
        wairForLoader(20);
    }
    public void getLocationsFromSetup()
    {
        waitForVisibilityOfElement(By.xpath("//a[@id='ancEditLocation']"),15);
        List<WebElement> locationList=findMultipleElement(By.xpath("//a[@id='ancEditLocation']"),15);
        int i=0;
        for (WebElement element:locationList)
        {
            i++;
            waitForVisibilityOfElement(By.xpath("(//a[@id='ancEditLocation'])[\"+i+\"]//parent::div//parent::div//parent::li//parent::ul"),15);
            String attributeName=getAtribute(By.xpath("(//a[@id='ancEditLocation'])["+i+"]//parent::div//parent::div//parent::li//parent::ul"),"class",15);
            if(!attributeName.equals("parentbasemaster")) {
                parentLocationNameList.add(element.getText());
            }else {
                childLocationNameList.add(element.getText());
            }
        }
    }
    public void verifyLocations(String locationType)
    {
        int i=0;
        String locator=(locationType.equals("parent"))?".scrollbar>li>a>span":"ul.child>li>a>div";
        waitForVisibilityOfElement(By.cssSelector(locator),20);
        List<WebElement> locations=findMultipleElement(By.cssSelector(locator),15);
        for (WebElement actualElement:locations)
        {
            List<String>expectedLocationNames=(locationType.equals("parent"))?parentLocationNameList:childLocationNameList;
            for (Object expectedElement:expectedLocationNames)
            {
                i++;
                String text1=actualElement.getText();
                String text2=expectedElement.toString();
             if(actualElement.getText().equals(expectedElement))
             {
                 getTest().log(LogStatus.PASS, "Expected "+locationType+" location \""+expectedElement+"\" location is present in both setup and location dropdown");
                 logger.info("Expected "+locationType+" location \""+expectedElement+"\" location is present in both setup and location dropdown");
                 i=0;
                 break;
             }
             else if(i==parentLocationNameList.size()&&!actualElement.getText().equals(expectedElement))
             {
                 getTest().log(LogStatus.FAIL, "Expected "+locationType+" location \""+expectedElement+"\" location is not present in location dropdown");
                 logger.info("Expected "+locationType+" location \""+expectedElement+"\" location is not present in location dropdown");
             }
            }
        }
    }
    public void createChildLocation(String locationName,String addressOne,String city,String country)
    {
        companySetup.clickAddLocationButton();
        companySetup.selectParentLocation();
        companySetup.enterLocationName(locationName);
        companySetup.enterAddreesLine1(addressOne);
        companySetup.enterCity(city);
        companySetup.selectCountry(country);
        companySetup.saveLocation();
        handleSuccessPopup();
    }
    public void clearLocationSelection()
    {
        click(By.cssSelector("div#divmultilevelselectLocation>div>div>span>i[title='Clear']"),"Clear Location",15);
    }
    public void verifyClearedLocation()
    {
        String actualVaue=findElementVisibility(By.cssSelector("[class='CompantLocationSelectselected float-left']"),15).getText();
        if(actualVaue.equals("Select"))
        {
            getTest().log(LogStatus.PASS, "Selected dropdown value is cleared as expected");
            logger.info("Selected dropdown value is cleared as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Selected dropdown value is cleared as expected");
            logger.info("Selected dropdown value is cleared as expected");
        }
    }
    public void verifyQuantityMinimumChar()
    {
        enterQuantity("5");
        clickAddListButton();
        WebElement errorMessage=findElementVisibility(By.xpath("//input[@id='Quantity']//parent::div//span[@class='invalid-feedback']"),20);
        if(errorMessage==null)
        {
            getTest().log(LogStatus.PASS, "Quantity field is accepts minimum of one character");
            logger.info("Quantity field is accepts minimum of one character");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Quantity field is not accepts minimum of one character");
            logger.info("Quantity field is not accepts minimum of one character");
        }
    }
    public void verifyQuantityCharandSpclChar()
    {
        enterQuantity("Abc!@#");
        String actualText=findElementVisibility(By.cssSelector("div>input#Quantity"),15).getText();
        if(actualText.equals(""))
        {
            getTest().log(LogStatus.PASS, "Quantity field is not accepts character and special characters as expected");
            logger.info("Quantity field is not accepts character and special characters as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Quantity field is accepts character and special characters as "+actualText);
            logger.info("Quantity field is accepts character and special characters as "+actualText);
        }
    }
    public void verifyQuantityMaxChar()
    {
        enterQuantity("805665");
        String actualText=findElementVisibility(By.cssSelector("div>input#Quantity"),15).getAttribute("value");
        if(actualText.equals("80566"))
        {
            getTest().log(LogStatus.PASS, "Quantity field is not accepts more than 5 characters as expected");
            logger.info("Quantity field is not accepts more than 5 characters as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Quantity field is accepts more than 5 characters as "+actualText);
            logger.info("Quantity field is accepts more than 5 characters as "+actualText);
        }
    }
    public void verifyModelFieldValidation(String modelName)
    {
        enterModel(modelName);
        String actualText=findElementVisibility(By.cssSelector("div>input#Model"),15).getAttribute("value");
        if(modelName.equals(actualText))
        {
            getTest().log(LogStatus.PASS, "Model Name field is accept the data as expected");
            logger.info("Model Name field is accept the data as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Model Name field is not working as expected. It accept the Value \""+modelName+"\"");
            logger.info("Model Naem field is not working as expected. It accept the Value \""+modelName+"\"");
        }
    }
    public void verifyManufacturerFieldValidation(String manufacturerName)
    {
        enterManufacturer(manufacturerName);
        String actualText=findElementVisibility(By.cssSelector("div>input#Manufacturer"),15).getAttribute("value");
        if(manufacturerName.equals(actualText))
        {
            getTest().log(LogStatus.PASS, "Manufaturer Name field is accept the data as expected");
            logger.info("Manufaturer Name field is accept the data as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Manufaturer Name field is not working as expected. It accept the Value \""+manufacturerName+"\"");
            logger.info("Manufaturer Naem field is not working as expected. It accept the Value \""+manufacturerName+"\"");
        }
    }
    public void verifyVendorFieldValidation(String vendorName)
    {
        enterManufacturer(vendorName);
        String actualText=findElementVisibility(By.cssSelector("div>input#Model"),15).getAttribute("value");
        if(vendorName.equals(actualText))
        {
            getTest().log(LogStatus.PASS, "Vendor Name field is accept the data as expected");
            logger.info("Vendor Name field is accept the data as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Vendor Name field is not working as expected. It accept the Value \""+vendorName+"\"");
            logger.info("Vendor Naem field is not working as expected. It accept the Value \""+vendorName+"\"");
        }
    }
    public void verifyProductCostFieldBehaviour(String condition)
    {
        boolean productCostField=findElementVisibility(By.cssSelector("div>input#AssetCost"),15).isEnabled();
        if(condition.equals("enable")) {
            if (productCostField) {
                getTest().log(LogStatus.PASS, "Product Cost field is enabled when Product Cost toggle is set as \"Yes\" in the company setup page");
                logger.info("Product Cost field is enabled when Product Cost toggle is set as \"Yes\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Product Cost field is diabled when Product Cost toggle is set as \"Yes\" in the company setup page");
                logger.info("Product Cost field is enabled when Product Cost toggle is set as \"Yes\" in the company setup page");
            }
        }
        else if(condition.equals("disable"))
        {
            if (!productCostField) {
                getTest().log(LogStatus.PASS, "Product Cost field is disabled when Product Cost toggle is set as \"No\" in the company setup page");
                logger.info("Product Cost field is disabled when product type is set as \"No\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Product Cost field is enabled when Product Cost toggle is set as \"No\" in the company setup page");
                logger.info("Product Cost field is enabled when Product Cost toggle is set as \"No\" in the company setup page");
            }
        }
    }
    public void verifyInsuranceRefNumFieldBehaviour(String condition)
    {
        boolean insuranceRefNumField=findElementVisibility(By.cssSelector("div>input#InsuranceRefNumber"),15).isEnabled();
        if(condition.equals("enable")) {
            if (insuranceRefNumField) {
                getTest().log(LogStatus.PASS, "Insurance Reference Number field is enabled when Insurance Policy toggle is set as \"Yes\" in the company setup page");
                logger.info("Insurance Reference Number field is enabled when Insurance Policy toggle is set as \"Yes\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Insurance Reference Number field is diabled when Insurance Policy toggle is set as \"Yes\" in the company setup page");
                logger.info("Insurance Reference Number is enabled when Insurance Policy toggle is set as \"Yes\" in the company setup page");
            }
        }
        else if(condition.equals("disable"))
        {
            if (!insuranceRefNumField) {
                getTest().log(LogStatus.PASS, "Insurance Reference Number field is disabled when product type is set as \"No\" in the company setup page");
                logger.info("Insurance Reference Number field is disabled when product type is set as \"No\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Insurance Reference Number field is enabled when Insurance Policy toggle is set as \"No\" in the company setup page");
                logger.info("Insurance Reference Number field is enabled when Insurance Policy toggle is set as \"No\" in the company setup page");
            }
        }
    }
    public void verifyInsuranceDateFieldBehaviour(String condition)
    {
        boolean insuranceDateField=findElementVisibility(By.cssSelector("div>input#txtInsuranceToDate"),15).isEnabled();
        if(condition.equals("enable")) {
            if (insuranceDateField) {
                getTest().log(LogStatus.PASS, "Insurance Date field is enabled when Insurance Policy toggle is set as \"Yes\" in the company setup page");
                logger.info("Insurance Date field is enabled when Insurance Policy toggle is set as \"Yes\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Insurance Date field is diabled when Insurance Policy toggle is set as \"Yes\" in the company setup page");
                logger.info("Insurance Date is enabled when Insurance Policy toggle is set as \"Yes\" in the company setup page");
            }
        }
        else if(condition.equals("disable"))
        {
            if (!insuranceDateField) {
                getTest().log(LogStatus.PASS, "Insurance Date field is disabled when product type is set as \"No\" in the company setup page");
                logger.info("Insurance Reference Number field is disabled when product type is set as \"No\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Insurance Date field is enabled when Insurance Policy toggle is set as \"No\" in the company setup page");
                logger.info("Insurance Date field is enabled when Insurance Policy toggle is set as \"No\" in the company setup page");
            }
        }
    }
    public void verifyInsurerNameFieldBehaviour(String condition)
    {
        boolean insurerNameField=findElementVisibility(By.cssSelector("div>input#InsurerName"),15).isEnabled();
        if(condition.equals("enable")) {
            if (insurerNameField) {
                getTest().log(LogStatus.PASS, "Insurer Name field is enabled when Insurance Policy toggle is set as \"Yes\" in the company setup page");
                logger.info("Insurer Name field is enabled when Insurance Policy toggle is set as \"Yes\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Insurer Name field is diabled when Insurance Policy toggle is set as \"Yes\" in the company setup page");
                logger.info("Insurer Name is enabled when Insurance Policy toggle is set as \"Yes\" in the company setup page");
            }
        }
        else if(condition.equals("disable"))
        {
            if (!insurerNameField) {
                getTest().log(LogStatus.PASS, "Insurer Name field is disabled when product type is set as \"No\" in the company setup page");
                logger.info("Insurer Name field is disabled when product type is set as \"No\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Insurer Name field is enabled when Insurance Policy toggle is set as \"No\" in the company setup page");
                logger.info("Insurer Name field is enabled when Insurance Policy toggle is set as \"No\" in the company setup page");
            }
        }
    }
    public void productCostNumbersOnly()
    {
        String productCost="123456";
        enterProductCost(productCost);
        String actualText=findElementVisibility(By.cssSelector("div>input#AssetCost"),15).getAttribute("value");
        if(actualText.equals(productCost))
        {
            getTest().log(LogStatus.PASS, "Product Cost field accepts the data with only numbers as expected");
            logger.info("Product Cost field accepts the data with only numbers as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Product Cost field is not working as expected. It accept the Value \""+productCost+"\"");
            logger.info("Product Cost field is not working as expected. It accept the Value \""+productCost+"\"");
        }
    }
    public void productCostCharandSpclChar()
    {
        String productCost="Ab@#";
        enterProductCost(productCost);
        String actualText=findElementVisibility(By.cssSelector("div>input#AssetCost"),15).getAttribute("value");
        if(actualText.equals(""))
        {
            getTest().log(LogStatus.PASS, "Product Cost field does not accept the data with character and special character as expected");
            logger.info("Product Cost field does not accept the data with character and special character as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Product Cost field accepts the data with character and special character as expected");
            logger.info("Product Cost field accepts the data with character and special character as expected");
        }
    }
    public void productCostMinimum()
    {
        String productCost="1";
        enterProductCost(productCost);
        clickAddListButton();
        WebElement errorMessageElement=findElementVisibility(By.xpath("//input[@id='AssetCost']//parent::div//span[@class='valid-feedback invalid-feedback']"),15);
        if(errorMessageElement==null)
        {
            getTest().log(LogStatus.PASS, "Product Cost field accepts the data with minimum of one digit as expected");
            logger.info("Product Cost field accepts the data with minimum of one digit as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Product Cost field displays error message when enter data with minimum of one digit as expected. Error message is "+errorMessageElement.getText());
            logger.info("Product Cost field displays error message when enter data with minimum of one digit as expected Error message is "+errorMessageElement.getText());
        }
    }
    public void productCostMaximum()
    {
        String productCost="1234567890";
        enterProductCost(productCost);
        String actualText=findElementVisibility(By.cssSelector("div>input#AssetCost"),15).getAttribute("value");
        if(actualText.equals(productCost))
        {
            getTest().log(LogStatus.PASS, "Product Cost field accepts the data with maximum of 10 digit as expected");
            logger.info("Product Cost field accepts the data with maximum of 10 digit as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Product Cost field does not accepts the data with maximum of 10 digit as expected");
            logger.info("Product Cost field does not accepts the data with maximum of 10 digit as expected");
        }
    }
    public void productCostMoreThanMaximum()
    {
        String productCost="1234567890123";
        enterProductCost(productCost);
        String actualText=findElementVisibility(By.cssSelector("div>input#AssetCost"),15).getAttribute("value");
        if(!actualText.equals(productCost))
            {
            getTest().log(LogStatus.PASS, "Product Cost field does not accepts the data with more than 10 digit as expected. Entered Data : "+productCost);
            logger.info("Product Cost field does not accepts the data with more than 10 digit as expected. Entered Data : "+productCost);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Product Cost field accepts the data with more than 10 digits. Entered Data : "+productCost);
            logger.info("Product Cost field accepts the data with more than 10 digits. Entered Data : "+productCost);
        }
    }
    public void verifyReferenceNumberFieldPesence()
    {
        WebElement refPurchaseOrder=findElementVisibility(By.cssSelector("div>input#PurchaseOrder"),15);
        if(refPurchaseOrder!=null)
        {
            getTest().log(LogStatus.PASS, "The logged in user have option to mention the \"Reference Purchase Order Number\"");
            logger.info("The logged in user have option to mention the \"Reference Purchase Order Number\"");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "The logged in user doest not have option to mention the \"Reference Purchase Order Number\"");
            logger.info("The logged in user does not have option to mention the \"Reference Purchase Order Number\"");
        }
    }
    public void verifyRefernceNumberAlphaNumeric()
    {
        String refPurchaseOrder="Abc123";
        enterPurchaseOrder(refPurchaseOrder);
        String actualText=findElementVisibility(By.cssSelector("div>input#PurchaseOrder"),15).getAttribute("value");
        if(actualText.equals(refPurchaseOrder))
        {
            getTest().log(LogStatus.PASS, "Reference PurchaseOrder field is accept the data with alpha numeric characters as expected. Entered Data : "+refPurchaseOrder);
            logger.info("Reference PurchaseOrder field is accept the data with alpha numeric characters as expected. Entered Data : "+refPurchaseOrder);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Reference PurchaseOrder field is not working as expected. It accept the Value \""+refPurchaseOrder+"\"");
            logger.info("Reference PurchaseOrder field is not working as expected. It accept the Value \""+refPurchaseOrder+"\"");
        }
    }
    public void verifyRefernceNumberSpclChar()
    {
        String refPurchaseOrder="!@#$";
        enterPurchaseOrder(refPurchaseOrder);
        String actualText=findElementVisibility(By.cssSelector("div>input#PurchaseOrder"),15).getAttribute("value");
        if(actualText.equals(refPurchaseOrder))
        {
            getTest().log(LogStatus.PASS, "Reference PurchaseOrder field is accept the data with special characters as expected. Entered Data : "+refPurchaseOrder);
            logger.info("Reference PurchaseOrder field is accept the data with special characters as expected. Entered Data : "+refPurchaseOrder);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Reference PurchaseOrder field is not working as expected. It accept the Value \""+refPurchaseOrder+"\"");
            logger.info("Reference PurchaseOrder field is not working as expected. It accept the Value \""+refPurchaseOrder+"\"");
        }
    }
    public String selectDate(String date)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MMM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate=dtf.format(now);
        inputDate=(date.equals("Old"))?dtf.format(now.minusDays(1)):(date.equals("Future"))?dtf.format(now.plusDays(1)):dtf.format(now);
        String[]inputDateArray=inputDate.split("/");
        String day=inputDateArray[0];
        String month=inputDateArray[1];
        String year=inputDateArray[2];
        click(By.cssSelector(".picker-switch"),"Mont&Year popup",15);
        click(By.cssSelector("[title='Select Year']"),"Year popup",15);
        click(By.xpath("//span[contains(@class,'year') and text()='"+year+"']"),"Year Value",15);
        click(By.xpath("//span[contains(@class,'month') and text()='"+month+"']"),"Month Value",15);
        String dayClass=findElementVisibility(By.xpath("//td[contains(@class,'day') and text()='"+day+"']"),15).getAttribute("class");
        if(!dayClass.contains("disabled")) {
            findElementClickable(By.xpath("//td[contains(@class,'day') and text()='" + day + "']"), 15).click();
        }
        return dayClass;
    }
    public void verifyWithOldDate(String field)
    {
        selectDate("Old");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDateTime previousDay = LocalDateTime.now().minusDays(1);
        String expectedDate=dtf.format(previousDay);
        String locator=(field.equals("Product"))?"txtOrderDate":(field.equals("Invoice"))?"InvoiceDate":(field.equals("Insurance"))?"txtInsuranceToDate":(field.equals("Warranty"))?"txtWarrantyDuration":"";
        String actualText=findElementVisibility(By.cssSelector("input#"+locator),15).getAttribute("value");
        if(actualText.equals(expectedDate))
        {
            getTest().log(LogStatus.PASS, "Old Date was selected as expected");
            logger.info("Old Date was selected as expected");
        }else
        {
            getTest().log(LogStatus.FAIL, "Not able to select Old date");
            logger.info("Not able to select Old date");
        }
    }
    public void verifyNotClickablePastDate()
    {
        String dayClass=selectDate("Old");
        if(dayClass.contains("disabled"))
        {
            getTest().log(LogStatus.PASS, "Not able to select Future Date as expected");
            logger.info("Not able to select Future Date as expected");
        }else
        {
            getTest().log(LogStatus.FAIL, "Future date can be selected");
            logger.info("Future date can be selected");
        }
    }
    public void verifyNotClickableFutureDate()
    {
        String dayClass=selectDate("Future");
        if(dayClass.contains("disabled"))
        {
            getTest().log(LogStatus.PASS, "Not able to select Future Date as expected");
            logger.info("Not able to select Future Date as expected");
        }else
        {
            getTest().log(LogStatus.FAIL, "Future date can be selected");
            logger.info("Future date can be selected");
        }
    }
    public void verifyClickableFutureDate(String field)
    {
        selectDate("Future");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDateTime futureDay = LocalDateTime.now().plusDays(1);
        String expectedDate=dtf.format(futureDay);
        String locator=(field.equals("Order"))?"txtOrderDate":(field.equals("Invoice"))?"InvoiceDate":(field.equals("Insurance"))?"txtInsuranceToDate":(field.equals("Warranty"))?"txtWarrantyDuration":"";
        String actualText=findElementVisibility(By.cssSelector("input#"+locator),15).getAttribute("value");
        if(actualText.equals(expectedDate))
        {
            getTest().log(LogStatus.PASS, "Future Date is selected for "+field+" date field");
            logger.info("Future Date is selected for "+field+" date field");
        }else
        {
            getTest().log(LogStatus.FAIL, "Not able to select future date for "+field+" date field");
            logger.info("Not able to select future date for "+field+" date field");
        }
    }
    public void verifyWithCurrentDate(String field)
    {
        selectDate("Curent");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate=dtf.format(now);
        String locator=(field.equals("Order"))?"txtOrderDate":(field.equals("Invoice"))?"InvoiceDate":(field.equals("Insurance"))?"txtInsuranceToDate":(field.equals("Warranty"))?"txtWarrantyDuration":"";
        String actualText=findElementVisibility(By.cssSelector("input#"+locator),15).getAttribute("value");
        if(actualText.equals(currentDate))
        {
            getTest().log(LogStatus.PASS, "Current date is selected as expected");
            logger.info("Current date is selected as expected");
        }else
        {
            getTest().log(LogStatus.FAIL, "Current date is not selected");
            logger.info("Current date is not selected");
        }
    }
    public void verifyOrderDateFieldPresence()
    {
        WebElement orderDateField=findElementVisibility(By.cssSelector("[data-target='#txtOrderDate']"),15);
        if(orderDateField!=null)
        {
            getTest().log(LogStatus.PASS, "User have option to select the \"Product Order Date\"");
            logger.info("User have option to select the \"Product Order Date\"");
        }else {
            getTest().log(LogStatus.FAIL, "\"Product Order Date\" field is not displayed foe the User");
            logger.info("\"Product Order Date\" field is not displayed foe the User");
        }
    }
    public void verifyInvoiceDateFieldPresence()
    {
        WebElement orderDateField=findElementVisibility(By.cssSelector("[data-target='#InvoiceDate']"),15);
        if(orderDateField!=null)
        {
            getTest().log(LogStatus.PASS, "User have option to select the \"Invoice Date\"");
            logger.info("User have option to select the \"Invoice Date\"");
        }else {
            getTest().log(LogStatus.FAIL, "\"Invoice Date\" field is not displayed foe the User");
            logger.info("\"Invoice Date\" field is not displayed foe the User");
        }
    }
    public void clickOrderDateField()
    {
        scrollToWebelement(By.cssSelector("[data-target='#txtOrderDate']"),"Order Date");
        click(By.cssSelector("[data-target='#txtOrderDate']"),"Order Date",15);
    }
    public void clickInvoiceDateField()
    {
        scrollToWebelement(By.cssSelector("[data-target='#InvoiceDate']"),"Invoice Date");
        click(By.cssSelector("[data-target='#InvoiceDate']"),"Invoice Date",15);
    }
    public void clickInsuranceDateField()
    {
        scrollToWebelement(By.cssSelector("[data-target='#txtInsuranceToDate']"),"Order Date");
        click(By.cssSelector("[data-target='#txtInsuranceToDate']"),"Order Date",15);
    }
    public void clickWarrantyDateField()
    {
        scrollToWebelement(By.cssSelector("[data-target='#txtWarrantyDuration']"),"Order Date");
        click(By.cssSelector("[data-target='#txtWarrantyDuration']"),"Order Date",15);
    }
    public void verifyInvoiceNumberFieldPresence()
    {
        WebElement element=findElementVisibility(By.cssSelector("div>input#InvoiceNumber"),15);
        if(element!=null)
        {
            getTest().log(LogStatus.PASS, "User have option to enter the Invoice Number");
            logger.info("User have option to enter the Invoice Number");
        }else
        {
            getTest().log(LogStatus.FAIL, "Invoice number field is not displayed to the user");
            logger.info("Invoice number field is not displayed to the user");
        }
    }
    public void verifyInvoiceNumberAlphaNumeric()
    {
        String invoiceNumber="A1b2C3";
        enterInvoiceNumber(invoiceNumber);
        String actualText=findElementVisibility(By.cssSelector("div>input#InvoiceNumber"),15).getAttribute("value");
        if(invoiceNumber.equals(actualText))
        {
            getTest().log(LogStatus.PASS, "Invoice Number field is accept the data with alpha numeric character as expected. Entered Data : "+invoiceNumber);
            logger.info("Invoice Number field is accept the data with alpha numeric character as expected. Entered Data : "+invoiceNumber);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Invoice Number field is not accepting the data with alpha numeric character as expected. Entered Data : "+invoiceNumber);
            logger.info("Invoice Number field is not accepting the data with alpha numeric character as expected. Entered Data : "+invoiceNumber);
        }
    }
    public void verifyInvoiceNumberSpclChar()
    {
        String invoiceNumber="!@#$%";
        enterInvoiceNumber(invoiceNumber);
        String actualText=findElementVisibility(By.cssSelector("div>input#InvoiceNumber"),15).getAttribute("value");
        if(invoiceNumber.equals(actualText))
        {
            getTest().log(LogStatus.PASS, "Invoice Number field is accept the data with special character as expected. Entered Data : "+invoiceNumber);
            logger.info("Invoice Number field is accept the data with special character as expected. Entered Data : "+invoiceNumber);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Invoice Number field is not accepting the data with special character as expected. Entered Data : "+invoiceNumber);
            logger.info("Invoice Number field is not accepting the data with special character as expected. Entered Data : "+invoiceNumber);
        }
    }
    public void verifyInsuranceNumberAlphaNumeric()
    {
        String insuranceNumber="A1b2C3";
        enterInvoiceNumber(insuranceNumber);
        String actualText=findElementVisibility(By.cssSelector("div>input#InsuranceRefNumber"),15).getAttribute("value");
        if(insuranceNumber.equals(actualText))
        {
            getTest().log(LogStatus.PASS, "Insurance Ref Number field accepts the data with alpha numeric character as expected. Entered Date : "+insuranceNumber);
            logger.info("Insurance Ref Number field accepts the data with alpha numeric character as expected. Entered Date : "+insuranceNumber);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Insurance Ref Number field is not accepts the data with alpha numeric character as expected. Entered Date : "+insuranceNumber);
            logger.info("Insurance Ref Number field is not accepts the data with alpha numeric character as expected. Entered Date : "+insuranceNumber);
        }
    }
    public void verifyInsurerNameAlphaNumeric()
    {
        String insurarName="A1b2C3";
        enterInsurarName(insurarName);
        String actualText=findElementVisibility(By.cssSelector("div>input#InsurerName"),15).getText();
        if(!insurarName.equals(actualText))
        {
            getTest().log(LogStatus.PASS, "Insurar Name field is accept the data as expected");
            logger.info("Insurar Name field is accept the data as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Insurar Name field is not working as expected. It accept the Value \""+insurarName+"\"");
            logger.info("Insurar Name field is not working as expected. It accept the Value \""+insurarName+"\"");
        }
    }
    public void verifyInsurenceDateField(String condition)
    {
        boolean insurenceDate=findElementsVisibility(By.cssSelector("div>input#[data-target='#txtInsuranceToDate']")).isEnabled();
        if(condition.equals("enable")) {
            if (insurenceDate) {
                getTest().log(LogStatus.PASS, "Insurence Ref Number Field is enabled when toggle in product type page is set as \"Yes\"");
                logger.info("Insurence Ref Number field is enabled when toggle in product type page is set as \"Yes\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Insurence Ref Number field is diabled when toggle in product type page is set as \"Yes\"");
                logger.info("Insurence Ref Number field is enabled when toggle in product type page is set as \"Yes\"");
            }
        }
        else if(condition.equals("disable"))
        {
            if (!insurenceDate) {
                getTest().log(LogStatus.PASS, "Insurence Ref Number field is disabled when toggle in product type page is set as \"No\"");
                logger.info("Insurence Ref Number field is disabled when toggle in product type page is set as \"No\"");
            }else {
                getTest().log(LogStatus.FAIL, "Insurence Ref Number field is enabled when toggle in product type page is set as \"No\"");
                logger.info("Insurence Ref Number is enabled when toggle in product type page is set as \"No\"");
            }
        }
    }
    public void verifyDepreciationRuleField(String depreciation)
    {
        boolean depreciationRule=findElementsVisibility(By.cssSelector("div>input#depreciationId")).isEnabled();
        if(depreciation.equals("enable")) {
            if (depreciationRule) {
                getTest().log(LogStatus.PASS, "Depriciation Rule Field is enabled when toggle in product type page is set as \"Yes\"");
                logger.info("Depriciation Rule field is enabled when toggle in product type page is set as \"Yes\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Depriciation Rule field is diabled when toggle in product type page is set as \"Yes\"");
                logger.info("Depriciation Rule field is enabled when toggle in product type page is set as \"Yes\"");
            }
        }
        else if(depreciation.equals("disable"))
        {
            if (!depreciationRule) {
                getTest().log(LogStatus.PASS, "Depriciation Rule field is disabled when toggle in product type page is set as \"No\"");
                logger.info("Depriciation Rule field is disabled when toggle in product type page is set as \"No\"");
            }else {
                getTest().log(LogStatus.FAIL, "Depriciation Rule field is enabled when toggle in product type page is set as \"No\"");
                logger.info("Depriciation Rule is enabled when toggle in product type page is set as \"No\"");
            }
        }
    }
    public void verifyDepreciarionDropdown()
    {
        click(By.cssSelector("div>input#depreciationId"),"Depreciation Rule",15);
        WebElement depreciationValues=findElementsVisibility(By.cssSelector("select#depreciationId>option:nth-child(2)"));
        List<WebElement> depreciationRule=findMultipleElement(By.cssSelector("select#depreciationId>option"),15);
        if(depreciationRule.size()>=4)
        {
            getTest().log(LogStatus.PASS, "Depreciation dropdown values are displayed as expected");
            logger.info("Depreciation dropdown values are displayed as expected");
        }
        else
        {
            getTest().log(LogStatus.PASS, "Depreciation dropdown values are not displayed as expected");
            logger.info("Depreciation dropdown values are not displayed as expected");
        }
    }
    public void verifyProductLifeMandatory()
    {
        int beforeDepreciationRule=findMultipleElement(By.xpath("//form[@id='AdddEditeploy']//div[@class='row']//span[@class='text-danger']"),15).size();
        selectDepreciationRule(2);
        int afterDepreciationRule=findMultipleElement(By.xpath("//form[@id='AdddEditeploy']//div[@class='row']//span[@class='text-danger']"),15).size();
        if(beforeDepreciationRule<afterDepreciationRule)
        {
            getTest().log(LogStatus.PASS, "Product Life field is displayed as mandatory after selecting depreciation rule");
            logger.info("Product Life field is displayed as mandatory after selecting depreciation rule");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Product Life field is not displayed as mandatory after selecting depreciation rule");
            logger.info("Product Life field is not displayed as mandatory after selecting depreciation rule");
        }
    }
    public void verifyProductLifeNumeric()
    {
        String year="2";
        enterProductLife(year);
        String actualText=findElementVisibility(By.cssSelector("div>input#ItemLife"),15).getAttribute("value");
        if(actualText.equals(year))
        {
            getTest().log(LogStatus.PASS, "Product Life field accepts the data with only numeric value as expected. Entered Data : "+year);
            logger.info("Product Life field accepts the data with only numeric value as expected. Entered Data : "+year);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Product Life field does not accepts the data with only numeric value as expected. Entered Data : "+year);
            logger.info("Product Life field doed not accepts the data with only numeric value as expected. Entered Data : "+year);
        }
    }
    public void verifyProductLifeAlphaNumeric()
    {
        String year="A2bc";
        enterProductLife(year);
        String actualText=findElementVisibility(By.cssSelector("div>input#ItemLife"),15).getAttribute("value");
        if(!actualText.equals(year))
        {
            getTest().log(LogStatus.PASS, "Product Life field accepts the data with alpha numeric character as expected. Entered date : "+year);
            logger.info("Product Life field accepts the data with alpha numeric character as expected. Entered date : "+year);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Product Life field does not accepts the data with alpha numeric character as expected. Entered date : "+year);
            logger.info("Product Life field does not accepts the data with alpha numeric character as expected. Entered date : "+year);
        }
    }
    public void verifyProductLifeMinimumChar()
    {
        String year="";
        enterProductLife(year);
        WebElement errorMsg=findElementVisibility(By.xpath("//input[@id='ItemLife']//parent::div//span"),15);
        if(errorMsg!=null)
        {
            getTest().log(LogStatus.PASS, "Product Life field accepts the data as expected");
            logger.info("Product Life field accepts the data as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Product Life field not accepts the data as expected and it accepts value as \\\"\"+year+\"\\\"");
            logger.info("Product Life field not accepts the data as expected and it accepts value as \""+year+"\"");
        }
    }
    public void verifyProductLifeMaximumChar()
    {
        String year="12345";
        enterProductLife(year);
        String actualText=findElementVisibility(By.cssSelector("div>input#ItemLife"),15).getAttribute("value");
        if(!actualText.equals(year))
        {
            getTest().log(LogStatus.PASS, "Product Life field not accepts the data with more than 3 digits as expected Entered Data : "+year);
            logger.info("Product Life field not accepts the data with more than 3 digits as expected Entered Data : "+year);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Product Life field accepts the data with more than 3 digits as expected Entered Data : "+year);
            logger.info("Product Life field accepts the data with more than 3 digits as expected Entered Data : "+year);
        }
    }
    public void verifySalvageCostNumeric()
    {
        String salvageCost="123";
        enterSalvageCost(salvageCost);
        String actualText=findElementVisibility(By.cssSelector("div>input#SalvageCost"),15).getAttribute("value");
        if(actualText.equals(salvageCost))
        {
            getTest().log(LogStatus.PASS, "Salvage Cost field accepts the data with only numeric values as expected. Entered Data : "+salvageCost);
            logger.info("Salvage Cost field accepts the data with only numeric values as expected. Entered Data : "+salvageCost);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Salvage Cost field is not accepts the data with only numeric values as expected. Entered Data : "+salvageCost);
            logger.info("Salvage Cost field is not accepts the data with only numeric values as expected. Entered Data : "+salvageCost);
        }
    }
    public void verifySalvageCostCharandSpclChar()
    {
        String salvageCost="Abc!@#";
        enterSalvageCost(salvageCost);
        String actualText=findElementVisibility(By.cssSelector("div>input#SalvageCost"),15).getAttribute("value");
        if(actualText.equals(""))
        {
            getTest().log(LogStatus.PASS, "Salvage Cost field not accepts the data with character and special character values as expected. Entered Data : "+salvageCost);
            logger.info("Salvage Cost field not accepts the data with character and special character values as expected. Entered Data : "+salvageCost);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Salvage Cost field is accepts the data with character and special character values as expected. Entered Data : "+salvageCost);
            logger.info("Salvage Cost field is accepts the data with character and special character values as expected. Entered Data : "+salvageCost);
        }
    }
    public void verifySalvageCostMaxChar()
    {
        String salvageCost="1234567890";
        enterSalvageCost(salvageCost);
        String actualText=findElementVisibility(By.cssSelector("div>input#SalvageCost"),15).getAttribute("value");
        if(actualText.equals(salvageCost))
        {
            getTest().log(LogStatus.PASS, "Salvage Cost field accepts the data with maximum of 10 digit values as expected. Entered Data : "+salvageCost);
            logger.info("Salvage Cost field accepts the data with maximum of 10 digit values as expected. Entered Data : "+salvageCost);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Salvage Cost field is not accepts the data with maximum of 10 digit values as expected. Entered Data : "+salvageCost);
            logger.info("Salvage Cost field is not accepts the data with maximum of 10 digit values as expected. Entered Data : "+salvageCost);
        }
    }
    public void verifySalvageCostMorethanMaxChar()
    {
        String salvageCost="1234567890123456";
        enterSalvageCost(salvageCost);
        String actualText=findElementVisibility(By.cssSelector("div>input#SalvageCost"),15).getAttribute("value");
        if(!actualText.equals(salvageCost))
        {
            getTest().log(LogStatus.PASS, "Salvage Cost field is not accepts the data with more than 10 digit values as expected. Entered Data : "+salvageCost);
            logger.info("Salvage Cost field accepts the data with more than of 10 digit values as expected. Entered Data : "+salvageCost);
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Salvage Cost field accepts the data with more than of 10 digit values as expected. Entered Data : "+salvageCost);
            logger.info("Salvage Cost field accepts the data with more than of 10 digit values as expected. Entered Data : "+salvageCost);
        }
    }
    public void verifyAddToListButton()
    {
        WebElement addToList=findElementClickable(By.cssSelector("#btn_AddRow"),15);
        if(addToList!=null)
        {
            getTest().log(LogStatus.PASS, "Add to list button is present as clickable");
            logger.info("Add to list button is present as clickable");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Add to list button is not clickable");
            logger.info("Add to list button is not clickable");
        }
    }
    public void verifyDeployList(String modelName)
    {
        String expectedModelName=modelName;
        List<WebElement> modelInList=findMultipleElement(By.xpath("//div[@class='row']//div[1]//div//table[@id='example']//tbody//tr//td[4]"),15);
        for (WebElement element:modelInList)
        {
          if(element.getText().equals(expectedModelName))
          {
              getTest().log(LogStatus.PASS, "Created product is displayed in the \"Deploy Product\" list when click on the add to list button");
              logger.info("Created product is displayed in the \"Deploy Product\" list when click on the add to list button");
              break;
          }
          else
          {
              getTest().log(LogStatus.FAIL, "Created product is not displayed in the \"Deploy Product\" list when click on the add to list button");
              logger.info("Created product is not displayed in the \"Deploy Product\" list when click on the add to list button");
          }
        }
    }

    public void clickCancelButton()
    {
        click(By.cssSelector("a#cancelBtn"),"Cancel",15);
    }
    public void verifyCancelButtonFunctionality()
    {
        make100PageSize();
        List<WebElement> modelNameLocatorList=findMultipleElement(By.xpath("//table[@id='deployItemsTable']//tbody//tr//td[2]"),15);
        int i=0;
        for (WebElement element:modelNameLocatorList)
        {
            i++;
           if(!element.getText().equals(modelNameFromPopup)&&i==modelNameLocatorList.size())
           {
               getTest().log(LogStatus.PASS, "Cancel button is working as expecetd");
               logger.info("Cancel button is working as expecetd");
               break;
           }
           else if(element.getText().equals(modelNameFromPopup))
           {
               getTest().log(LogStatus.FAIL, "Cancel button is not working as expecetd");
               logger.info("Cancel button is not working as expecetd");
           }
        }
    }
    public void verifySaveButtonFunctionality()
    {
        String modelName=getText(By.cssSelector("div>input#Model"),15);
        clickSaveButton();
        make100PageSize();
        List<WebElement> modelNameLocatorList=findMultipleElement(By.xpath("//table[@id='deployItemsTable']//tbody//tr//td[2]"),15);
        for (WebElement element:modelNameLocatorList)
        {
            if(element.getText().equals(modelName))
            {
                getTest().log(LogStatus.PASS, "Save button is working as expecetd");
                logger.info("Save button is working as expecetd");
                break;
            }
            else
            {
                getTest().log(LogStatus.FAIL, "Save button is not working as expecetd");
                logger.info("Save button is not working as expecetd");
            }
        }
    }
    public void clickCloseButton()
    {
        waitForVisibilityOfElement(By.cssSelector("div>input#Quantity"),20);
        findElementsVisibility(By.xpath("//div[@role='dialog']//div//div/div//button")).click();
    }
    public void verifyCloseButtonFunctionality()
    {
        WebElement quantityField=findElementsVisibility(By.cssSelector("div>input#Quantity"));
        if(quantityField==null)
        {
            getTest().log(LogStatus.PASS, "Close button is working as expecetd");
            logger.info("Close button is working as expecetd");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Close button is not working as expecetd");
            logger.info("Close button is not working as expecetd");
        }
    }
    public void createDeployProduct(String quantity,String unitPrice,String modelName,String manufacturer,
                                    String vendor,String cost,String purchaseOrder,String invoiceNumber,String date,
                                    String insurenceNumber,String insurarName,int depreciationRule,String productLife,String salvageCost)
    {
        clickLocationDropdown();
        selectLocationValueFromDropdown();
        enterQuantity(quantity);
        enterUnitPrice(unitPrice);
        enterModel(modelName);
        enterManufacturer(manufacturer);
        enterVendor(vendor);
        enterProductCost(cost);
        enterPurchaseOrder(purchaseOrder);
        clickOrderDateField();
        selectDate(date);
        enterInvoiceNumber(invoiceNumber);
        clickInvoiceDateField();
        selectDate(date);
        enterInsuranceNumber(insurenceNumber);
        enterInsurarName(insurarName);
        clickInsuranceDateField();
        selectDate(date);
        clickWarrantyDateField();
        selectDate("Future");
        selectDepreciationRule(depreciationRule);
        enterProductLife(productLife);
        enterSalvageCost(salvageCost);
        clickAddListButton();
        clickSaveButton();
        handleSuccessPopup();
    }
    public void VerifyPaginationFunctionalities()
    {
        String[] defaultpaginationText=getText(By.xpath("//div[@class='nu-paging']//ul//li//span[contains(@class,'ml')]"),20).split(" ");
        int defaultStartRecordCount=Integer.parseInt(defaultpaginationText[1]);
        int defaultEndCount=Integer.parseInt(defaultpaginationText[3]);
        int totalRecordCount=Integer.parseInt(defaultpaginationText[5]);
        WebElement paginationNavigator=findElementVisibility(By.xpath("//div[@class='nu-paging']//li//ul"),15);
        if(paginationNavigator!=null)
        {
            click(By.xpath("//a[@class='page-link next' and text()='Next']"),"Next",15);
            waitForLoad(10);
            String[] nextPaginationText=getText(By.xpath("//div[@class='nu-paging']//ul//li//span[contains(@class,'ml')]"),20).split(" ");
            int nextPageStartRecordCount=Integer.parseInt(nextPaginationText[1]);
            if(nextPageStartRecordCount==defaultEndCount+1)
            {
                getTest().log(LogStatus.PASS, "Next page is displayed as expected when click on the \"Next\" pagination button");
                logger.info("Next page is displayed as expected when click on the \"Next\" pagination button");
            }
            else {
                getTest().log(LogStatus.PASS, "Next page is not displayed as expected when click on the \"Next\" pagination button");
                logger.info("Next page is not displayed as expected when click on the \"Next\" pagination button");
            }
            findElementVisibility(By.xpath("//a[@class='page-link previous' and text()='Prev']"),15).click();
            waitForLoad(10);
            String[] previousPaginationText=getText(By.xpath("//div[@class='nu-paging']//ul//li//span[contains(@class,'ml')]"),20).split(" ");
            int previousPageEndCount=Integer.parseInt(previousPaginationText[3]);
            if(previousPageEndCount==nextPageStartRecordCount-1)
            {
                getTest().log(LogStatus.PASS, "Previous page is displayed as expected when click on the \"Previous\" pagination button");
                logger.info("Previous page is displayed as expected when click on the \"Previous\" pagination button");
            }
            else
            {
                getTest().log(LogStatus.PASS, "Previous page is not displayed as expected when click on the \"Previous\" pagination button");
                logger.info("Previous page is not displayed as expected when click on the \"Previous\" pagination button");
            }
            findElementVisibility(By.xpath("//a[@class='page-link next' and text()='Last ']"),15).click();
            waitForLoad(10);
            String[] lastPagePaginationText=getText(By.xpath("//div[@class='nu-paging']//ul//li//span[contains(@class,'ml')]"),20).split(" ");
            int lastPageEndCount=Integer.parseInt(lastPagePaginationText[3]);
            if(lastPageEndCount==totalRecordCount)
            {
                getTest().log(LogStatus.PASS, "Last page is displayed as expected when click on the \"Last\" pagination button");
                logger.info("Last page is displayed as expected when click on the \"Last\" pagination button");
            }
            else
            {
                getTest().log(LogStatus.PASS, "Last page is not displayed as expected when click on the \"Last\" pagination button");
                logger.info("Last page is not displayed as expected when click on the \"Last\" pagination button");
            }
            findElementVisibility(By.xpath("//a[@class='page-link  first' and text()='First ']"),15).click();
            waitForLoad(10);
            String[] firstPagePaginationText=getText(By.xpath("//div[@class='nu-paging']//ul//li//span[contains(@class,'ml')]"),20).split(" ");
            int firstPageStartRecordCount=Integer.parseInt(firstPagePaginationText[1]);
            if(firstPageStartRecordCount==defaultStartRecordCount)
            {
                getTest().log(LogStatus.PASS, "First page is displayed as expected when click on the \"First\" pagination button");
                logger.info("First page is displayed as expected when click on the \"First\" pagination button");
            }
            else
            {
                getTest().log(LogStatus.PASS, "First page is not displayed as expected when click on the \"First\" pagination button");
                logger.info("First page is not displayed as expected when click on the \"First\" pagination button");
            }
        }
    }
}
