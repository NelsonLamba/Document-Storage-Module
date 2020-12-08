package pageobjects;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.tools.ant.taskdefs.Available;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testcases.DeployProduct;
import utils.Drivers;
import utils.PropertiesLoader;
import utils.WebBasePage;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.testng.reporters.XMLReporter.FILE_NAME;
import static reporting.ComplexReportFactory.getTest;

public class RelatedInformationPage extends WebBasePage {

    WebDriver driver;

    public RelatedInformationPage(WebDriver driver) {
        super(driver, "");
        this.driver = driver;
    }

    private final static String FILE_NAME = System.getProperty("user.dir") + "\\src\\main\\resources\\testdata.properties";
    String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
    private static Properties prop = new PropertiesLoader(FILE_NAME).load();
    //String searchUniqueName = NameGenerator();
    String searchUniqueName = "145hhh_10";
    String pattern = "yyyyMMddHHmmss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String dateValue = simpleDateFormat.format(new Date());
    static String changeUniqueNameRandomValue;


    String barcodeFileName;

    public void clickFullMenu() {
        click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 15);
    }

    public void clickAssertManagement() {
        click(By.xpath("//div//li[@data-name='Asset']"), "clickAssertManagement", 15);
    }

    public void clickManageProduct() {
        click(By.xpath("(//ul[contains(@class,'submenu clschild')]//a[@id='cadmin_messageboard_link'])[2]"), "ManageProduct", 5);
    }

    public void clickRelatedProduct() {
        click(By.xpath("//table[@id='tablelistingdata']/tbody/tr[2]/td[5]//a"), "Product name", 20);
    }

    public void clickRelatedInformationTab() {
        waitForVisibilityOfElement(By.xpath("(//a[@id='tab-timeline'])[2]"), 50);
        click(By.xpath("(//a[@id='tab-timeline'])[2]"), "related Information button", 20);
    }

    //    public void openProduct()
