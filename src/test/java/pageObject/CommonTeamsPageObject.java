package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import util.LoggerManager;

import java.util.List;

/**
 *
 * This  CommonTeamsPageObject Class helps to store page locators and methods .
 *
 * @author Swarnaprabha Ghosh
 */

public class CommonTeamsPageObject extends PageFactoryInitializer {
    @FindBy(how= How.XPATH,using = "//img[@alt='NBA Logo']")
    public WebElement nbaHomePageLogo;

    @FindBy(how= How.XPATH,using = "//li[@class='menu-item']/a/span[contains(text(),'Schedule')]")
    public WebElement scheduleTab;

    @FindBy(how= How.XPATH,using = "//li[@class='menu-item']/a/span[contains(text(),'Team')]")
    public WebElement team;




    public HomePageObject clickHomeButtonAndSwitchToOpenTab(){
        try {
            Thread.sleep(1000);
            Assert.assertTrue(nbaHomePageLogo.isDisplayed());
            javaScriptExecutorClick(nbaHomePageLogo);
            Thread.sleep(1000);
            closeCurrentTab();
            switchToTab();
        }
        catch (Exception ex){
            LoggerManager.error(ex.getMessage());
        }
        return new HomePageObject();
    }

    public CommonTeamsPageObject validateOtherTeamsNameinSchedulePage(String teams) {
        try {
            Thread.sleep(1000);
            Assert.assertTrue(nbaHomePageLogo.isDisplayed());
            javaScriptExecutorClick(scheduleTab);
            Thread.sleep(1000);
            Assert.assertNotNull(getUrlTitle());

        } catch (Exception ex) {
            LoggerManager.error(ex.getMessage());
        }
        return this;
    }
    public CommonTeamsPageObject validateTeamTab() {
        Assert.assertTrue(team.isDisplayed());
        return this;
    }



}
