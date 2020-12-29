package pageobjects;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Drivers;
import utils.PropertiesLoader;
import utils.WebBasePage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


import static reporting.ComplexReportFactory.getTest;
import static utils.StaticData.createdProductName;

public class RelatedInformationPage extends WebBasePage {

    WebDriver driver;

    public RelatedInformationPage(WebDriver driver) {
        super(driver, "Related information page");
        this.driver = driver;
    }

    private final static String FILE_NAME = System.getProperty("user.dir") + "\\src\\main\\resources\\testdata.properties";
    String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
    private static Properties prop = new PropertiesLoader(FILE_NAME).load();
    String searchUniqueName = createdProductName;
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
        click(By.xpath("//div[@id='scrollbar']//a[text()='Manage Product']"), "Manage Product", 10);
    }

    public void clickRelatedInformationTab() {
        waitForVisibilityOfElement(By.xpath("//a[text()='Related Information ']"), 50);
        click(By.xpath("//a[text()='Related Information ']"), "related Information button", 20);
    }

    public void clickRelatedProduct() {
        String productName=createdProductName;
        click(By.xpath("//table[@id='tablelistingdata']//tbody//tr//td//a[normalize-space(text())='" + productName + "']"), "Product", 20);
    }

    public void checkRelatedpageHeading() {
        String element = getText(By.xpath("//div[@class='theme-primary partition-full']//span[text()='Related Information']"), 10);
        if (element.equals("Related Information")) {
            getTest().log(LogStatus.PASS, " RelatedInformation  Page is  Displayed");
            logger.info("RelatedInformation  Page is  Displayed");
        } else {
            getTest().log(LogStatus.FAIL, " RelatedInformation  Page is not Displayed");
            logger.info("RelatedInformation  Page is not  Displayed");
            takeScreenshot("RelatedInfoPage");
        }
    }

    public void checkRelatedPageheaders() {
        int i = 0;
        List<String> expecteListHeader = new ArrayList<String>();
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
            for (Object expected : element) {
                i++;
                if (actual.getText().equals(expected)) {
                    getTest().log(LogStatus.PASS, "The " + expected + " Header is displayed in the Pending Checkout Page");
                    logger.info("Pass - The " + expected + " Header is displayed in the Related information page");
                    i = 0;
                    break;
                } else if (i == listHeader.size() && !actual.getText().equals(expected)) {
                    getTest().log(LogStatus.FAIL, "The " + expected + " Header is not displayed in the Pending Checkout Page");
                    logger.info("Fail - The " + expected + " Header is not displayed in the Related information page");
                    takeScreenshot(expected.toString());
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
            takeScreenshot("SearchBar");
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
        if (resultName.contains(searchUniqueName)) {
            getTest().log(LogStatus.PASS, "Searched unique name is displayed as expected");
            logger.info("Searched unique name is displayed as expected");
        } else {
            getTest().log(LogStatus.FAIL, "Searched unique name is not displayed as expected");
            logger.info("Searched unique name is not displayed as expected");
            takeScreenshot("SearchedUniqueName");
        }
    }

    public void clickResetIcon() {
        waitForVisibilityOfElement(By.cssSelector("a#aUN_ClearSearch"), 20);
        click(By.cssSelector("a#aUN_ClearSearch"), "clickResetIcon", 20);
    }

    public void checksearchBarisEmpty() {
        String searchField = findElementVisibility(By.cssSelector("input#relatedAssetSearch"), 10).getAttribute("value");
        if (searchField != null && searchField.equals("")) {
            getTest().log(LogStatus.PASS, "The  Searchbar is Empty in the Related information page");
            logger.info("The  Searchbar is Empty in the Related information page");

        } else {
            getTest().log(LogStatus.FAIL, "The  Searchbar is not Empty in the Related information page");
            logger.info("The  Searchbar is not Empty in the Related information page");
            takeScreenshot("SearchBar");
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
            takeScreenshot("BreadCrumb");
        }
    }

    public void clickbarCodePrint() {
        waitForVisibilityOfElement(By.cssSelector("a#btnBarCodePDF"), 30);
        WebElement element = findElementVisibility(By.cssSelector("a#btnBarCodePDF"), 10);
        if (element != null) {
            click(By.cssSelector("a#btnBarCodePDF"), "clickBarCodePrint", 20);
            getTest().log(LogStatus.PASS, " clickbarCodePrint element click");
            logger.info("clickbarCodePrint element clicked");
        } else {
            getTest().log(LogStatus.FAIL, " Click barcode print element is not click");
            logger.info("Click barcode Print element is not clicked");
            takeScreenshot("BarCodePrint");
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
            takeScreenshot("BarCodePrint");
        }
    }

    public void closebarCodePrintpopup() {
        click(By.xpath("//h5[@class='modal-title' and text()='Barcode']//parent::div//button"), "closeBarCodePrint", 20);
    }

    public void downloadBulkBarCode() {
        String downloadPath = Drivers.path;
        String fileName = prop.getProperty("downloadedPdf");
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
        String fileName = prop.getProperty("downloadedPdf");
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
            takeScreenshot("DownloadedFile");
        }

    }


    public void clickUniqueCode() {
        click(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td//a[@class='editinfo']"), "clickuniqueCode", 10);
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
            takeScreenshot("UserName");
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
            takeScreenshot("Warranty");
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
            takeScreenshot("Cost");
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
            takeScreenshot("SerialNumber");
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
            takeScreenshot("LicenseKey");
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
            takeScreenshot("LicenseType");
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
            takeScreenshot("Version");
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
            takeScreenshot("InstalledMachine");
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
            takeScreenshot("InstalledPath");
        }
        scrollDown();
    }

    public void editModelName() {
        String modelName = prop.getProperty("modelName");
        enter(By.cssSelector("input#ModelName"), modelName, "ModelName", 10);
        String mNames = getAtribute(By.cssSelector("input#ModelName"), "value", 10);
        if (modelName.equals(mNames)) {
            getTest().log(LogStatus.PASS, "ModelName field is editable and able change as " + modelName);
            logger.info("ModelName field is editable and able change as " + modelName);
        } else {
            getTest().log(LogStatus.FAIL, "ModelName field is not editable");
            logger.info("ModelName field is not editable");
            takeScreenshot("ModelName");
        }
    }

    public void editModelNumber() {
        String modelNumber = prop.getProperty("modelNumber");
        enter(By.cssSelector("input#ModelNumber"), modelNumber, "Edit ModelNumber", 10);
        waitForVisibilityOfElement(By.cssSelector("input#ModelNumber"), 20);
        String mNumber = getAtribute(By.cssSelector("input#ModelNumber"), "value", 10);
        if (modelNumber.equals(mNumber)) {
            getTest().log(LogStatus.PASS, "ModelNumber field is editable and able change as " + modelNumber);
            logger.info("ModelNumber field is editable and able change as " + modelNumber);
        } else {
            getTest().log(LogStatus.FAIL, "ModelNumber field is not editable");
            logger.info("ModelNumber field is not editable");
            takeScreenshot("ModelNumber");
        }
    }

    public void editBrand() {
        String brand = prop.getProperty("brand");
        enter(By.cssSelector("input#Brand"), brand, "Edit Brand", 10);
        String brandd = getAtribute(By.cssSelector("input#Brand"), "value", 10);
        if (brand.equals(brandd)) {
            getTest().log(LogStatus.PASS, "Brand field is editable and able change as " + brand);
            logger.info("Brand field is editable and able change as " + brand);
        } else {
            getTest().log(LogStatus.FAIL, "Brand field is not editable");
            logger.info("Brand field is not editable");
            takeScreenshot("Brand");
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
            takeScreenshot("BillNumber");
        }
    }

    public void editImeiNumber() {
        String imeiNumber = prop.getProperty("imeiNumber");
        enter(By.cssSelector("input#ImeiNumber"), imeiNumber, "Edit ImeiNumber", 10);
        String imeiNumberr = getAtribute(By.cssSelector("input#ImeiNumber"), "value", 10);
        if (imeiNumber.equals(imeiNumberr)) {
            getTest().log(LogStatus.PASS, "ImeiNumber field is editable and able change as " + imeiNumber);
            logger.info("ImeiNumber field is editable and able change as " + imeiNumber);
        } else {
            getTest().log(LogStatus.FAIL, "ImeiNumber field is not editable");
            logger.info("ImeiNumber field is not editable");
            takeScreenshot("ImeiNumber");
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
            takeScreenshot("SimNumber");
        }
    }

    public void editphonenumber() {
        String phoneNumber = prop.getProperty("phonenumber");
        enter(By.cssSelector("input#phonenumber"), phoneNumber, "Edit phonenumber", 10);
        String phoneNumberr = getAtribute(By.cssSelector("input#phonenumber"), "value", 10);
        if (phoneNumber.equals(phoneNumberr)) {
            getTest().log(LogStatus.PASS, "Phonenumber field is editable and able change as " + phoneNumber);
            logger.info("Phonenumber field is editable and able change as " + phoneNumber);
        } else {
            getTest().log(LogStatus.FAIL, "Phonenumber field is not editable");
            logger.info("Phonenumber field is not editable");
            takeScreenshot("Phonenumber");
        }
    }

    public void editmobileironredsetup() {
        String mobileIronredSetup = prop.getProperty("mobileironredsetup");
        enter(By.cssSelector("input#mobileironredsetup"), mobileIronredSetup, "Edit mobileironredsetup", 10);
        String mobileIronredSetupp = getAtribute(By.cssSelector("input#mobileironredsetup"), "value", 10);
        if (mobileIronredSetup.equals(mobileIronredSetupp)) {
            getTest().log(LogStatus.PASS, "Mobileironredsetup field is editable and able change as " + mobileIronredSetup);
            logger.info("Mobileironredsetup field is editable and able change as " + mobileIronredSetup);
        } else {
            getTest().log(LogStatus.FAIL, "Mobileironredsetup field is not editable");
            logger.info("Mobileironredsetup field is not editable");
            takeScreenshot("Mobileironredsetup");
        }
    }

    public void editAccessoryOn() {
        String accessoryon = prop.getProperty("accessoryon");
        enter(By.cssSelector("input#accessoryon"), accessoryon, "Edit accessoryon", 10);
        String accessoryonn = getAtribute(By.cssSelector("input#accessoryon"), "value", 10);
        if (accessoryon.equals(accessoryonn)) {
            getTest().log(LogStatus.PASS, "Accessoryon field is editable and able change as " + accessoryon);
            logger.info("Accessoryon field is editable and able change as " + accessoryon);
        } else {
            getTest().log(LogStatus.FAIL, "Accessoryon field is not editable");
            logger.info("Accessoryon field is not editable");
            takeScreenshot("Accessoryon");
        }
    }

    public void editmachinename() {
        String machineName = prop.getProperty("machinename");
        enter(By.cssSelector("input#machinename"), machineName, "Edit machinename", 10);
        String machinename = getAtribute(By.cssSelector("input#machinename"), "value", 10);
        if (machineName.equals(machinename)) {
            getTest().log(LogStatus.PASS, "Machinename field is editable and able change as " + machineName);
            logger.info("Machinename field is editable and able change as " + machineName);
        } else {
            getTest().log(LogStatus.FAIL, "accessoryon field is not editable");
            logger.info("Machinename field is not editable");
            takeScreenshot("Machinename");
        }
    }

    public void editdivisionname() {
        String divisionName = prop.getProperty("divisionname");
        scrollToWebelement(By.cssSelector("input#divisionname"), "editdivision");
        enter(By.cssSelector("input#divisionname"), divisionName, "Edit divisionname", 10);
        String divisionnamee = getAtribute(By.cssSelector("input#divisionname"), "value", 10);
        if (divisionName.equals(divisionnamee)) {
            getTest().log(LogStatus.PASS, "Divisionname field is editable and able change as " + divisionName);
            logger.info("Divisionname field is editable and able change as " + divisionName);
        } else {
            getTest().log(LogStatus.FAIL, "Divisionname field is not editable");
            logger.info("Divisionname field is not editable");
            takeScreenshot("Divisionname");
        }
    }


    public void editStatusdrpdown() {
        selectValueWithText(By.xpath("//div[@id='UN_PopUps']//select[@id='StatusId']"), "Inactive", "Select Status", 10);
    }

    public void nextCalibrationdisabledfield() {
        driver.findElement(By.cssSelector("input#CalibrationDate")).getAttribute("readonly");
        if (true) {
            getTest().log(LogStatus.PASS, "Next Calibration disabled field is  Disabled");
            logger.info("Next Calibration disabled field is  Disabled");
        } else {
            getTest().log(LogStatus.FAIL, "Next Calibration disabled field is not  Disabled");
            logger.info("Next Calibration disabled field is  not Disabled");
            takeScreenshot("NextCalibration");
        }
    }

    public void nextimagedisabledfield() {
        driver.findElement(By.cssSelector("#ImageDate")).getAttribute("readonly");
        if (true) {
            getTest().log(LogStatus.PASS, "Next image disabled field is  Disabled");
            logger.info("Next image disabled field is  Disabled");
        } else {
            getTest().log(LogStatus.FAIL, "Next image disabled field is not  Disabled");
            logger.info("Next image disabled field is  not Disabled");
            takeScreenshot("Nextimage");
        }
    }

    public void editRFIDdisabledfield() {
        driver.findElement(By.cssSelector("#RFID")).getAttribute("readonly");
        if (true) {
            getTest().log(LogStatus.PASS, "Edit RFID field is  Disabled");
            logger.info("Edit RFID field is  Disabled");
        } else {
            getTest().log(LogStatus.FAIL, "Edit RFID field is not  Disabled");
            logger.info("Edit RFID field is  not Disabled");
            takeScreenshot("EditRFID");
        }
    }

    public void laptopCarryingBagcheckbox() {
        clickByJavascript(By.xpath("//label[contains(@class,'custom-control-label') and @for='laptopcarrying_bag']"), "laptop bag check box", 10);
    }

    public void editsave() {
        click(By.cssSelector("a#ancSaveRelatedInfo"), "downloadBarImage", 10);
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
            takeScreenshot("GPS");
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
        click(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td//i[@title='Download Barcode']"), "downloadBarImage", 20);
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
            takeScreenshot("Downloaded");
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
            takeScreenshot("Calibration");
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
        WebElement element = findElementPresence(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[12]//a[@class='table-head-btn viewcomment float-right']"), 30);
        if (element != null) {
            clickByJavascript(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[12]//a[@class='table-head-btn viewcomment float-right']"), "clickauditComment", 10);
        } else {
            getTest().log(LogStatus.FAIL, "Edit Audit Comment button is not present");
            logger.info("Edit Audit Comment button is not present");
            takeScreenshot("AuditComment");
        }
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
            takeScreenshot("Calibration");
        }
    }

    public void clickProductpopupPage() {
        String alertMssg = getText(By.xpath("//div[@role='alert']"), 15);
        if (alertMssg.equals("Related Information has been successfully updated.")) {
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
        scrollDown();
        scrollToWebelement(By.xpath("//a//i[@id='istatus']"), "edit status");
        scrollUpDown("up");
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
                takeScreenshot("Inactive");
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
                    takeScreenshot("SuccessMessgae");
                }
            } else {
                getTest().log(LogStatus.FAIL, "Confirmation Popup is not displayed");
                logger.info("Confirmation Popup is not displayed");
                takeScreenshot("ConfirmationPopup");
            }
            scrollToWebelement(By.xpath("//table[@id='tblRelatedInfoListing']//th[@id='th-STATUS']"), "Status Header");
            String changedStatus = getText(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[@class='actinact single-action']//span"), 20);
            if (changedStatus.equals("Active")) {
                getTest().log(LogStatus.PASS, "Inactive status is changed to Active status as expected");
                logger.info("Inactive status is changed to Active status as expected");
            } else {
                getTest().log(LogStatus.FAIL, "Inactive status is  not changed to Active status as expected");
                logger.info("Inactive status is not changed to Active status as expected");
                takeScreenshot("Inactivestatus");
            }
        }
    }

    public void changeStatus() {
        waitForVisibilityOfElement(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[@class='actinact single-action']//span"), 20);
        String selectedValue = getText(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td[@class='actinact single-action']//span"), 15);
        click(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td//a[contains(@class,'UpdateItemStatus')]//i"), "Edit status", 40);
        click(By.xpath("//table[@id='tblRelatedInfoListing']//tbody//tr[1]//td//select[@id='ddlchangeitemsatats']"), "select DD", 10);
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
                takeScreenshot("SuccessMessgae");
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
                takeScreenshot(expected[k]);
            }
            k = k + 1;

        }
    }

    public void viewHistoryValidations() {
        scroll();
        String parentHandle = driver.getWindowHandle();
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
        String text = getText(By.cssSelector("div>b.font-weight-medium"), 30);
        if (text.equals("Product:")) {
            getTest().log(LogStatus.PASS, "Product Information  Page is  Displayed");
            logger.info("Product Information  Page is  Displayed");
        } else {
            getTest().log(LogStatus.FAIL, "Product Information  Page is  Displayed");
            logger.info("Product Information  Page is not  Displayed");
            takeScreenshot("ProductInformation");
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
            for (Object expected : element) {
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
                    takeScreenshot(expected.toString());
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
            takeScreenshot("PendingCheckOut");
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
            for (Object expected : element) {
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
                    logger.info("The " + expected + " Header is not displayed in the Related information page");
                    takeScreenshot(expected.toString());
                }
            }
        }
    }
}
