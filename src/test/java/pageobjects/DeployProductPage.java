package pageobjects;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.justin.BaseTestCase;
import utils.WebBasePage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static reporting.ComplexReportFactory.getTest;

public class DeployProductPage extends WebBasePage {
    WebDriver driver;
    List<String>locationNameList;
    CompanySetup companySetup;
    public DeployProductPage(WebDriver driver)
    {
        super(driver,"Dashboard Page");
        this.driver=driver;
        this.locationNameList=new ArrayList<>();
        this.companySetup=new CompanySetup(driver);
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
        clickFullMenuDropDown();
        clickAssetManagement();
        clickManageProduct();
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


//        List<WebElement> listHeader=driver.findElements(By.xpath("//table[@id='deployItemsTable']//tr//th//span"));
        List<WebElement> listHeader=findMultipleElement(By.xpath("//table[@id='deployItemsTable']//tr//th//span"));
        for (WebElement actual:listHeader) {
            for (Object expected:expecteListHeader ) {
                i++;
                if(actual.getText().equals(expected))
                {
                    getTest().log(LogStatus.PASS, "The "+expected+" Header is displayed in the Deploy listing page");
                    logger.info("The "+expected+" Header is displayed in the Deploy listing page");
                }
                else if(i==listHeader.size()&&!actual.getText().equals(expected))
                {
                    getTest().log(LogStatus.FAIL, "The "+expected+" Header is not displayed in the Deploy listing page");
                    logger.info("The "+expected+" Header is not displayed in the Deploy listing page");
                }
            }
        }
    }
    public void verifySearchBar()
    {
        WebElement searchBar=findElementPresence(By.cssSelector("input#assetSearch"),15);
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
        WebElement addButton=findElementPresence(By.cssSelector(".theme-primary>span>a>i"),15);
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
        WebElement nextButton=findElementPresence(By.cssSelector("a#btnNext"),15);
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
        WebElement nextButton=findElementPresence(By.cssSelector("a#Previous"),15);
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
    }