//    {
//        click(By.xpath("//table[@id='tablelistingdata']//tbody//tr//td[5]//a[contains(text(),'"+AddProductPage.itemNameRandomValue+"')]"),"Product",15);
//    }
    public void checkRelatedpageHeading() {
        String element = getText(By.xpath("//div[@class='theme-primary partition-full']//span[text()='Related Information']"), 10);
        if (element.equals("Related Information")) {
            getTest().log(LogStatus.PASS, " RelatedInformation  Page is  Displayed");
            logger.info("RelatedInformation  Page is  Displayed");
        } else {
            getTest().log(LogStatus.FAIL, " RelatedInformation  Page is not Displayed");
            logger.info("RelatedInformation  Page is not  Displayed");
        }
    }

    public void checkRelatedPageheaders() {
        int i = 0;
        List expecteListHeader = new ArrayList();
        expecteListHeader.add("Location");
        expecteListHeader.add("Unique Name/Code");
        expecteListHeader.add("Total Quantity");
        expecteListHeader.add("Available Quantity");
        expecteListHeader.add("Barcode");
        expecteListHeader.add("Serial Number");
        expecteListHeader.add("Phone No.");
        expecteListHeader.add("Cost");
        expecteListHeader.add("Warranty Expiration Date");
        expecteListHeader.add("Calibration Date");
        expecteListHeader.add("Audit");
        expecteListHeader.add("View History");
        expecteListHeader.add("Status");
        expecteListHeader.add("Action");

        waitForVisibilityOfElement(By.xpath("//table[@id='tblRelatedInfoListing']//tr//th//span"), 50);
        List<WebElement> listHeader = findMultipleElement(By.xpath("//table[@id='tblRelatedInfoListing']//tr//th//span"), 30);
        for (WebElement actual : listHeader) {
            List<String> element = expecteListHeader;
            for (Object expected : expecteListHeader) {
                i++;
                String txt = actual.getText();
                String txt1 = expected.toString();
                if (actual.getText().equals(expected)) {
                    getTest().log(LogStatus.PASS, "The " + expected + " Header is displayed in the Pending Checkout Page");
                    logger.info("Pass - The " + expected + " Header is displayed in the Related information page");
                    i = 0;
                    break;
                } else if (i == listHeader.size() && !actual.getText().equals(expected)) {
                    getTest().log(LogStatus.FAIL, "The " + expected + " Header is not displayed in the Pending Checkout Page");
                    logger.info("Fail - The " + expected + " Header is not displayed in the Related information page");

                }
            }
        }
    }

    public void checkSearchbarisAvailable() {
        WebElement element = findElementVisibility(By.cssSelector("input#relatedAssetSearch"), 80);
        if (element != null) {
            getTest().log(LogStatus.PASS, "The  Searchbar is displayed in the Related information page");
            logger.info("The  Searchbar is displayed in the Related information page");
        } else {
            getTest().log(LogStatus.FAIL, "The  Searchbar is not displayed in the Related information page");
            logger.info("The  Searchbar is not displayed in the Related information page");
        }
    }

    public void searchUniqueName() {
        enter(By.cssSelector("input#relatedAssetSearch"), searchUniqueName, "UniqueName", 10);
    }

    public void clickSearchIcon() {
        click(By.cssSelector("a#aRelatedSearchAsset"), "searchicon", 10);
        wairForLoader(20);
    }

    public void verifyUniqueNameSearch() {
        int rowCount = findMultipleElement(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr"), 20).size();
        String resultName = getText(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr//td//a[@class='editinfo']"), 20).trim();
        if (rowCount == 1 && resultName.equals(searchUniqueName)) {
            getTest().log(LogStatus.PASS, "Searched unique name is displayed as expected");
            logger.info("Searched unique name is displayed as expected");
        } else {
            getTest().log(LogStatus.FAIL, "Searched unique name is not displayed as expected");
            logger.info("Searched unique name is not displayed as expected");
        }
    }

    public void clickResetIcon() {
        waitForVisibilityOfElement(By.cssSelector("a#aUN_ClearSearch"), 20);
        click(By.cssSelector("a#aUN_ClearSearch"), "clickResetIcon", 20);
    }

    public void checksearchBarisEmpty() {
        String searchField = findElementVisibility(By.cssSelector("input#relatedAssetSearch"), 10).getAttribute("value");

        if (searchField.equals("")) {
            getTest().log(LogStatus.PASS, "The  Searchbar is Empty in the Related information page");
            logger.info("The  Searchbar is Empty in the Related information page");

        } else {
            getTest().log(LogStatus.FAIL, "The  Searchbar is not Empty in the Related information page");
            logger.info("The  Searchbar is not Empty in the Related information page");

        }
    }

    public void verifyBreadCrumb() {
        WebElement breadCrumb = findElementVisibility(By.cssSelector(".breadcrumb"), 20);
        if (breadCrumb != null) {
            getTest().log(LogStatus.PASS, "BreadCrumb is displayed in the Related Information Product  page");
            logger.info("BreadCrumb is displayed in the Deploy Product listing page");
        } else {
            getTest().log(LogStatus.FAIL, "BreadCrumb is not displayed in the Related Information page");
            logger.info("BreadCrumb is not displayed in the Deploy Product listing page");
        }
    }

    public void clickbarCodePrint() {
        waitForVisibilityOfElement(By.cssSelector("a#btnBarCodePDF"), 30);
        WebElement element = findElementVisibility(By.cssSelector("a#btnBarCodePDF"), 10);
        if (element.isDisplayed()) {
            click(By.cssSelector("a#btnBarCodePDF"), "clickBarCodePrint", 20);
            getTest().log(LogStatus.PASS, " clickbarCodePrint element click");
            logger.info("clickbarCodePrint element clicked");
        } else {
            getTest().log(LogStatus.FAIL, " clickbarCodePrint element is not click");
            logger.info("clickbarCodePrint element is not clicked");
        }
    }

    public void checkbarCodePrintPopupPage() {
        String element = getText(By.xpath("//div[contains(@class,'modal-header')]//h5[text()='Barcode']"), 30);
        if (element.contains("Barcode")) {
            getTest().log(LogStatus.PASS, "Barcode print popup is Displayed");
            logger.info("Barcode print popup is Displayed");
        } else {
            getTest().log(LogStatus.FAIL, "Barcode print popup is not Displayed");
            logger.info("Barcode print popup is not Displayed");

        }
    }

    public void closebarCodePrintpopup() {
        click(By.xpath("(//button[@class='close']//i[@class='fa fa-times'])[7]"), "closeBarCodePrint", 20);
    }

    public void downloadBulkBarCode() {
        String downloadPath = Drivers.path;
        String fileName = "Barcodes.pdf";
        File dir = new File(downloadPath + fileName);
        if (dir.exists()) {
            dir.delete();
        }
        waitForVisibilityOfElement(By.cssSelector("a#btnBarCode"), 30);
        click(By.cssSelector("a#btnBarCode"), "downloadBulkBarCode", 10);
        waitTillNewFile(downloadPath, 0);
    }

    public void checkDownloadedBulkBarCodePdf() {
        String downloadPath = Drivers.path;
        String fileName = "Barcodes.pdf";
        File dir = new File(downloadPath + fileName);
        File dir2 = new File(downloadPath);
        waitTillNewFile(dir2.toString(), 0);
        boolean dirContents = dir.exists();
        if (dirContents) {
            getTest().log(LogStatus.PASS, "Downloaded File is Exist");
            logger.info("Downloaded File is Exist");
        } else {
            getTest().log(LogStatus.FAIL, "Downloaded File is not Exist");
            logger.info("Downloaded File is not Exist");
        }

    }


    public void clickUniqueCode() {
        click(By.xpath("(//a[@class='editinfo'])[1]"), "clickuniqueCode", 10);
    }

    public void editUniquename() {
        changeUniqueNameRandomValue = prop.getProperty("productName") + dateValue;
        enter(By.cssSelector("input#UniqueName"), changeUniqueNameRandomValue, "Edit Uniquename", 10);
        String userName = getAtribute(By.cssSelector("input#UniqueName"), "value", 15);
        if (changeUniqueNameRandomValue.equals(userName)) {
            getTest().log(LogStatus.PASS, "UserName field is editable and able change as " + changeUniqueNameRandomValue);
            logger.info("UserName field is editable and able change as " + changeUniqueNameRandomValue);
        } else {
            getTest().log(LogStatus.FAIL, "UserName field is not editable");
            logger.info("UserName field is not editable");
        }
    }

    public void editwarrentyduration() {
        String duration = prop.getProperty("warrentyduration");
        enter(By.cssSelector("input#WarrantyDuration"), duration, "Edit Warrenty", 10);
        String warrenty = getAtribute(By.cssSelector("input#WarrantyDuration"), "value", 15);
        if (duration.equals(warrenty)) {
            getTest().log(LogStatus.PASS, "warrentyduration field is editable and able change as " + duration);
            logger.info("warrentyduration field is editable and able change as " + duration);
        } else {
            getTest().log(LogStatus.FAIL, "UserName field is not editable");
            logger.info("warrentyduration field is not editable");
        }
    }

    public void editcost() {
        String cost = prop.getProperty("cost");
        enter(By.cssSelector("input#Cost"), cost, "Edit cost", 10);
        String Cost = getAtribute(By.cssSelector("input#Cost"), "value", 15);
        if (cost.equals(Cost)) {
            getTest().log(LogStatus.PASS, "UserName field is editable and able change as " + cost);
            logger.info("Cost field is editable and able change as " + cost);
        } else {
            getTest().log(LogStatus.FAIL, "UserName field is not editable");
            logger.info("Cost field is not editable");
        }
    }

    public void editserialnumber() {
        String serialnumber = prop.getProperty("serialnumber");
        enter(By.cssSelector("input#SerialNumber"), serialnumber, "Edit serialnumber", 10);
        String Snumber = getAtribute(By.cssSelector("input#SerialNumber"), "value", 15);
        if (serialnumber.equals(Snumber)) {
            getTest().log(LogStatus.PASS, "UserName field is editable and able change as " + serialnumber);
            logger.info("UserName field is editable and able change as " + serialnumber);
        } else {
            getTest().log(LogStatus.FAIL, "serialnumber field is not editable");
            logger.info("serialnumber field is not editable");
        }
    }

    public void editLicensekey() {
        String licenseKey = prop.getProperty("licensekey");
        enter(By.cssSelector("input#LicenseKey"), licenseKey, "Edit Licensekey", 10);
        String licencekey = getAtribute(By.cssSelector("input#LicenseKey"), "value", 10);
        if (licenseKey.equals(licencekey)) {
            getTest().log(LogStatus.PASS, "UserName field is editable and able change as " + licenseKey);
            logger.info("licencekey field is editable and able change as " + licenseKey);
        } else {
            getTest().log(LogStatus.FAIL, "licencekey field is not editable");
            logger.info("licencekey field is not editable");
        }
    }

    public void editLicensetype() {
        String licenseType = prop.getProperty("licensetype");
        enter(By.cssSelector("input#LicenseType"), licenseType, "Edit Licensetype", 10);
        String licencetype = getAtribute(By.cssSelector("input#LicenseType"), "value", 10);
        if (licenseType.equals(licencetype)) {
            getTest().log(LogStatus.PASS, "UserName field is editable and able change as " + licenseType);
            logger.info("licencekey field is editable and able change as " + licenseType);
        } else {
            getTest().log(LogStatus.FAIL, "Licensetype field is not editable");
            logger.info("Licensetype field is not editable");
        }
    }

    public void editVersion() {
        String version = prop.getProperty("version");
        enter(By.cssSelector("input#Version"), version, "Edit Versione", 10);
        String versions = getAtribute(By.cssSelector("input#Version"), "value", 10);
        if (version.equals(versions)) {
            getTest().log(LogStatus.PASS, "UserName field is editable and able change as " + version);
            logger.info("Version field is editable and able change as " + version);
        } else {
            getTest().log(LogStatus.FAIL, "Version field is not editable");
            logger.info("Version field is not editable");
        }
    }

    public void editInstalledMachine() {
        String installedMachine = prop.getProperty("installedMachine");
        enter(By.cssSelector("input#InstalledMachine"), installedMachine, "Edit InstalledMachine", 10);
        String installedMachines = getAtribute(By.cssSelector("input#InstalledMachine"), "value", 10);
        if (installedMachine.equals(installedMachines)) {
            getTest().log(LogStatus.PASS, "UserName field is editable and able change as " + installedMachine);
            logger.info("InstalledMachine field is editable and able change as " + installedMachine);
        } else {
            getTest().log(LogStatus.FAIL, "Version field is not editable");
            logger.info("InstalledMachine field is not editable");
        }
    }

    public void editInstalledPath() {
        String installedPath = prop.getProperty("installedPath");
        enter(By.cssSelector("input#InstalledPath"), installedPath, "Edit InstalledPath", 10);
        waitForVisibilityOfElement(By.cssSelector("input#InstalledPath"), 20);
        String installedPaths = getAtribute(By.cssSelector("input#InstalledPath"), "value", 10);
        if (installedPath.equals(installedPaths)) {
            getTest().log(LogStatus.PASS, "InstalledPath field is editable and able change as " + installedPath);
            logger.info("InstalledPath field is editable and able change as " + installedPath);
        } else {
            getTest().log(LogStatus.FAIL, "InstalledPath field is not editable");
            logger.info("InstalledPath field is not editable");
        }
        scrollDown();
    }

    public void editModelName() {
        String modelName = prop.getProperty("modelName");
        enter(By.cssSelector("input#ModelName"), modelName, "ModelName", 10);
        String mNames = getAtribute(By.cssSelector("input#ModelName"), "value", 10);
        if (modelName.equals(mNames)) {
            getTest().log(LogStatus.PASS, "UserName field is editable and able change as " + modelName);
            logger.info("ModelName field is editable and able change as " + modelName);
        } else {
            getTest().log(LogStatus.FAIL, "InstalledPath field is not editable");
            logger.info("ModelName field is not editable");
        }
    }

    public void editModelNumber() {
        String modelNumber = prop.getProperty("modelNumber");
        enter(By.cssSelector("input#ModelNumber"), modelNumber, "Edit ModelNumber", 10);
        waitForVisibilityOfElement(By.cssSelector("input#ModelNumber"), 20);
        String mNumber = getAtribute(By.cssSelector("input#ModelNumber"), "value", 10);
        if (modelNumber.equals(mNumber)) {
            getTest().log(LogStatus.PASS, "UserName field is editable and able change as " + modelNumber);
            logger.info("ModelNumber field is editable and able change as " + modelNumber);
        } else {
            getTest().log(LogStatus.FAIL, "ModelNumber field is not editable");
            logger.info("ModelNumber field is not editable");
        }
    }

    public void editBrand() {
        String brand = prop.getProperty("brand");
        enter(By.cssSelector("input#Brand"), brand, "Edit Brand", 10);
        String brandd = getAtribute(By.cssSelector("input#Brand"), "value", 10);
        if (brand.equals(brandd)) {
            getTest().log(LogStatus.PASS, "UserName field is editable and able change as " + brand);
            logger.info("Brand field is editable and able change as " + brand);
        } else {
            getTest().log(LogStatus.FAIL, "Brand field is not editable");
            logger.info("Brand field is not editable");
        }
    }

    public void editBillNumber() {
        String billNumber = prop.getProperty("billNumber");
        enter(By.cssSelector("input#BillNumber"), billNumber, "Edit BillNumber", 10);
        String bNumber = getAtribute(By.cssSelector("input#BillNumber"), "value", 10);
        if (billNumber.equals(bNumber)) {
            getTest().log(LogStatus.PASS, "BillNumber field is editable and able change as " + billNumber);
            logger.info("BillNumber field is editable and able change as " + billNumber);
        } else {
            getTest().log(LogStatus.FAIL, "BillNumber field is not editable");
            logger.info("BillNumber field is not editable");
        }
    }

    public void editImeiNumber() {
        String imeiNumber = prop.getProperty("imeiNumber");
        enter(By.cssSelector("input#ImeiNumber"), imeiNumber, "Edit ImeiNumber", 10);
        String imeiNumberr = getAtribute(By.cssSelector("input#ImeiNumber"), "value", 10);
        if (imeiNumber.equals(imeiNumberr)) {
            getTest().log(LogStatus.PASS, "imeiNumber field is editable and able change as " + imeiNumber);
            logger.info("ImeiNumber field is editable and able change as " + imeiNumber);
        } else {
            getTest().log(LogStatus.FAIL, "BillNumber field is not editable");
            logger.info("ImeiNumber field is not editable");
        }
    }

    public void editSimNumber() {
        String simNumber = prop.getProperty("simNumber");
        enter(By.cssSelector("input#SimNumber"), simNumber, "Edit SimNumber", 10);
        String simNumbers = getAtribute(By.cssSelector("input#SimNumber"), "value", 10);
        if (simNumber.equals(simNumbers)) {
            getTest().log(LogStatus.PASS, "SimNumber field is editable and able change as " + simNumber);
            logger.info("SimNumber field is editable and able change as " + simNumber);
        } else {
            getTest().log(LogStatus.FAIL, "SimNumber field is not editable");
            logger.info("SimNumber field is not editable");
        }
    }

    public void editphonenumber() {
        String phoneNumber = prop.getProperty("phonenumber");
        enter(By.cssSelector("input#phonenumber"), phoneNumber, "Edit phonenumber", 10);
        String phoneNumberr = getAtribute(By.cssSelector("input#phonenumber"), "value", 10);
        if (phoneNumber.equals(phoneNumberr)) {
            getTest().log(LogStatus.PASS, "phonenumber field is editable and able change as " + phoneNumber);
            logger.info("phonenumber field is editable and able change as " + phoneNumber);
        } else {
            getTest().log(LogStatus.FAIL, "phonenumber field is not editable");
            logger.info("phonenumber field is not editable");
        }
    }

    public void editmobileironredsetup() {
        String mobileIronredSetup = prop.getProperty("mobileironredsetup");
        enter(By.cssSelector("input#mobileironredsetup"), mobileIronredSetup, "Edit mobileironredsetup", 10);
        String mobileIronredSetupp = getAtribute(By.cssSelector("input#mobileironredsetup"), "value", 10);
        if (mobileIronredSetup.equals(mobileIronredSetupp)) {
            getTest().log(LogStatus.PASS, "mobileironredsetup field is editable and able change as " + mobileIronredSetup);
            logger.info("mobileironredsetup field is editable and able change as " + mobileIronredSetup);
        } else {
            getTest().log(LogStatus.FAIL, "mobileironredsetup field is not editable");
            logger.info("mobileironredsetup field is not editable");
        }
    }

    public void editAccessoryOn() {
        String accessoryon = prop.getProperty("accessoryon");
        enter(By.cssSelector("input#accessoryon"), accessoryon, "Edit accessoryon", 10);
        String accessoryonn = getAtribute(By.cssSelector("input#accessoryon"), "value", 10);
        if (accessoryon.equals(accessoryonn)) {
            getTest().log(LogStatus.PASS, "accessoryon field is editable and able change as " + accessoryon);
            logger.info("accessoryon field is editable and able change as " + accessoryon);
        } else {
            getTest().log(LogStatus.FAIL, "accessoryon field is not editable");
            logger.info("accessoryon field is not editable");
        }
    }

    public void editmachinename() {
        String machineName = prop.getProperty("machinename");
        enter(By.cssSelector("input#machinename"), machineName, "Edit machinename", 10);
        String machinename = getAtribute(By.cssSelector("input#machinename"), "value", 10);
        if (machineName.equals(machinename)) {
            getTest().log(LogStatus.PASS, "machinename field is editable and able change as " + machineName);
            logger.info("machinename field is editable and able change as " + machineName);
        } else {
            getTest().log(LogStatus.FAIL, "accessoryon field is not editable");
            logger.info("machinename field is not editable");
        }
    }

    public void editdivisionname() {
        String divisionName = prop.getProperty("divisionname");
        scrollToWebelement(By.cssSelector("input#divisionname"), "editdivision");
        enter(By.cssSelector("input#divisionname"), divisionName, "Edit divisionname", 10);
        String divisionnamee = getAtribute(By.cssSelector("input#divisionname"), "value", 10);
        if (divisionName.equals(divisionnamee)) {
            getTest().log(LogStatus.PASS, "divisionname field is editable and able change as " + divisionName);
            logger.info("divisionname field is editable and able change as " + divisionName);
        } else {
            getTest().log(LogStatus.FAIL, "divisionname field is not editable");
            logger.info("divisionname field is not editable");
        }
    }


    public void editStatusdrpdown() {
        selectValueWithText(By.xpath("(//div//select[@id='StatusId'])[2]"), "Inactive", "SelectStatus", 10);
    }

    public void nextCalibrationdisabledfield() {
        driver.findElement(By.cssSelector("input#CalibrationDate")).getAttribute("readonly");
        if (true) {
            getTest().log(LogStatus.PASS, "nextCalibrationdisabledfield is  Disabled");
            logger.info("Element is  Disabled");
        } else {
            getTest().log(LogStatus.FAIL, "nextCalibrationdisabledfield is not  Disabled");
            logger.info("Element is  not Disabled");
        }
    }

    public void nextimagedisabledfield() {
        driver.findElement(By.cssSelector("#ImageDate")).getAttribute("readonly");
        if (true) {
            getTest().log(LogStatus.PASS, "nextimagedisabledfield is  Disabled");
            logger.info("nextimagedisabledfield is  Disabled");
        } else {
            getTest().log(LogStatus.FAIL, "nextimagedisabledfield is not  Disabled");
            logger.info("nextimagedisabledfield is  not Disabled");
        }
    }

    public void editRFIDdisabledfield() {
        driver.findElement(By.cssSelector("#RFID")).getAttribute("readonly");
        if (true) {
            getTest().log(LogStatus.PASS, "editRFIDdisabledfield is  Disabled");
            logger.info("editRFIDdisabledfield is  Disabled");
        } else {
            getTest().log(LogStatus.FAIL, "editRFIDdisabledfield is not  Disabled");
            logger.info("editRFIDdisabledfield is  not Disabled");
        }
    }

    public void laptopCarryingBagcheckbox() {
        clickByJavascript(By.xpath("//label[contains(@class,'custom-control-label') and @for='laptopcarrying_bag']"), "laptop bag check box", 10);
    }

    public void editsave() {
        click(By.cssSelector("a#ancSaveRelatedInfo"), "downloadBarImage", 10);
    }

    public void changeTheStatusDropDown() {
        selectValueWithIndex(By.cssSelector("#ddlchangeitemsatats"), 3, "SelectStatus", 10);
    }

    public void editStatusDD() {
        click(By.cssSelector("//a//i[@id='istatus']"), "Editstatus", 10);
    }

    public void clickok() {
        click(By.xpath("//button[@data-bb-handler='confirm']"), "clickok", 10);
    }

    public void editGPS() {
        String gps = prop.getProperty("gps");
        enter(By.cssSelector("input#GPS"), gps, "Edit GPS", 10);
        String gpss = getAtribute(By.cssSelector("input#GPS"), "value", 10);
        if (gps.equals(gpss)) {
            getTest().log(LogStatus.PASS, "GPS field is editable and able change as " + gps);
            logger.info("GPS field is editable and able change as " + gps);
        } else {
            getTest().log(LogStatus.FAIL, "GPS field is not editable");
            logger.info("GPS field is not editable");
        }
    }

    public void acquisitionDate(String date) {
        click(By.xpath("//div[@data-target='#AcquisitionDate']"), "acquisitiondate", 10);
        selectDate(date);
    }

    public void nextAuditDate(String date) {
        scrollToWebelement(By.xpath("//div[@data-target='#LastAuditDate']"), "auditdate");
        click(By.xpath("//div[@data-target='#LastAuditDate']"), "auditdate", 10);
        selectDate(date);
    }

    public String selectDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/MMM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);
        String inputDate = (date.equals("Old")) ? dtf.format(now.minusDays(1)) : (date.equals("Future")) ? dtf.format(now.plusDays(1)) : dtf.format(now);
        String[] inputDateArray = inputDate.split("/");
        String day = inputDateArray[0];
        String month = inputDateArray[1];
        String year = inputDateArray[2];
        click(By.cssSelector(".picker-switch"), "Mont&Year popup", 15);
        click(By.cssSelector("[title='Select Year']"), "Year popup", 15);
        click(By.xpath("//span[contains(@class,'year') and text()='" + year + "']"), "Year Value", 15);
        click(By.xpath("//span[contains(@class,'month') and text()='" + month + "']"), "Month Value", 15);
        String dayClass = findElementVisibility(By.xpath("//td[contains(@class,'day') and text()='" + day + "']"), 15).getAttribute("class");
        if (!dayClass.contains("disabled")) {
            findElementClickable(By.xpath("//td[contains(@class,'day') and text()='" + day + "']"), 15).click();
        }
        return dayClass;
    }

    public void warrentydate(String date) {
        click(By.xpath("//div[@data-target='#WarrantyExpirationDate']"), "choosewarrentydate", 10);
        selectDate(date);
    }

    public void addAttachment() {
        WebElement element = findElementVisibility(By.cssSelector("input#flFile_related"), 20);
        if (element != null) {
            uploadDoc(By.cssSelector("input#flFile_related"), filePath + prop.getProperty("testfilePDF"), "upload document", 10);
        }
    }


    public void downloadBarImageIcon() {
        barcodeFileName = getText(By.xpath("//table//tbody//tr[1]//td[3]//a[@class='editinfo']"), 10);
        String downloadPath = Drivers.path;
        String fileName = barcodeFileName + ".png";
        File dir = new File(downloadPath + fileName);
        if (dir.exists()) {
            dir.delete();
        }
        click(By.xpath("(//a//i[@title='Download Barcode'])[1]"), "downloadBarImage", 20);
        waitTillNewFile(downloadPath, 0);
    }

    public void checkDownloadedBarImage() {


        String downloadPath = Drivers.path;
        String fileName = barcodeFileName + ".png";
        File dir = new File(downloadPath + fileName);
        File dir2 = new File(downloadPath);
        waitTillNewFile(dir2.toString(), 0);
        boolean dirContents = dir.exists();
        if (dirContents) {
            getTest().log(LogStatus.PASS, "Downloaded File is Exist");
            logger.info("Downloaded File is Exist");
        } else {
            getTest().log(LogStatus.FAIL, "Downloaded File is not Exist");
            logger.info("Downloaded File is not Exist");
        }

    }


    public void clickCalibrationComment() {
        scroll();
        findElementClickable(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[11]//i"), 30);
        click(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[11]//i"), "clickCalibrationComment", 30);
    }

    public void verifyCommentPopup() {
        String popupValidation = getText(By.xpath("//div[@id='UN_PopUps']//label"), 20);
        if (popupValidation.contains("Calibration")) {
            getTest().log(LogStatus.PASS, "Calibration Comment Popup  Page is  Displayed");
            logger.info("Calibration Comment Popup  Page is  Displayed");

        } else {
            getTest().log(LogStatus.FAIL, "Calibration Comment Popup  Page is not Displayed");
            logger.info("Calibration Comment Popup Page is not  Displayed");

        }
    }

    public void chooseCalibrationStartDate(String date) {
        click(By.xpath("//div[@data-target='#AuditDate']"), "chooseCalibrationDate", 10);
        selectDate(date);

    }

    public void chooseCalibrationNextdate(String date) {

        click(By.xpath("//div[@data-target='#NextAuditDate']"), "chooseCalibrationNextDate", 10);
        selectDate(date);
    }

    public void selectCalibrationstatus() {
        click(By.xpath("//label[@for='rdo_1']/.."), "status", 10);
    }

    public void enterCalibrationcomment() {
        enter(By.cssSelector("textarea#Comment"), prop.getProperty("enterCalibrationcomment"), "Calibration Comment", 10);
    }

    public void savepostcalibrationComment() {
        click(By.cssSelector("a#postcomment"), "savepostComment", 10);
    }

    public void clickCalibrationcloseicon() {
        click(By.xpath("//div[@class='modal fade mail-box-pop dialog my-popups ui-draggable show']//following::button"), "closeicon", 10);
    }

    public void chooseauditDate(String date) {
        click(By.xpath("//div[@data-target='#AuditDate']"), "chooseAuditStartDate", 10);
        selectDate(date);
    }

    public void chooseauditNextdate(String date) {
        click(By.xpath("//div[@data-target='#NextAuditDate']"), "chooseAuditNextDate", 10);
        selectDate(date);
    }

    public void clickAuditComment() {
        findElementClickable(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[12]//a[@class='table-head-btn viewcomment float-right']"), 30);
        click(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[12]//a[@class='table-head-btn viewcomment float-right']"), "clickauditComment", 10);
    }

    public void clickauditcloseicon() {
        click(By.xpath("//div[@class='modal fade mail-box-pop dialog my-popups ui-draggable show']//following::button"), "closeicon", 10);
    }

    public void verifyauditCommentPopup() {
        String element = getText(By.xpath("//div[@id='UN_PopUps']//label"), 20);
        if (element.contains("Audit")) {
            getTest().log(LogStatus.PASS, "Calibration Comment Popup  Page is  Displayed");
            logger.info("Calibration Comment Popup  Page is  Displayed");

        } else {
            getTest().log(LogStatus.FAIL, "Calibration Comment Popup  Page is not Displayed");
            logger.info("Calibration Comment Popup Page is not  Displayed");

        }
    }

    public void clickProductpopupPage() {
        String alertMsg = "Related Information has been successfully updated.";
        String alertMssg = getText(By.xpath("//div[@role='alert']"), 15);
        if (alertMsg.equals(alertMssg)) {
            click(By.xpath("//button//span//i[@class='fa fa-times text-secondary']"), "close the alert message", 15);
        }
    }

    public void selectAuditStatus() {
        click(By.xpath("//label[@for='rdo_1']/.."), "status", 10);
    }

    public void enterAuditComment() {
        enter(By.cssSelector("textarea#Comment"), prop.getProperty("enterAuditcomment"), "Audit Comment", 10);
    }

    public void savepostauditComment() {
        click(By.cssSelector("a#postcomment"), "savepostComment", 10);
    }

    public void scroll() {
        String scroll = "up";
        scrollDown();
        scrollToWebelement(By.xpath("//a//i[@id='istatus']"), "edit status");
        scrollUpDown(scroll);
    }


    public void clickEditStatus() {
        waitForVisibilityOfElement(By.xpath("//table[@id='tblRelatedInfoListing']//th[@id='th-STATUS']"), 20);
        scrollToWebelement(By.xpath("//table[@id='tblRelatedInfoListing']//th[@id='th-STATUS']"), "Status Header");
        waitForVisibilityOfElement(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[14]"), 20);
        String status = getText(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[14]"), 15);
        if (status.equals("Inactive")) {
            WebElement inactiveElement = findElementVisibility(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td//a//span[@class='stop']"), 20);
            if (inactiveElement != null) {
                try {
                    click(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td//a//span[@class='stop']"), "change status", 20);
                } catch (Exception e) {
                    clickByJavascript(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td//a//span[@class='stop']"), "Change status", 20);
                }
            } else {
                getTest().log(LogStatus.FAIL, "Inactive field is not visible");
                logger.info("Inactive field is not visible");
            }
            String confirmationPopup = getText(By.xpath("//div[@class='modal-content my-popups']//div[contains(@class,'body alert alert-warning')]"), 15);
            if (confirmationPopup.equals("Are you sure you want to change the status?")) {
                click(By.xpath("//div[@class='modal-content my-popups']//button[@title='OK']"), "ok", 10);
                String successMsg = getText(By.xpath("//div[@role='alert']"), 10);
                if (successMsg.equals("Related Information has been successfully updated.")) {
                    click(By.xpath("//i[@class='fa fa-times text-secondary']"), "close success message", 15);
                } else {
                    getTest().log(LogStatus.FAIL, "Success Messgae is not displayed");
                    logger.info("Success Messgae is not displayed");
                }
            } else {
                getTest().log(LogStatus.FAIL, "Confirmation Popup is not displayed");
                logger.info("Confirmation Popup is not displayed");
            }
            scrollToWebelement(By.xpath("//table[@id='tblRelatedInfoListing']//th[@id='th-STATUS']"), "Status Header");
            String changedStatus = getText(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[@class='actinact single-action']//span"), 20);
            if (changedStatus.equals("Active")) {
                getTest().log(LogStatus.PASS, "Inactive status is changed to Active status as expected");
                logger.info("Inactive status is changed to Active status as expected");
            } else {
                getTest().log(LogStatus.FAIL, "Inactive status is  not changed to Active status as expected");
                logger.info("Inactive status is not changed to Active status as expected");
            }
        }
    }

    public void changeStatus() {
        waitForVisibilityOfElement(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[@class='actinact single-action']//span"), 20);
        String selectedValue = getText(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[@class='actinact single-action']//span"), 15);
        click(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td//a[contains(@class,'UpdateItemStatus')]"), "Edit status", 40);
        click(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td//select[@id='ddlchangeitemsatats']"), "select DD", 10);
        checkStatusdropdown();
        int value = (selectedValue.equals("On Hold")) ? 4 : 3;
        selectValueWithIndex(By.cssSelector("#ddlchangeitemsatats"), value, "SelectStatus", 10);
        String confirmationPopup = getText(By.xpath("//div[@class='modal-content my-popups']//div[contains(@class,'body alert alert-warning')]"), 15);
        if (confirmationPopup.equals("Are you sure you want to change the status?")) {
            click(By.xpath("//div[@class='modal-content my-popups']//button[contains(@class,'btn-success')]"), "ok", 10);
            String successMsg = getText(By.xpath("//div[@role='alert']"), 10);
            if (successMsg.equals("Related Information has been successfully updated.")) {
                click(By.xpath("//i[@class='fa fa-times text-secondary']"), "close success message", 15);
            } else {
                getTest().log(LogStatus.FAIL, "Success Messgae is not displayed");
                logger.info("Success Messgae is not displayed");
            }
        }
    }

    public void checkStatusdropdown() {
        String[] expected = {"Select", "Active", "Inactive", "On Hold", "Sold"};
        List<WebElement> options = findMultipleElement(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td//select[@id='ddlchangeitemsatats']//option"), 20);
        int k = 0;
        int i = 0;
        for (WebElement opt : options) {
            i++;
            if (opt.getText().equals(expected[k])) {
                getTest().log(LogStatus.PASS, expected[k] + " value present in the DropDown");
                logger.info("expected[k]+\" value present in the DropDown\"");
            } else if (i == 4 && !opt.getText().equals(expected[k])) {
                getTest().log(LogStatus.FAIL, expected[k] + " value not present in the DropDown");
                logger.info(expected[k] + " value not present in the DropDown");
            }
            k = k + 1;

        }
    }

    public void viewHistoryValidations() {
        scroll();
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        waitForVisibilityOfElement(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td//a[@class='table-head-btn historyicon ']"), 80);
        click(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td//a[@class='table-head-btn historyicon ']"), "view History", 90);
        switchToTab(1);
        checkProjectInformationPage();
        checkProductInformationPageheaders();
        pendingCheckOutList();
        checkpendingCheckoutPageheaders();
        switchToParentTab();
        closeCurrentTab(1);
    }

    public void checkProjectInformationPage() {
        String productPage = "Product:";
        String text = getText(By.cssSelector("div>b.font-weight-medium"), 30);
        if (text.equals(productPage)) {
            getTest().log(LogStatus.PASS, "Product Information  Page is  Displayed");
            logger.info("Product Information  Page is  Displayed");
        } else {
            getTest().log(LogStatus.FAIL, "Product Information  Page is  Displayed");
            logger.info("Product Information  Page is not  Displayed");

        }

    }

    public void checkProductInformationPageheaders() {
        int i = 0;
        List<String> expecteListHeader = new ArrayList();
        expecteListHeader.add("Product:");
        expecteListHeader.add("Serial Number:");
        expecteListHeader.add("Model Name:");
        expecteListHeader.add("Cost:");
        expecteListHeader.add("Warranty Duration:");
        expecteListHeader.add("Unique Name:");
        expecteListHeader.add("Brand:");
        expecteListHeader.add("Model Number:");
        expecteListHeader.add("Warranty Expiration Date:");


        List<WebElement> listHeader = driver.findElements(By.xpath("//div[@id='myTabContent']//div//b"));
        for (WebElement actual : listHeader) {
            List<String> element = expecteListHeader;
            for (Object expected : expecteListHeader) {
                i++;
                String txt1 = actual.getText();
                String txt = expected.toString();
                if (actual.getText().equals(expected)) {
                    getTest().log(LogStatus.PASS, "The " + expected + " Header is displayed in the Project Information Page");
                    logger.info("Pass - The " + expected + " Header is displayed in the Related information page");
                    i = 0;
                    break;
                } else if (i == listHeader.size() && !actual.getText().equals(expected)) {
                    getTest().log(LogStatus.FAIL, "The " + expected + " Header is not displayed in the Project Information Page");
                    logger.info("Fail - The " + expected + " Header is not displayed in the Related information page");

                }
            }
        }

    }

    public void pendingCheckOutList() {
        click(By.xpath("//a[text()='Pending Check Out List']"), "pending checkout List", 10);
        String element = getText(By.xpath("//span[normalize-space(@id)='ASSETGROUP']"), 15);

        if (element.contains("Item Name")) {
            getTest().log(LogStatus.PASS, "Pending Check Out List  Page is  Displayed");
            logger.info("Pending Check Out List  Page is  Displayed");
        } else {
            getTest().log(LogStatus.FAIL, "Pending Check Out List  Page is not Displayed");
            logger.info("Pending Check Out List Page is not  Displayed");
        }

    }

    public void checkpendingCheckoutPageheaders() {
        int i = 0;
        List<String> expecteListHeader = new ArrayList<>();
        expecteListHeader.add("Item Name");
        expecteListHeader.add("From Time");
        expecteListHeader.add("To Time");
        expecteListHeader.add("Check Out Request By");
        expecteListHeader.add("Check Out Request Date");
        expecteListHeader.add("Assign");
        expecteListHeader.add("Reject");
        List<WebElement> listHeader = driver.findElements(By.xpath("//table[@id='tblRelatedInfoListing']//thead//tr//th//span"));
        for (WebElement actual : listHeader) {
            List<String> element = expecteListHeader;
            for (Object expected : expecteListHeader) {
                i++;
                String txt1 = actual.getText();
                String txt = expected.toString();
                if (actual.getText().equals(expected)) {
                    getTest().log(LogStatus.PASS, "The " + expected + " Header is displayed in the Pending Checkout Page");
                    logger.info("Pass - The " + expected + " Header is displayed in the Related information page");
                    i = 0;
                    break;
                } else if (i == listHeader.size() && !actual.getText().equals(expected)) {
                    getTest().log(LogStatus.FAIL, "The " + expected + " Header is not displayed in the Pending Checkout Page");
                    logger.info("Fail - The " + expected + " Header is not displayed in the Related information page");

                }
            }
        }
    }

    public void clickManageProducts() {
        click(By.xpath("//a[@data-original-title='Manage Product' and not (@id='cadmin_messageboard_link')]"), "clickManageproducts", 10);
    }

    public void chooseproduct() {
        String element = getText(By.cssSelector("a#ancEditAssetType"), 15);
        if (element.contains("145hhh")) {
            click(By.cssSelector("a#ancEditAssetType"), "choose product", 10);
            getTest().log(LogStatus.PASS, "selected product  is  Displayed");
        } else {
            getTest().log(LogStatus.FAIL, "selected product  is not Displayed");
        }
    }

    public void returntoRelatedInformation() {
        click(By.xpath("//a[@id='tab-timeline' and (text()='Related Information ')]"), "Related Information", 10);
    }

    public void selectrecordPagination() {
        String selectRecordPage = prop.getProperty("selectRecordPage");
        selectValueWithValue(By.cssSelector("#pageSize"), selectRecordPage, "Page size", 10);
        waitForLoad(20);
        Select checkrecord = new Select(driver.findElement(By.cssSelector("select#pageSize")));
        String selectedOption = checkrecord.getFirstSelectedOption().getText();
        int checkRecord = Integer.parseInt(selectedOption);
        int recordCount = findMultipleElement(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr"), 20).size();

        if (checkRecord == Integer.parseInt(selectRecordPage) && recordCount <= checkRecord) {
            getTest().log(LogStatus.PASS, "Records are displayed as expected based on the selected page size");
            logger.info("Records are displayed as expected based on the selected page size");

        } else {
            getTest().log(LogStatus.FAIL, "Records are not displayed as expected based on the selected page size");
            logger.info("Records are not displayed as expected based on the selected page size");
        }
    }


}
