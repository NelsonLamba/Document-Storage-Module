package utils;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.lang.reflect.Method;

import java.io.*;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static reporting.ComplexReportFactory.getTest;

public class WebBasePage extends WaitStatement {

    private WebDriver driver;
    public static Logger logger;
    private String pageName;

    public WebBasePage(WebDriver driver, String pageName) {
        super(driver);
        this.driver = driver;
        this.pageName = pageName;
        logger = Logger.getLogger(pageName);
    }

    public void open(String url) {

        driver.get(url);
        getTest().log(LogStatus.PASS, "Url opened - " + url);
    }
    public List<WebElement> findMultipleElement(By by, int time) {
        WebElement element = findElementVisibility(by, time);
        List<WebElement> elements=new ArrayList<>();
        if (element != null) {
            waitForVisibilityOfElement(by, time);
            elements = driver.findElements(by);
            return elements;
        } else {
            getTest().log(LogStatus.FAIL, "Element not found : " + by);
            logger.info("Element not found : " + by);
            takeScreenshot(new Object() {}.getClass().getEnclosingMethod().getName());
            Assert.fail("Element not found : " + by);
            return elements;
        }
    }

    public void wairForLoader(int time) {
        WebElement element = findElementVisibility(By.cssSelector(".lds-ring"), time);
        if (element != null) {
            waitForInVisibilityOfElement(By.cssSelector(".lds-ring"), time);
        }
    }

    public void enter(By by, String value, String name, int time) {
        WebElement element = findElementVisibility(by, time);
        staticWait(200);
        if (element != null) {
            try {
                element.clear();
                element.sendKeys(value);
                getTest().log(LogStatus.PASS, name + " entered with value - " + value);
                logger.info(name + " entered with value - " + value);
            } catch (Exception e) {
                getTest().log(LogStatus.FAIL, pageName + name + " not entered with value - " + value+ "error exist - "+e);
                logger.info(name + " not entered with value - " + value);
                takeScreenshot(new Object() {}.getClass().getEnclosingMethod().getName());
                Assert.fail(name + " -  element not present");
            }
        } else {
            getTest().log(LogStatus.FAIL, pageName + name + " not entered with value - " + value);
            logger.info(name + " not entered with value - " + value);
            takeScreenshot(new Object() {}.getClass().getEnclosingMethod().getName());
            Assert.fail(name + " -  element not present");
        }
    }

    public void click(By by, String name, int time) {
        WebElement element = findElementVisibility(by, time);
        staticWait(200);
        if (element != null) {
            element.click();
            getTest().log(LogStatus.PASS, name + " clicked");
            logger.info(name + " clicked ");
        } else {
            getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
            logger.info(name + " not clicked");
            takeScreenshot(new Object() {}.getClass().getEnclosingMethod().getName());
            Assert.fail(name + " -  element not present");
        }
    }

    public void selectValueWithIndex(By by, int value, String name, int time) {
        WebElement element = findElementVisibility(by, time);
        boolean elementEnabled = findElementVisibility(by, time).isEnabled();
        if (element != null && elementEnabled) {
            Select se = new Select(element);
            se.selectByIndex(value);
            getTest().log(LogStatus.PASS, name + " selected with index - " + value);
            logger.info(name + " selected with value - " + value);
        } else {
            getTest().log(LogStatus.FAIL, name + " not selected with index - " + value);
            logger.info(name + " not selected with value - " + value);
            takeScreenshot(new Object() {}.getClass().getEnclosingMethod().getName());
            Assert.fail(name + " -  element not present");
        }
    }

    public void selectValueWithValue(By by, String value, String name, int time) {
        WebElement element = findElementVisibility(by, time);
        if (element != null) {
            Select se = new Select(element);
            se.selectByValue(value);
            getTest().log(LogStatus.PASS, name + " selected with value - " + value);
            logger.info(name + " selected with value - " + value);
        } else {
            getTest().log(LogStatus.FAIL, name + " not selected with value - " + value);
            logger.info(name + " not selected with value - " + value);
            takeScreenshot(new Object() {}.getClass().getEnclosingMethod().getName());
            Assert.fail(name + " -  element not present");
        }
    }

    public void selectValueWithText(By by, String value, String name, int time) {
        staticWait(200);
        WebElement element = findElementVisibility(by, time);
        if (element != null) {
            Select se = new Select(element);
            se.selectByVisibleText(value);
            getTest().log(LogStatus.PASS, name + " selected with value - " + value);
            logger.info(name + " selected with value - " + value);
        } else {
            getTest().log(LogStatus.FAIL, name + " not selected with value - " + value);
            logger.info(name + " not selected with value - " + value);
            takeScreenshot(new Object() {}.getClass().getEnclosingMethod().getName());
            Assert.fail(name + " -  element not present");
        }
    }

    public void scrollDown() {
        staticWait(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        logger.info("Page scroll down");
        staticWait(2000);
    }

    public void staticWait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void scrollToWebelement(By by, String name) {
        staticWait(500);
        WebElement element = driver.findElement(by);
        if (element != null) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getTest().log(LogStatus.PASS, "Scroll to this element - " + name);
            logger.info("Scroll to this element - " + name);
            staticWait(500);
        } else {
            getTest().log(LogStatus.PASS, name + " element is not found to scroll");
            logger.info(name + " element is not found to scroll");
            takeScreenshot(new Object() {}.getClass().getEnclosingMethod().getName());
            Assert.fail(name + " element is not found to scroll");
        }
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickByJavascript(By by, String name, int time) {
        staticWait(2000);
        WebElement element = driver.findElement(by);
        if (element != null) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            getTest().log(LogStatus.PASS, name + " click by JS");
            logger.info(name + " click by JS");
        } else {
            getTest().log(LogStatus.FAIL, "Not able to Locate " + name);
            logger.info("Not able to Locate " + name);
            takeScreenshot("NotClickByJS");
            Assert.fail("Not able to Locate " + name);
        }

    }


