package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
/**
 *
 * This  class Handles all browser details and configurations.
 *
 * @author Swarnaprabha Ghosh
 */

public class BrowserUtil extends TestConfigReader {
    static WebDriver driver;

    static WebDriver createDriver() {

        switch (Browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
                WebDriverManager.chromedriver().clearDriverCache().clearResolutionCache().setup();
                driver = new ChromeDriver(options);
                break;

            case "chrome-headless":
                ChromeOptions options1 = new ChromeOptions();
                options1.addArguments("--remote-allow-origins=*");
                options1.addArguments("--headless");
                options1.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
                WebDriverManager.chromedriver().clearDriverCache().clearResolutionCache().setup();
                driver = new ChromeDriver(options1);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                WebDriverManager.firefoxdriver().clearResolutionCache().setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().clearResolutionCache().setup();
                driver = new EdgeDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            default:
                throw new NotFoundException("Not Eligible browser Found ");
        }

        if (ImplicitlyWait > 0) {
            implicitlyWait(ImplicitlyWait);
        }

        if (MaxPageLoadTime > 0) {
            setMaxPageLoadTime(MaxPageLoadTime);
        }

        driver.manage().window().maximize();
        driver.get(appConfig.getWebsiteUrl());
        return driver;
    }

    public static void implicitlyWait(long timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

    public static void setMaxPageLoadTime(long timeInSeconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeInSeconds));
    }
}
