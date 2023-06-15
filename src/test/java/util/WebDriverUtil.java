package util;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 *
 * This test class works as WebDriver setup TearDown Methods .
 *
 * @author Swarnaprabha Ghosh
 */

public class WebDriverUtil extends BrowserUtil {
    public static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
    public static String browser;
    public static String url;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        LoggerManager.info("Browser: " + Browser);
        LoggerManager.info("WebsiteURL: " + WebsiteURL);
        new WebDriverUtil();
        WebDriver driver = WebDriverUtil.createDriver();
        setWebDriver(driver);
    }

    public void setWebDriver(WebDriver driver) {
        webdriver.set(driver);
    }

    public static WebDriver getWebDriver() {
        return webdriver.get();
    }

    public static void saveFullPageScreenshot(String name) throws  IOException {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(getWebDriver());
        ImageIO.write(screenshot.getImage(), "PNG", new File(name));
    }

    @AfterMethod(alwaysRun = true, enabled = true)
    public void afterMethod(ITestResult result) throws Exception {
        Thread.sleep(2000);
        if (result.getStatus() == ITestResult.FAILURE) {
            saveFullPageScreenshot("src/test/resources/ScreenshotsFailedTestCase" + result.getTestClass().getName() + "."
                    + result.getMethod().getMethodName() + ".png");
        }
        getWebDriver().quit();
    }
}
