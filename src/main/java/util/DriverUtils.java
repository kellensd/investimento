package util;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public class DriverUtils {

    public static WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
        return new FirefoxDriver();
    }

    public static WebDriver getFirefoxDriver(String profileName)	{
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile firefoxSeleniumProfile = profile.getProfile(profileName);
        return new FirefoxDriver(firefoxSeleniumProfile);
    }

    public static WebDriver getInternetExplorerDriver() {
        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\driver\\IEDriverServer.exe");
        return new InternetExplorerDriver();
    }

    public static WebDriver getChromeDriver() {
        String executable = SystemUtils.IS_OS_LINUX ? "chromedriver" : "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separatorChar + "driver" + File.separatorChar + executable);
        return new ChromeDriver();
    }

    public static WebDriver getHeadlessChromeDriver() {
        String executable = SystemUtils.IS_OS_LINUX ? "chromedriver" : "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separatorChar + "driver" + File.separatorChar + executable);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        return new ChromeDriver(options);
    }
}
