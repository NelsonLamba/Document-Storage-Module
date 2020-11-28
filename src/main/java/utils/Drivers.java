package utils;

import com.browserstack.local.Local;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Drivers {

    public WebDriver driver;
    //    private static final String USERNAME = "joshuadavid1";
//    private static final String AUTOMATE_KEY = "LHWVX9K38rcLakHomikW";
    private static final String USERNAME = "dineshtets1";
    private static final String AUTOMATE_KEY = "PB6q7ecbHdPEy93k91NX";
    private static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public WebDriver getWebDriver(String browser) throws MalformedURLException {

        if (browser.equals("firefox")) {

            String downloadFilepath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadedFiles\\";
            String firefoxDownloadDir = System.getProperty("user.dir") + "\\geckodriver.exe";
            FirefoxOptions options = new FirefoxOptions();
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.download.folderList", 2); //Use for the default download directory the last folder specified for a download
            profile.setPreference("browser.download.dir", downloadFilepath); //Set the last directory used for saving a file from the "What should (browser) do with this file?" dialog.
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf, application/octet-stream, application/x-winzip, application/x-pdf, application/x-gzip, application/zip"); //list of MIME types to save to disk without asking what to use to open the file
            profile.setPreference("browser.helperApps.neverAsk.openFile", "application/pdf, application/octet-stream, application/x-winzip, application/x-pdf, application/x-gzip, application/zip");
            options.setProfile(profile);
            System.setProperty("webdriver.gecko.driver", firefoxDownloadDir);

            driver = new FirefoxDriver(options);
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        } else if (browser.equals("chrome")) {

            String downloadFilepath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadedFiles\\";
            String chromeDownloadDir = System.getProperty("user.dir") + "\\chromedriver.exe";

            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            chromePrefs.put("download.prompt_for_download", false);


            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--disable-extensions");


            System.setProperty("webdriver.chrome.driver", chromeDownloadDir);
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }

        return driver;
    }

    /*public WebDriver getBrowserStackDriver(String browser) throws MalformedURLException {

        String downloadFilepath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadedFiles\\";

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        DesiredCapabilities caps = new DesiredCapabilities(options);
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", browser);
        caps.setCapability("browser_version", "84");
        caps.setCapability("name", "joshuadavid1's First Test");
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        return driver;
    }*/

    /*public WebDriver getMobileBrowserStackDriver(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("os_version", "11");
//        caps.setCapability("device", "iPhone 8 Plus");
        caps.setCapability("os_version", "10.0");
        caps.setCapability("device", "Samsung Galaxy S20");
        caps.setCapability("real_mobile", "true");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("name", "joshuadavid1's First Test");
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("app.talygen.com");

        return driver;


    }*/

}
