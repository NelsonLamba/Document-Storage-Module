package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitStatement {

    WebDriver driver;
    public WaitStatement(WebDriver driver){
        this.driver=driver;
    }

    public WebElement findElementVisibility(final By by,int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);
        try {

            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            System.out.println();
            return null;
        }

    }

    public WebElement findElementClickable(final By by,int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            wait.until((ExpectedCondition<Boolean>) _webDriver -> (_webDriver.findElement(by) != null));
        } catch (Exception e) {
            System.out.println();
            return null;
        }
        return driver.findElement(by);

    }
    public WebElement findElementPresence(final By by,int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);

        try {

            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            wait.until((ExpectedCondition<Boolean>) _webDriver -> (_webDriver.findElement(by) != null));
        } catch (Exception e) {
            System.out.println();
            return null;
        }
        return driver.findElement(by);

    }

    public WebElement findElementsVisibility(final By by) {

        List<WebElement> webElements = driver.findElements(by);
        for(WebElement ele : webElements){
            try {
                if(ele.isDisplayed()){
                    return ele;
                }
            } catch (Exception e) {
                System.out.println();
                return null;
            }

        }


        return null;
    }

    public WebElement findElementsPresence(final By by,int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);
        List<WebElement> webElements = driver.findElements(by);
        for(WebElement ele : webElements){
            try {
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
                wait.until((ExpectedCondition<Boolean>) _webDriver -> (ele != null));
                return ele;
            } catch (Exception e) {
                System.out.println();
                return null;
            }
        }

        return driver.findElement(by);

    }

    public WebElement waitForInVisibilityOfElement(final By by,int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);
        try {

            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
        } catch (Exception e) {
            System.out.println();
            return null;
        }
        return driver.findElement(by);

    }
    public WebElement waitForVisibilityOfElement(final By by,int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);
        try {

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        } catch (Exception e) {
            System.out.println();
            return null;
        }
        return driver.findElement(by);

    }

    public boolean findElementsVisibilityByClick(final By by) {

        List<WebElement> webElements = driver.findElements(by);
        for(WebElement ele : webElements){
            try {
                if(ele.isDisplayed()){
                    ele.click();
                    return false;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        return true;
    }

}