    public void verifySearchedProduct(String searchItem)
    {
//        List<WebElement> searchedProduct=driver.findElements(By.cssSelector("table#deployItemsTable>tbody>tr>td>a"));
        List<WebElement> searchedProduct=findMultipleElement(By.cssSelector("table#deployItemsTable>tbody>tr>td>a"));
        for (WebElement locators:searchedProduct) {
            if(locators.getText().equals(searchItem))
            {
                getTest().log(LogStatus.PASS, "Searched location list is Displayed");
                logger.info("Searched location list is Displayed");
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
        click(By.className("a#aUN_ClearSearch"),"Clear Search",15);
    }
    public void verifyClearedSearch()
    {
        String searchfield=getAtribute(By.cssSelector("input#assetSearch"),"value",15);
        if(searchfield==null) {
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
        click(By.cssSelector("a#ancDeployItems"),"Add Deploy Product",15);
    }
    public void verifyAddDeployProductPage()
    {
        WebElement addToListButton=findElementPresence(By.cssSelector("a#btn_AddRow"),15);
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
        WebElement relatedInformationHeader=findElementsPresence(By.xpath("//div[@class='theme-primary partition-full']//span[text()='Related Information']"),15);
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
        WebElement relatedInformationHeader=findElementsPresence(By.xpath("//div[@class='theme-primary partition-full']//span[text()='Deploy Product']"),15);
        if(relatedInformationHeader!=null) {
            getTest().log(LogStatus.PASS, "\"Deploy Product page\" is displayed when click previous button in \"Related Information page\"");
            logger.info("\"Deploy Product page\" is displayed when click previous button in \"Related Information page\"");
        }
        else {
            getTest().log(LogStatus.FAIL, "\"Deploy Product page\" is not displayed when click previous button in \"Related Information page\"");
            logger.info("\"Deploy Product page\" is not displayed when click previous button in \"Related Information page\"");
        }
    }
    public void selectLocationFromDropdown()
    {
        click(By.cssSelector("div#divmultilevelselectLocation>div>div"),"Location Dropdown",15);
        click(By.xpath("//ul[@id='CompantLocationSelect']//li[@class='parentli'][1]//a"),"Location Value",15);
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
    public void selectOrderDate(String orderDate)
    {
        //enter(By.cssSelector("div>input#txtOrderDate"),orderDate,"Order Date",15);
        clickOrderDateField();
    }
    public void enterInvoiceNumber(String invoiceNumber)
    {
        enter(By.cssSelector("div>input#txtOrderDate"),invoiceNumber,"Invoice Number",15);
    }
    public void selectInvoiceDate(String invoiceDate)
    {
        enter(By.cssSelector("div>input#InvoiceDate"),invoiceDate,"Invoice Date",15);
        //click(By.cssSelector("div>input#txtOrderDate"),"Order Date",15);
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
        selectValueWithIndex(By.cssSelector("div>input#depreciationId"),index,"Depreciation Rule",15);
    }
    public void enterProductLife(String year)
    {
        enter(By.cssSelector("div>input#depreciationId"),year,"Depreciation Rule",15);
    }
    public void enterSalvageCost(String salvageCost)
    {
        enter(By.cssSelector("div>input#SalvageCost"),salvageCost,"Depreciation Rule",15);
    }
    public void clickAddListButton()
    {
        click(By.cssSelector("div>a#btn_AddRow"),"Depreciation Rule",15);
    }
    public void clickSaveButton()
    {
        click(By.cssSelector("saveBtnn"),"Save",15);
    }
    public void handleSuccessPopup()
    {
        WebElement popup=findElementsPresence(By.cssSelector("div.alert-success"),15);
        if(popup!=null)
        {
            click(By.cssSelector("closenotifymessage"),"Close Popup",15);
        }
    }
    public void verifyCreatedDeployProduct(String modelName)
    {
//        List<WebElement> deployedProductlist=driver.findElements(By.xpath("//table[@id='deployItemsTable']//tbody//tr//td[2]//span"));
        List<WebElement> deployedProductlist=findMultipleElement(By.xpath("//table[@id='deployItemsTable']//tbody//tr//td[2]//span"));
        for (WebElement element:deployedProductlist) {
            if(element.getText().equals(modelName))
            {
                getTest().log(LogStatus.PASS, "Created \"Deploy Product\" is displayed in the list");
                logger.info("Created \"Deploy Product\" is displayed in the list");
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
//        int recordCount=driver.findElements(By.cssSelector("//table[@id='deployItemsTable']//tbody//tr")).size();
        int recordCount=findMultipleElement(By.cssSelector("//table[@id='deployItemsTable']//tbody//tr")).size();
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
        WebElement breadCrumb=findElementPresence(By.cssSelector(".breadcrumb"),15);
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
        if(locationDisabled.equals("disabled")&&saveButton.equals("btn btn-success"))
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
    /*public void verifyPagination()
    {
        List resultList=new ArrayList();
        String[] pagination=getText(By.xpath("//div[@class='nu-paging']//ul//li//span[contains(@class,'ml')]"),15).split(" ");
        int startCount= Integer.parseInt(pagination[1]);
        int countinCurrentPage=Integer.parseInt(pagination[3]);
        int totalCountinPagination=Integer.parseInt(pagination[5]);
        int recordCount=driver.findElements(By.cssSelector("//table[@id='deployItemsTable']//tbody//tr")).size();
        resultList.add((countinCurrentPage-(startCount-1))==recordCount?"true":"false");
        click(By.cssSelector());
    }*/
    public void verifymandatoryFieldValidation()
    {

        List expectedErrors=new ArrayList();
        expectedErrors.add("Location is required");
        expectedErrors.add("Quantity should be greater than 0");
        expectedErrors.add("Product Cost/Qty is required");
        expectedErrors.add("Unit Price should be greater than 0");

        int i=0;
//        int mandatoryFieldCount=driver.findElements(By.xpath("//div[@class='modal-content']//span[@class='text-danger' and text()='*']")).size();
        int mandatoryFieldCount=findMultipleElement(By.xpath("//div[@class='modal-content']//span[@class='text-danger' and text()='*']")).size();
//        List<WebElement> errorMessageLocator=driver.findElements(By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"));
        List<WebElement> errorMessageLocator=findMultipleElement(By.xpath("//div[@class='modal-content']//span[contains(@class,'invalid-feedback')]"));
        if(mandatoryFieldCount==errorMessageLocator.size())
        {
            for (WebElement element:errorMessageLocator) {
                for (Object expected:expectedErrors) {
                    i++;
                    if(element.getText().equals(expected))
                    {
                        getTest().log(LogStatus.PASS, expected+" error message is displayed as expected");
                        logger.info(expected+" error message is displayed as expected");
                        break;
                    }
                    else if (i==errorMessageLocator.size()&&!element.getText().equals(expected))
                    {
                        getTest().log(LogStatus.FAIL, expected+" error message is not displayed as expected");
                        logger.info(expected+" error message is not displayed as expected");
                    }
                }
            }
        }
    }
    public void verifyLocationDropdown()
    {
        WebElement locationDropdown=findElementPresence(By.cssSelector("#CompantLocationSelect>li>ol"),15);
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
        WebElement searchField=findElementPresence(By.cssSelector("#CompantLocationSelect>li.mainelevel"),15);
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
        WebElement searchResult=findElementPresence(By.xpath("//li//a//span[text()='"+searchLocation+"']"),15);
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
        //click full get from add product code
        click(By.cssSelector("[data-name='COMPANY']>a"),"Company Setup",15);
    }
    public void navigateToLocationSetup()
    {
        click(By.cssSelector("[data-original-title='Location']"),"Location Setup",15);
    }
    public void make100PageSize()
    {
        selectValueWithValue(By.cssSelector("select#pageSize"),"100","Page Size",15);
    }
    public void getLocationsFromSetup()
    {
        //List<WebElement> locationList=driver.findElements(By.cssSelector("#ancEditLocation"));
        List<WebElement> locationList=findMultipleElement(By.cssSelector("#ancEditLocation"));
        for (WebElement element:locationList)
        {
            locationNameList.add(element.getText());
        }
    }
    public void verifyLocations()
    {
        int i=0;
        List<WebElement> locations=findMultipleElement(By.cssSelector(".scrollbar>li>a>span"));
        for (WebElement actualElement:locations)
        {
            for (Object expectedElement:locationNameList)
            {
                i++;
             if(actualElement.getText().equals(expectedElement))
             {
                 getTest().log(LogStatus.PASS, expectedElement+"location is present in both setup and location dropdown");
                 logger.info(expectedElement+"location is not present in both setup and location dropdown");
                 break;
             }
             else if(i==locationNameList.size()&&!actualElement.getText().equals(expectedElement))
             {
                 getTest().log(LogStatus.FAIL, expectedElement+"location is not present in location dropdown");
                 logger.info(expectedElement+"location is not present in location dropdown");
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
    }
    public void verifyChildLocationinList(String locationName)
    {
        int i=0;
        //List<WebElement> actualChildNameList=driver.findElements(By.cssSelector("ul.child>li>a>div"));
        List<WebElement> actualChildNameList=findMultipleElement(By.cssSelector("ul.child>li>a>div"));
        for (WebElement element:actualChildNameList)
        {
            i++;
         if(element.getText().equals(locationName))
         {
             getTest().log(LogStatus.PASS, "Created child location \""+locationName+"\" is present in location dropdown");
             logger.info("Created child location \""+locationName+"\" is present in location dropdown");
             break;
         }
         else if(i==actualChildNameList.size()&&!element.getText().equals(locationName))
         {
             getTest().log(LogStatus.FAIL, "Created child location \""+locationName+"\" is not present in location dropdown");
             logger.info("Created child location \""+locationName+"\" is not present in location dropdown");
         }
        }
    }
    public void clearLocationSelection()
    {
        click(By.cssSelector("div#divmultilevelselectLocation>div>div>span>i[title='Clear']"),"Clear Location",15);
    }
    public void verifyClearedLocation()
    {
        String actualVaue=findElementPresence(By.cssSelector("[class='CompantLocationSelectselected float-left']"),15).getText();
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
    public void verifyQuantityFieldValidation(String quantity)
    {
        enterQuantity(quantity);
        String actualText=findElementPresence(By.cssSelector("div>input#Quantity"),15).getText();
        if(!quantity.equals(actualText))
        {
            getTest().log(LogStatus.PASS, "Quantity field is accept the data as expected");
            logger.info("Quantity field is accept the data as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Quantity field is not working as expected. It accept the Value \""+quantity+"\"");
            logger.info("Quantity field is not working as expected. It accept the Value \""+quantity+"\"");
        }
    }
    public void verifyModelFieldValidation(String modelName)
    {
        enterModel(modelName);
        String actualText=findElementPresence(By.cssSelector("div>input#Model"),15).getText();
        if(!modelName.equals(actualText))
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
        String actualText=findElementPresence(By.cssSelector("div>input#Model"),15).getText();
        if(!manufacturerName.equals(actualText))
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
        String actualText=findElementPresence(By.cssSelector("div>input#Model"),15).getText();
        if(!vendorName.equals(actualText))
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
        boolean productCostField=!findElementPresence(By.cssSelector("div>input#AssetCost"),15).isEnabled();
        if(condition.equals("enable")) {
            if (productCostField) {
                getTest().log(LogStatus.PASS, "Product Cost field is enabled when product type is set as \"Yes\" in the company setup page");
                logger.info("Product Cost field is enabled when product type is set as \"Yes\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Product Cost field is diabled when product type is set as \"Yes\" in the company setup page");
                logger.info("Product Cost field is enabled when product type is set as \"Yes\" in the company setup page");
            }
        }
        else if(condition.equals("disable"))
        {
            if (productCostField) {
                getTest().log(LogStatus.PASS, "Product Cost field is disabled when product type is set as \"No\" in the company setup page");
                logger.info("Product Cost field is disabled when product type is set as \"No\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Product Cost field is enabled when product type is set as \"No\" in the company setup page");
                logger.info("Product Cost field is enabled when product type is set as \"No\" in the company setup page");
            }
        }
    }
    public void verifyProductCostFieldalidations(String prodcutCost)
    {
        enterProductCost(prodcutCost);
        String actualText=findElementPresence(By.cssSelector("div>input#AssetCost"),15).getText();
        if(!prodcutCost.equals(actualText))
        {
            getTest().log(LogStatus.PASS, "Product Cost field is accept the data as expected");
            logger.info("Product Cost field is accept the data as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Product Cost field is not working as expected. It accept the Value \""+prodcutCost+"\"");
            logger.info("Product Cost field is not working as expected. It accept the Value \""+prodcutCost+"\"");
        }
    }
    public void verifyRefernceNumberFieldalidations(String refPurchaseOrder)
    {
        enterProductCost(refPurchaseOrder);
        String actualText=findElementPresence(By.cssSelector("div>input#AssetCost"),15).getText();
        if(!refPurchaseOrder.equals(actualText))
        {
            getTest().log(LogStatus.PASS, "Reference PurchaseOrder field is accept the data as expected");
            logger.info("Reference PurchaseOrder field is accept the data as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Reference PurchaseOrder field is not working as expected. It accept the Value \""+refPurchaseOrder+"\"");
            logger.info("Reference PurchaseOrder field is not working as expected. It accept the Value \""+refPurchaseOrder+"\"");
        }
    }
    public static String[] currentDateProcess()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String[] currentDate=dtf.format(now).split("/");
        /*String day=currentDate[0];
        String month=currentDate[1];
        String year=currentDate[2];*/
        return currentDate;
    }
    public WebElement selectDate(String datefield,String date)
    {
        String[] returnedDate=currentDateProcess();
        String year=returnedDate[2];
        String month=returnedDate[1];
        int day=(date.equals("Old"))?Integer.parseInt(returnedDate[0])-1:(date.equals("Future"))?Integer.parseInt(returnedDate[0])+1:(date.equals("Current"))?Integer.parseInt(returnedDate[0]):null;
        String locator=(datefield.equals("Order"))?"#txtOrderDate":(datefield.equals("Invoice"))?"#InvoiceDate":(datefield.equals("Insurance"))?"#txtInsuranceToDate":
                (datefield.equals("Warranty"))?"#txtWarrantyDuration":null;
        click(By.cssSelector("[data-target='"+locator+"']"),"Calendar Icon",15);
        click(By.xpath(".picker-switch"),"Mont&Year popup",15);
        click(By.cssSelector("[title='Select Year']"),"Year popup",15);
        click(By.cssSelector("[title='Select Year']"),"Year popup",15);
        click(By.xpath("//span[contains(@class,'decade') and text()='"+year+"']"),"Year Value",15);
        click(By.xpath("//span[contains(@class,'month') and text()='"+month+"']"),"Month Value",15);
        WebElement dayElement=findElementClickable(By.xpath("//td[contains(@class,'day') and text()='"+day+"']"),15);
        if(dayElement!=null)
        {
            click(By.xpath("By.xpath(\"//td[contains(@class,'day') and text()='\"+day+\"']\")"),"Day Value",15);
        }
        return dayElement;
    }
    public void verifyWithOldDate(String dateField)
    {
        WebElement dayElement=selectDate(dateField,"Old");
        if(dayElement!=null)
        {
            click(By.xpath("By.xpath(\"//td[contains(@class,'day') and text()='\"+day+\"']\")"),"Day Value",15);
            getTest().log(LogStatus.PASS, "Old Date was selected as expected");
            logger.info("Old Date was selected as expected");
        }else
        {
            getTest().log(LogStatus.FAIL, "Not able to select Old date");
            logger.info("Not able to select Old date");
        }
    }
    public void verifyWithFutureDate(String dateField)
    {
        WebElement dayElement=selectDate(dateField,"Future");
        if(dayElement==null)
        {
            getTest().log(LogStatus.PASS, "Not able to select Future Date as expected");
            logger.info("Not able to select Future Date as expected");
        }else
        {
            getTest().log(LogStatus.FAIL, "Future date can be selected");
            logger.info("Future date can be selected");
        }
    }
    public void verifyWithCurrentDate(String dateField)
    {
        WebElement dayElement=selectDate(dateField,"Curent");
        if(dayElement==null)
        {
            getTest().log(LogStatus.PASS, "Current date is selected as expected");
            logger.info("Current date is selected as expected");
        }else
        {
            getTest().log(LogStatus.FAIL, "Current date is not selected");
            logger.info("Current date is not selected");
        }
    }
    public void clickOrderDateField()
    {
        click(By.cssSelector("[data-target='#txtOrderDate']"),"Order Date",15);
    }
    public void clickInvoiceDateField()
    {
        click(By.cssSelector("[data-target='#InvoiceDate']"),"Order Date",15);
    }
    public void clickInsuranceDateField()
    {
        click(By.cssSelector("[data-target='#txtInsuranceToDate']"),"Order Date",15);
    }
    public void clickWarrantyDateField()
    {
        click(By.cssSelector("[data-target='#txtWarrantyDuration']"),"Order Date",15);
    }
    public void verifyInvoiceNumber(String invoiceNumber)
    {
        enterInvoiceNumber(invoiceNumber);
        String actualText=findElementPresence(By.cssSelector("div>input#InvoiceNumber"),15).getText();
        if(!invoiceNumber.equals(actualText))
        {
            getTest().log(LogStatus.PASS, "Invoice Number field is accept the data as expected");
            logger.info("Invoice Number field is accept the data as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Invoice Number field is not working as expected. It accept the Value \""+invoiceNumber+"\"");
            logger.info("Invoice Number field is not working as expected. It accept the Value \""+invoiceNumber+"\"");
        }
    }
    public void verifyInsuranceNumberValidation(String insuranceNumber)
    {
        enterInvoiceNumber(insuranceNumber);
        String actualText=findElementPresence(By.cssSelector("div>input#InsuranceRefNumber"),15).getText();
        if(!insuranceNumber.equals(actualText))
        {
            getTest().log(LogStatus.PASS, "Insurance Ref Number field is accept the data as expected");
            logger.info("Insurance Ref Number field is accept the data as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Insurance Ref Number field is not working as expected. It accept the Value \""+insuranceNumber+"\"");
            logger.info("Insurance Ref Number field is not working as expected. It accept the Value \""+insuranceNumber+"\"");
        }
    }
    public void verifyInsurenceRefNumberField(String condition)
    {
        boolean insurenceRefNumber=findElementsVisibility(By.cssSelector("div>input#InsuranceRefNumber")).isEnabled();
        if(condition.equals("enable")) {
            if (insurenceRefNumber) {
                getTest().log(LogStatus.PASS, "Insurence Ref Number Field is enabled when toggle in product type page is set as \"Yes\"");
                logger.info("Insurence Ref Number field is enabled when toggle in product type page is set as \"Yes\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Insurence Ref Number field is diabled when toggle in product type page is set as \"Yes\"");
                logger.info("Insurence Ref Number field is enabled when toggle in product type page is set as \"Yes\"");
            }
        }
        else if(condition.equals("disable"))
        {
            if (!insurenceRefNumber) {
                getTest().log(LogStatus.PASS, "Insurence Ref Number field is disabled when toggle in product type page is set as \"No\"");
                logger.info("Insurence Ref Number field is disabled when toggle in product type page is set as \"No\"");
            }else {
                getTest().log(LogStatus.FAIL, "Insurence Ref Number field is enabled when toggle in product type page is set as \"No\"");
                logger.info("Insurence Ref Number is enabled when toggle in product type page is set as \"No\"");
            }
        }
    }
    public void verifyInsurerNameField(String insurarName)
    {
        enterInsurarName(insurarName);
        String actualText=findElementPresence(By.cssSelector("div>input#InsurerName"),15).getText();
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
    public void verifyselectedDate(String dateField,String expectedDate)
    {
        String field=(dateField.equals("insurence"))?"Insurence":(dateField.equals("order"))?"Order":(dateField.equals("invoice"))?"Invoice":(dateField.equals("warranty"))?"Warranty":null;
        //String actualInsurenceDate=getAtribute(By.xpath("//div[@class='form-group']//div//input[@id='txtInsuranceToDate']"),"value",15);
        String[] monthandYear=getText(By.xpath("//table[contains(@class,'tabledatetimepicker')]//th[@title='Select Month']"),15).split(" ");
        String actualday=getText(By.xpath("//table[contains(@class,'tabledatetimepicker')]//tr//td[contains(@class,'day active')]"),15);
        String[] expectedDateArray=expectedDate.split("/");
        if(expectedDateArray[0].equals(actualday)&&expectedDateArray[1].equals(monthandYear[0])&&expectedDateArray[2].equals(monthandYear[1]))
        {
            getTest().log(LogStatus.PASS, "Selected "+field +" Date is displayed in the "+field+" Date field");
            logger.info("Selected "+field +" Date is displayed in the "+field+" Date field");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Selected "+field +" Date is not displayed in the "+field+" Date field");
            logger.info("Selected "+field +" Date is displayed in the "+field+" Date field");
        }
    }
    public void verifyDepreciationRuleField(String condition)
    {
        boolean depreciationRule=findElementsVisibility(By.cssSelector("div>input#depreciationId")).isEnabled();
        if(condition.equals("enable")) {
            if (depreciationRule) {
                getTest().log(LogStatus.PASS, "Depriciation Rule Field is enabled when toggle in product type page is set as \"Yes\"");
                logger.info("Depriciation Rule field is enabled when toggle in product type page is set as \"Yes\" in the company setup page");
            }else {
                getTest().log(LogStatus.FAIL, "Depriciation Rule field is diabled when toggle in product type page is set as \"Yes\"");
                logger.info("Depriciation Rule field is enabled when toggle in product type page is set as \"Yes\"");
            }
        }
        else if(condition.equals("disable"))
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
//        List<WebElement> depreciationRule=driver.findElements(By.cssSelector("select#depreciationId>option"));
        List<WebElement> depreciationRule=findMultipleElement(By.cssSelector("select#depreciationId>option"));
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
//        int beforeDepreciationRule=driver.findElements(By.xpath("//form[@id='AdddEditeploy']//div[@class='row']//span[@class='text-danger']")).size();
        int beforeDepreciationRule=findMultipleElement(By.xpath("//form[@id='AdddEditeploy']//div[@class='row']//span[@class='text-danger']")).size();
        selectDepreciationRule(2);
//        int afterDepreciationRule=driver.findElements(By.xpath("//form[@id='AdddEditeploy']//div[@class='row']//span[@class='text-danger']")).size();
        int afterDepreciationRule=findMultipleElement(By.xpath("//form[@id='AdddEditeploy']//div[@class='row']//span[@class='text-danger']")).size();
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
    public void verifyProductLifeField(String year)
    {
        enterProductLife(year);
        String actualText=getText(By.cssSelector("div>input#ItemLife"),15);
        if(actualText.equals(year))
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
    public void verifySalvageCostField(String salvageCost)
    {
        enterProductLife(salvageCost);
        String actualText=getText(By.cssSelector("div>input#SalvageCost"),15);
        if(actualText.equals(salvageCost))
        {
            getTest().log(LogStatus.PASS, "Salvage Cost field accepts the data as expected");
            logger.info("Salvage Cost field accepts the data as expected");
        }
        else
        {
            getTest().log(LogStatus.FAIL, "Salvage Cost field not accepts the data as expected and it accepts value as \""+salvageCost+"\"");
            logger.info("Salvage Cost field not accepts the data as expected and it accepts value as \""+salvageCost+"\"");
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
    public void verifyDeployList()
    {
        String modelName=getText(By.cssSelector("div>input#Model"),15);
//        List<WebElement> modelInList=driver.findElements(By.xpath("//tbody[@class='gridRowsBody ']//tr//td[4]"));
        List<WebElement> modelInList=findMultipleElement(By.xpath("//tbody[@class='gridRowsBody ']//tr//td[4]"));
        for (WebElement element:modelInList)
        {
          if(element.getText().equals(modelName))
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
        String modelName=getText(By.cssSelector("div>input#Model"),15);
        clickCancelButton();
        make100PageSize();
//        List<WebElement> modelNameLocatorList=driver.findElements(By.xpath("//table[@id='deployItemsTable']//tbody//tr//td[2]"));
        List<WebElement> modelNameLocatorList=findMultipleElement(By.xpath("//table[@id='deployItemsTable']//tbody//tr//td[2]"));
        for (WebElement element:modelNameLocatorList)
        {
           if(!element.getText().equals(modelName))
           {
               getTest().log(LogStatus.PASS, "Cancel button is working as expecetd");
               logger.info("Cancel button is working as expecetd");
               break;
           }
           else
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
        //List<WebElement> modelNameLocatorList=driver.findElements(By.xpath("//table[@id='deployItemsTable']//tbody//tr//td[2]"));
        List<WebElement> modelNameLocatorList=findMultipleElement(By.xpath("//table[@id='deployItemsTable']//tbody//tr//td[2]"));
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
        click(By.cssSelector("//div[11]/div/div[@class='modal-content']/div[1]/button"),"Close",15);
    }
    public void verifyCloseButtonFunctionality()
    {
        String modelName=getText(By.cssSelector("div>input#Model"),15);
        clickCloseButton();
        WebElement quantityField=findElementsVisibility(By.cssSelector("div>input#Quantity"));
        if(quantityField!=null)
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
    public void addDeployProduct(String quantity,String unitPrice,String modelName,String manufacturer,
                                   String vendor,String cost,String purchaseOrder,String invoiceNumber,String date,
                                   String insurenceNumber,String insurarName,int depreciationRule,String productLife,String salvageCost)
    {
        clickAddDeployButton();
        selectLocationFromDropdown();
        enterQuantity(quantity);
        enterUnitPrice(unitPrice);
        enterModel(modelName);
        enterManufacturer(manufacturer);
        enterVendor(vendor);
        enterProductCost(cost);
        enterPurchaseOrder(purchaseOrder);
        clickOrderDateField();
        selectDate("Order",date);
        enterInvoiceNumber(invoiceNumber);
        clickInvoiceDateField();
        selectDate("Invoice",date);
        enterInsuranceNumber(insurenceNumber);
        enterInsurarName(insurarName);
        clickInsuranceDateField();
        selectDate("Insurance",date);
        clickWarrantyDateField();
        selectDate("Warranty",date);
        selectDepreciationRule(depreciationRule);
        enterProductLife(productLife);
        enterSalvageCost(salvageCost);
        clickAddListButton();
        clickSaveButton();
        handleSuccessPopup();
    }
}
