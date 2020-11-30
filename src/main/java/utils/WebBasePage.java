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

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static reporting.ComplexReportFactory.getTest;

public class WebBasePage extends WaitStatement{

    private WebDriver driver;
    public static Logger logger;
    private String pageName;
    public WebBasePage(WebDriver driver,String pageName){
        super(driver);
        this.driver=driver;
        this.pageName = pageName;
        logger = Logger.getLogger(pageName);
    }

    public void deleteAllCookies(){
        driver.manage().deleteAllCookies();
    }

    public void open(String url){

        driver.get(url);
        getTest().log(LogStatus.PASS,"Url opened - "+url);
    }
    public List<WebElement> findMultipleElement(By by){
        List<WebElement> elements = driver.findElements(by);
        return elements;
    }
    public String NameGenerator()
    {
        String givenName = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String today=dtf.format(now);
        String []name=today.split("");

        String[] names = new String[10];
        for (int i = 0; i < name.length; i++)
        {
            switch (name[i])
            {
                case "0": names[i] = "A"; break;
                case "1": names[i] = "B"; break;
                case "2": names[i] = "C"; break;
                case "3": names[i] = "D"; break;
                case "4": names[i] = "F"; break;
                case "5": names[i] = "G"; break;
                case "6": names[i] = "H"; break;
                case "7": names[i] = "J"; break;
                case "8": names[i] = "K"; break;
                case "9": names[i] = "L"; break;
                default: names[i] = "Z"; break;
            }
        }
        givenName = String.join("", names);
        return givenName;

    }
    public void sleep(int time)
    {
        try{
            Thread.sleep(time);
        }catch(Exception e)
        {

        }
    }
    public void enter(By by,String value,String name,int time){
        WebElement element=findElementVisibility(by,time);
        staticWait(500);
        if(element!=null){
            element.clear();
            element.sendKeys(value);
            getTest().log(LogStatus.PASS,name+" entered with value - "+value);
            logger.info(name+" entered with value - "+value);
        }else{
            getTest().log(LogStatus.FAIL,pageName+name+" not entered with value - "+value);
            logger.info(name+" not entered with value - "+value);
            Assert.fail(name+" -  element not present");
        }
    }

     public void click(By by,String name,int time) {
         WebElement element = findElementVisibility(by, time);
         staticWait(500);
         if (element != null) {
             element.click();
             getTest().log(LogStatus.PASS, name + " clicked");
             logger.info(name + " clicked ");
         } else {
             getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
             logger.info(name + " not clicked");
             Assert.fail(name + " -  element not present");
         }
     }
    public void clickWithOutAssert(By by,String name,int time) {
        WebElement element = findElementVisibility(by, time);
        if (element != null) {
            try {
                element.click();
                getTest().log(LogStatus.PASS, name + " clicked");
                logger.info(name + " clicked ");
            } catch (Exception e) {
                getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
                logger.info(name + " not clicked");
            }
        } else {
            getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
            logger.info(name + " not clicked");
        }
    }
    public void browserBack() {
        driver.navigate().back();
    }

    public void verifyPageHasErrors(String pagename){
        if(driver.getPageSource().toLowerCase().contains("error")){
            getTest().log(LogStatus.FAIL," Page has errors");
        }
    }

    public void getPageSourceAndVerify(String value){
        if(driver.getPageSource().contains(value)){
            getTest().log(LogStatus.PASS,value+" present");
            logger.info(value+" present");
        }else{
            logger.info(value+" not present");
            Assert.fail(value+" not present");
        }
    }

    public void verifyElement(By by,String name,int time){
        WebElement element=findElementVisibility(by,time);
        if(element!=null){
            getTest().log(LogStatus.PASS,name+" element visible");
            logger.info(name+" element visible");
        }else{
            getTest().log(LogStatus.FAIL,name+" element not visible");
            logger.info(name+" element not visible");
            Assert.fail(name+" -  element not present");
        }
    }

