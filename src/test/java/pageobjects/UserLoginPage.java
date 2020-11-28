package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebBasePage;

public class UserLoginPage extends WebBasePage
{

    WebDriver driver;
    By locUserName = By.cssSelector("input#username");
    public UserLoginPage(WebDriver driver)
    {
        super(driver,"");
        this.driver=driver;
    }
    public static String UserName="safiya@yopmail.com";
    public static String Password="talygen@123";

    public void enterUserName()
    {
        enter(By.cssSelector("input#username"),UserName,"User Name",15);
    }
    public void enterPassword()
    {
        enter(By.cssSelector("input#password"),Password,"Password",10);
    }
    public void acceptPrivacyPolicy()
    {
        click(By.xpath("(//div[contains(@class,'custom-checkbox')])[1]"),"Privacy Policy",10);
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
        }else {
            clickByJavascript(By.id("navbarDropdownMenuLink"), "Logout menu", 10);
            clickByJavascript(By.xpath("//a[@data-original-title='Logout']"), "Logout", 10);
            enterUserName();
            enterPassword();
            acceptPrivacyPolicy();
            clickLogin();
        }
    }

}
