package pageObject;


import org.openqa.selenium.support.PageFactory;
import util.BaseTestMethods;

/**
 *
 * This  FactoryInitializer Class helps to initiate all the elements with driver .
 *
 * @author Swarnaprabha Ghosh
 */

public class PageFactoryInitializer extends BaseTestMethods {
    public HomePageObject getHomePage() {

        return PageFactory.initElements(getWebDriver(), HomePageObject.class);
    }

    public CommonTeamsPageObject getTeamsPage() {
        return PageFactory.initElements(getWebDriver(), CommonTeamsPageObject.class);
    }
}