    public String getText(By by, int time) {
        WebElement ele = findElementVisibility(by, time);
        if (ele != null) {
            String getText = ele.getText();
            getTest().log(LogStatus.PASS, " Text displayed is  - " + getText);
            logger.info(" Text displayed is  - " + getText);
            return getText;
        } else {
            getTest().log(LogStatus.FAIL, "Element not found "+by);
            logger.info("Element not found "+by);
            Assert.fail("Element not found to get text");
            return null;
        }
    }

    public String getAtribute(By by, String tag, int time) {
        WebElement ele = findElementVisibility(by, time);
        String getText;
        try {
            getText = ele.getAttribute(tag);
            logger.info(" get attribute value is  - " + getText);
            return getText;
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, "Element not found : " + by);
            logger.info("Element not found : " + by);
            Assert.fail("Element not found : " + by);
            return null;
        }
    }

    public void waitForLoad(int timeoutSec) {
        try {
            new WebDriverWait(driver, timeoutSec).until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void hover(By by, String name, int time) {
        WebElement ele = findElementVisibility(by, time);
        if (ele != null) {
            Actions action = new Actions(driver);
            action.moveToElement(ele).perform();
        } else {
            getTest().log(LogStatus.FAIL, "Hover not performed");
            takeScreenshot("HoverNotPerformed");
            Assert.fail("Hover not performed");
        }

    }

    public void scrollUpDown(String scroll) {
        Actions actions = new Actions(driver);
        if (scroll.equalsIgnoreCase("down")) {
            actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        } else if (scroll.equalsIgnoreCase("up")) {
            actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
        }

    }

    public boolean switchToTab(int tabPosition) {
        boolean tabFound = false;
        Set<String> allWindowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
        if (tabs.size() > 0) {
            try {
                driver.switchTo().window(tabs.get(tabPosition));
            } catch (Exception e) {
                getTest().log(LogStatus.FAIL, "Error in opening new tab");
                takeScreenshot("ErrorInOpenWindow");
                return false;
            }
            tabFound = true;
        }
        if (!tabFound) {
            getTest().log(LogStatus.FAIL, " There are no new tabs");
            takeScreenshot(new Object() {}.getClass().getEnclosingMethod().getName());
        }

        return tabFound;

    }

    public void closeCurrentTab(int currentTabIndex) {
        try {
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
            driver.switchTo().window(tabs.get(currentTabIndex));
            driver.close();
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, "Not able to close current tab");
            logger.info("Not able to close  current tab");
            takeScreenshot(new Object() {}.getClass().getEnclosingMethod().getName());
            Assert.fail("Not able to close current tab");
        }
    }

    public void switchToParentTab() {
        try {
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
            driver.switchTo().window(tabs.get(0));
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, "Not able to switch to parent tab");
            logger.info("Not able to switch to parent tab");
            takeScreenshot(new Object() {}.getClass().getEnclosingMethod().getName());
            Assert.fail("Not able to switch to parent tab");
        }
    }

    public void takeScreenshot(String name) {
        String imagePath = System.getProperty("user.dir") + "\\reports\\" +name+"_"+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            org.apache.commons.io.FileUtils.copyFile(scrFile, new File(imagePath + ".png"));
            System.out.println(imagePath + ".png");
        } catch (Exception e) {
            Assert.fail("Error while taking screenshot - " + e);
        }
        getTest().log(LogStatus.INFO, getTest().addScreenCapture(imagePath + ".png"));
    }

    public int countNumberOfFilesInFolder(String path) {
        return Objects.requireNonNull(new File(path).list()).length;
    }

    public void waitTillNewFile(String path, int previousFileCount) {
        staticWait(3000);
        int timeCount = 1;
        for (timeCount = 1; timeCount < 20; timeCount++) {
            if (countNumberOfFilesInFolder(path) > previousFileCount) {
                getTest().log(LogStatus.PASS, "PDF downloaded...");
                break;
            }
            staticWait(500);
            System.out.println("countNumberOfFilesInFolder(path) - " + countNumberOfFilesInFolder(path) + " previousFileCount - " + previousFileCount);
            logger.info("countNumberOfFilesInFolder(path) - " + countNumberOfFilesInFolder(path) + " previousFileCount - " + previousFileCount);
        }

    }

    public void uploadDoc(By by, String value, String name, int time) {
        WebElement element = findElementVisibility(by, time);
        staticWait(500);
        if (element != null) {
            element.sendKeys(value);
            getTest().log(LogStatus.PASS, name + " uploaded with value - " + value);
            logger.info(name + " uploaded with value - " + value);
        } else {
            getTest().log(LogStatus.FAIL, pageName + name + " not uploaded with value - " + value);
            logger.info(name + " not uploaded with path - " + value);
            takeScreenshot(new Object() {}.getClass().getEnclosingMethod().getName());
            Assert.fail(name + " -  element not present");
        }
    }

}