    public void selectValueWithIndex(By by,int value,String name,int time){
        WebElement element=findElementVisibility(by,time);
        if(element!=null){
            Select se=new Select(element);
            se.selectByIndex(value);
            getTest().log(LogStatus.PASS,name+" selected with index - "+value);
            logger.info(name+" selected with value - "+value);
        }else{
            getTest().log(LogStatus.FAIL,name+" not selected with index - "+value);
            logger.info(name+" not selected with value - "+value);
            Assert.fail(name+" -  element not present");
        }
    }

    public void selectValueWithValue(By by,String value,String name,int time){
        WebElement element=findElementVisibility(by,time);
        if(element!=null){
            Select se=new Select(element);
            se.selectByValue(value);
            getTest().log(LogStatus.PASS,name+" selected with value - "+value);
            logger.info(name+" selected with value - "+value);
        }else{
            getTest().log(LogStatus.FAIL,name+" not selected with value - "+value);
            logger.info(name+" not selected with value - "+value);
            Assert.fail(name+" -  element not present");
        }
    }

    public void selectValueWithText(By by,String value,String name,int time){
        staticWait(200);
        WebElement element=findElementPresence(by,time);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        staticWait(200);
        if(element!=null){
            Select se=new Select(element);
            se.selectByVisibleText(value);
            getTest().log(LogStatus.PASS,name+" selected with value - "+value);
            logger.info(name+" selected with value - "+value);
        }else{
            getTest().log(LogStatus.FAIL,name+" not selected with value - "+value);
            logger.info(name+" not selected with value - "+value);
            Assert.fail(name+" -  element not present");
        }
    }

