package pageObject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import testData.TestDataManager;
import util.LoggerManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * This  HomePageObject Class helps to store page locators and methods .
 *
 * @author Swarnaprabha Ghosh
 */

public class HomePageObject extends PageFactoryInitializer {


    @FindBy(how= How.XPATH,using = "//img[@alt='NBA Logo']")
    public WebElement application;

    @FindBy(how= How.XPATH,using = "//div[@class='w-full flex flex-end']/div")
    public WebElement closeButtonFlex;

    @FindBy(how= How.XPATH,using = "//*[contains(@id,\"usabilla_live_button_container_iframe\")]")
    public WebElement feedbackButton;

    @FindBy(how= How.XPATH,using = "//*[@id=\"nba-nav\"]/nav/div/ul/li[1]/button")
    public WebElement teamsButton;

    @FindBy(how= How.XPATH,using = "//div[@id=\"contents\"]/child::div/h4")
    public List<WebElement> feedbackFrameSections;

    @FindBy(how= How.XPATH,using = "//*[@id='teams']/div/ul/li/a")
    public List<WebElement> teamsList;

    @FindBy(how= How.XPATH,using = "//div[contains(@class,'team')]/ul/li/a")
    public List<WebElement> teamsListHomePage;

    @FindBy(how= How.XPATH,using = "//*[@title='Teams']")
    public WebElement teamsButtonHomePage;



    public HomePageObject diplayValidation(){
        try {
            Assert.assertEquals(getUrlTitle(), "NBA.com India | The official site of the NBA", "HomePage Title is mismatching");
        }
        catch (Exception ex){
            LoggerManager.error(ex.getMessage());
        }
        return this;
    }

    public HomePageObject fetchTeamNamesFromDropDown() {
        try {
            List<String> tempList = new ArrayList<>();
            mouseHover(teamsButtonHomePage);
            Thread.sleep(2000);
            Assert.assertEquals(teamsListHomePage.size(), 30, "Teams Dropdown in homepage does not contain right set of teams");
            for (WebElement element:teamsListHomePage){
                tempList.add(element.getText());
            }
            Assert.assertEquals(tempList, TestDataManager.getDropdownTeamsName(),"Teams List is mismatched");

        }
        catch (Exception ex){
            Assert.fail(ex.getMessage());
            LoggerManager.error(ex.getMessage());
        }


        return this;
    }


    public HomePageObject validateEachTeamsHomePageTitle(String teamName,String pageTitle)  {
        try {
            mouseHover(teamsButtonHomePage);
            for (WebElement element:teamsListHomePage){
                if(element.getText().equalsIgnoreCase(teamName)){
                    moveToElementClick(element);
                    switchToTab();
                    Assert.assertEquals(getUrlTitle(),pageTitle);
                    break;
                }

            }

        }
        catch (Exception ex){
            Assert.fail(ex.getMessage());
            LoggerManager.error(ex.getMessage());
        }

        return this;
    }



}
