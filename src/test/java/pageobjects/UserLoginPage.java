package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertiesLoader;
import utils.WebBasePage;

import java.util.Properties;

public class UserLoginPage extends WebBasePage
{
    WebDriver driver;
    By locUserName = By.cssSelector("input#username");
    private final static String FILE_NAME = System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties";
    private static Properties prop = new PropertiesLoader(FILE_NAME).load();

    public UserLoginPage(WebDriver driver)
    {
        super(driver,"User Login Page");
        this.driver=driver;
    }
    public static String userName;
    public static String password;

    public void enterUserName()
    {
        if(System.getProperty("username")==null){
            userName = prop.getProperty("username");
        }else{
            userName = System.getProperty("username");
        }
        waitForVisibilityOfElement(By.cssSelector("input#username"),20);
        enter(By.cssSelector("input#username"),userName,"User Name",15);
    }
    public void enterPassword()
    {
        if(System.getProperty("password")==null){
            password = prop.getProperty("password");
        }else{
            password = System.getProperty("password");
        }
        enter(By.cssSelector("input#password"),password,"Password",10);
    }
    public void acceptPrivacyPolicy()
    {
        click(By.xpath("//input[@name='AcceptPrivacyPolicy']//parent::div[contains(@class,'custom')]"),"Privacy Policy",10);
    }
    public void clickLogin()
    {
        click(By.cssSelector("input#btnLogin"),"Login",10);
    }

    public void forcefulLogOutLogin(){
        if(findElementVisibility(locUserName, 10)!=null){
            enterUserName();
            enterPassword();
            acceptPrivacyPolicy();
            clickLogin();
        }else
            {
            clickByJavascript(By.id("navbarDropdownMenuLink"), "Logout menu", 10);
            clickByJavascript(By.xpath("//a[@data-original-title='Logout']"), "Logout", 10);
            enterUserName();
            enterPassword();
            acceptPrivacyPolicy();
            clickLogin();
        }
    }

}