    public void scrollDown(){
        staticWait(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        logger.info("Page scroll down");
        staticWait(2000);
    }

    public void staticWait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean waitForAttributeValue(By by,String tag, int timerCount){

        int count = 1;
        do{
            if (getAtribute(by,"src",3)!=null){
                staticWait(500);
                return true;
            }
            staticWait(500);
            count = count + 1;
        }while(count <= timerCount);
        return false;
    }
    public void scrollToWebelement(By by,String name){
        staticWait(500);
        WebElement element = driver.findElement(by);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
        getTest().log(LogStatus.PASS,"Scroll to this element - "+name);
        logger.info("Scroll to this element - "+name);
        staticWait(500);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public void clickByJavascript(By by,String name, int time){
        staticWait(2000);
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        getTest().log(LogStatus.PASS,name+" click by JS");
        logger.info(name+" click by JS");

    }

    public int getRowCount(By by,String name){
        int getCount = driver.findElements(by).size();
        getTest().log(LogStatus.PASS,name+" count of the element size - "+getCount);
        logger.info(name+" count of the element size - "+getCount);
        return getCount;
    }

    public String getText(By by,int time){
        WebElement ele = findElementVisibility(by,time);
        String getText = ele.getText();
        getTest().log(LogStatus.PASS," Text displayed is  - "+getText);
        logger.info(" Text displayed is  - "+getText);
        return getText;
    }

    public String getAtribute(By by,String tag , int time){
        WebElement ele = findElementPresence(by,time);
        String getText;
        try {
            getText = ele.getAttribute(tag);
            logger.info(" get attribute value is  - "+getText);
            return getText;
        } catch (Exception e) {
            //e.printStackTrace();
        }

        return null;
    }

    public void switchToContentFrame(){
        driver.switchTo().frame("ContentFrame");
    }

    public void waitForLoad(int timeoutSec)
    {
        try {
            new WebDriverWait(driver, timeoutSec).until((ExpectedCondition<Boolean>) wd ->
            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void hover(By by,String name, int time){
        WebElement ele = findElementVisibility(by,time);
        if(ele!=null){
            Actions action = new Actions(driver);
            action.moveToElement(ele).perform();
        }else{
            getTest().log(LogStatus.FAIL,"Hover not performed");
        }

    }

    public String getBackgroundColor(By by, int time){
        WebElement ele = findElementVisibility(by,time);
        String color = ele.getCssValue("background-color");
        return Color.fromString(color).asHex();
    }

    public String getForegroundColor(By by, int time){
        WebElement ele = findElementVisibility(by,time);
        String color = ele.getCssValue("color");
        return Color.fromString(color).asHex();
    }

    public int getHeight(By by, int time){
        WebElement ele = findElementsVisibility(by);
        return ele.getSize().getHeight();
    }

    public int getWidth(By by, int time){
        WebElement ele = findElementsVisibility(by);
        return ele.getSize().getWidth();
    }

    public void scrollUpDown(String scroll){
        Actions actions = new Actions(driver);
        if(scroll.equalsIgnoreCase("down")){
            actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        }else if(scroll.equalsIgnoreCase("up")){
            actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
        }

    }

    public String getCssValue(By by,String attribute, int time){
        WebElement ele = findElementVisibility(by,time);
        String color = ele.getCssValue(attribute);
        return color;
    }

    public void clickByElements(By by,String name,int time) {
        WebElement element = findElementsVisibility(by);
        staticWait(500);
        if (element != null) {
            element.click();
            getTest().log(LogStatus.PASS, name + " clicked");
            logger.info(name + " clicked ");
        } else {
            getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
            logger.info(name + " not clicked");
            //Assert.fail(name + " -  element not present");
        }
    }

    public void clickByElementsPresence(By by,String name,int time) {
        WebElement element = findElementsPresence(by, time);
        staticWait(500);
        if (element != null) {
            element.click();
            getTest().log(LogStatus.PASS, name + " clicked");
            logger.info(name + " clicked ");
        } else {
            getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
            logger.info(name + " not clicked");
            Assert.fail(name + " -  element not present");
        }
    }

    public void pressKey(Keys keyname){
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(keyname);
        getTest().log(LogStatus.PASS, "Space bar is pressed");
    }

    public boolean switchToTab(int tabPosition){
        boolean tabFound = false;
        Set<String> allWindowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
        if(tabs.size()>0){
            try {
                driver.switchTo().window(tabs.get(tabPosition));
            } catch (Exception e) {
                getTest().log(LogStatus.FAIL,"Error in opening new tab");
                return false;
            }
            tabFound = true;
        }
        if(!tabFound)
            getTest().log(LogStatus.FAIL," There are no new tabs");

        return tabFound;

    }

    public void closeCurrentTab(int currentTabIndex){
        Set<String> allWindowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
        driver.switchTo().window(tabs.get(currentTabIndex));
        driver.close();
    }

    public void switchToParentTab(){
        Set<String> allWindowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
        driver.switchTo().window(tabs.get(0));
    }

    public void moveSlider(By by){

        WebElement slider = findElementsVisibility(by);
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(slider, 50, 0).build();
        action.perform();
    }

    public void takeScreenshot(String name){
        String imagePath=System.getProperty("user.dir")+"\\reports\\"+name+new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        // generate screenshot as a file object
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // copy file object to designated location
            org.apache.commons.io.FileUtils.copyFile(scrFile, new File(imagePath+".png"));
            System.out.println(imagePath+".png");
        }catch(Exception e){
            Assert.fail("Error while taking screenshot - "+e);
        }
        getTest().log(LogStatus.INFO, getTest().addScreenCapture(imagePath+".png"));
    }

    public int countNumberOfFilesInFolder(String path){
        return Objects.requireNonNull(new File(path).list()).length;
    }

    public void waitTillNewFile(String path, int previousFileCount){
        int timeCount = 1;
        for(timeCount =1;timeCount <20; timeCount++){
            if(countNumberOfFilesInFolder(path)>previousFileCount){
                getTest().log(LogStatus.PASS, "PDF downloaded...");
                break;
            }
            staticWait(500);
            System.out.println("countNumberOfFilesInFolder(path) - "+countNumberOfFilesInFolder(path)+" previousFileCount - "+previousFileCount);
        }

    }

    protected File getLatestFilefromDir(String dirPath){
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    protected void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if (!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to " + newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void uploadDoc(By by,String value,String name,int time){
        WebElement element=findElementVisibility(by,time);
        staticWait(500);
        if(element!=null){
            element.sendKeys(value);
            getTest().log(LogStatus.PASS,name+" uploaded with value - "+value);
            logger.info(name+" uploaded with value - "+value);
        }else{
            getTest().log(LogStatus.FAIL,pageName+name+" not uploaded with value - "+value);
            logger.info(name+" not uploaded with path - "+value);
            Assert.fail(name+" -  element not present");
        }
    }
}

