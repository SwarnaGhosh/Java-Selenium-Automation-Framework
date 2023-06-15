package tests;

import org.testng.annotations.Test;
import pageObject.PageFactoryInitializer;
import testData.TestDataManager;
import util.LoggerManager;



/**
 *
 * This  class consists test Methods.
 *
 * @author Swarnaprabha Ghosh
 */

public class TestCases extends PageFactoryInitializer {

    @Test(description = "This Tests validates homepage Title ")
    public void homePageTitleValidationTest() {

        getHomePage().diplayValidation();

    }

    @Test(description = "Teams name validation under Teams Dropdown in HomePage ")
    public void homePageTeamsNameDropDownValidationTest(){

        getHomePage().fetchTeamNamesFromDropDown();

    }

    @Test(dataProvider ="test-data",dataProviderClass = TestDataManager.class,description = "Teams page title validation when open from Homepage ")
    public void homePageToTeamsPageTitleValidation(String team,String pageTitle){

        getHomePage().validateEachTeamsHomePageTitle(team,pageTitle);

    }

    @Test(dataProvider ="test-data",dataProviderClass = TestDataManager.class,description = "Teams page to Home Page Redirection Validation ")
    public void teamsPageToHomePageRedirectionValidation(String team,String pageTitle){


        getHomePage().validateEachTeamsHomePageTitle(team,pageTitle);
        getTeamsPage().clickHomeButtonAndSwitchToOpenTab();
        getHomePage().diplayValidation();
    }

    @Test(dataProvider ="test-data",dataProviderClass = TestDataManager.class,description = "Teams page to Home Page Redirection Validation ")
    public void teamsScheduleTabValidation(String team,String pageTitle){


        getHomePage().validateEachTeamsHomePageTitle(team,pageTitle);
        getTeamsPage().validateOtherTeamsNameinSchedulePage(team);
    }


}
