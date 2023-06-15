package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * This  class consists all reusable common methods.
 *
 * @author Swarnaprabha Ghosh
 */

public class BaseTestMethods extends WebDriverUtil{


    public String getUrlTitle() throws Exception {

       return getWebDriver().getTitle();
    }






    public void scrollUp() throws Exception {
        ((JavascriptExecutor) getWebDriver()).executeScript("scroll(0, -100);");
    }


    public void scrollDown() throws Exception {
        ((JavascriptExecutor) getWebDriver()).executeScript("scroll(0, 100);");
    }






    public void alertAccept() throws Exception {
        alert = getWebDriver().switchTo().alert();
        alert.accept();
    }



    public void alertDismiss() throws Exception {
        alert = getWebDriver().switchTo().alert();
        alert.dismiss();
    }


    public String getAlertText() throws Exception {
        alert = getWebDriver().switchTo().alert();
        String text = alert.getText();
        Thread.sleep(2000);
        alertAccept();
        return text;
    }






    public void mouseHover(WebElement element) {
        actions = new Actions(getWebDriver());
        actions.moveToElement(element).build().perform();
    }

    public void moveToElementClick(WebElement element) {
        actions = new Actions(getWebDriver());
        actions.moveToElement(element).click().build().perform();
    }


    public void selectByVisibleText(WebElement element, String value) {
        select = new Select(element);
        select.selectByVisibleText(value);
    }



    public void selectByIndex(WebElement element, int value) {
        select = new Select(element);
        select.selectByIndex(value);
    }



    public void selectByValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }



    public void click(WebElement element) {
        element.click();
    }


    public void javaScriptExecutorClick(WebElement element) {
        ((JavascriptExecutor) getWebDriver()).executeScript("return arguments[0].click();", element);
    }



    public void sendKeys(WebElement element, String value) {
        element.sendKeys(value);
    }



    public void clear(WebElement element) {
        element.clear();
    }



    public void dragAndDrop(WebElement Source, WebElement Destination) {
        actions = new Actions(getWebDriver());
        actions.dragAndDrop(Source, Destination);
    }



    public void dragAndDropTo(WebElement Source, int XOffset, int YOffset) throws Exception {
        actions = new Actions(getWebDriver());
        actions.dragAndDropBy(Source, XOffset, YOffset);
    }



    public void rightClick(WebElement element) {
        actions = new Actions(getWebDriver());
        actions.contextClick(element);
        actions.build().perform();
    }



    public void closeCurrentTab() {
        getWebDriver().close();
    }



    public void clickAndHold(WebElement element) {
        actions = new Actions(getWebDriver());
        actions.clickAndHold(element).build().perform();
    }



    public void doubleClick(WebElement element) {
        actions = new Actions(getWebDriver());
        actions.doubleClick(element).build().perform();
    }



    public void switchToFrameByIndex(int index) throws Exception {
        getWebDriver().switchTo().frame(index);
    }



    public void switchToFrameByFrameName(String frameName) throws Exception {
        getWebDriver().switchTo().frame(frameName);
    }



    public void switchToFrameByWebElement(WebElement element) throws Exception {
        getWebDriver().switchTo().frame(element);
    }



    public void switchOutOfFrame() throws Exception {
        getWebDriver().switchTo().defaultContent();
    }


    public String getTooltipText(WebElement element) {
        String tooltipText = element.getAttribute("title").trim();
        return tooltipText;
    }



    public void closeAllTabsExceptFirst() {
       List<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        for (int i = 1; i < tabs.size(); i++) {
            getWebDriver().switchTo().window(tabs.get(i));
            getWebDriver().close();
        }
        getWebDriver().switchTo().window(tabs.get(0));
    }

    public void switchToTab(){
        List<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        for (int i = 1; i < tabs.size(); i++) {
            getWebDriver().switchTo().window(tabs.get(i));
        }
    }


    public void explicitWaitOfVisibility(WebElement element, long timeInSeconds){
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
