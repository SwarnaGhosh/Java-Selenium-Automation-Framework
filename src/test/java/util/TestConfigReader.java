package util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

/**
 *
 * This test class works Test related Configuration Reader.
 *
 * @author Swarnaprabha Ghosh
 */

public class TestConfigReader {
    public static ApplicationReader appConfig = new ApplicationReader();

    public static String WebsiteURL = appConfig.getWebsiteUrl();
    public static String Browser = appConfig.getBrowser();
    public static int MaxPageLoadTime = appConfig.getMaxPageLoadTime();
    public static int ImplicitlyWait = appConfig.getImplicitlyWait();

    public static String FS = File.separator;

    public static String OSName = System.getProperty("os.name");
    public static String OSArchitecture = System.getProperty("os.arch");
    public static String OSVersion = System.getProperty("os.version");
    public static String OSBit = System.getProperty("sun.arch.data.model");

    public static String ProjectWorkingDirectory = System.getProperty("user.dir");

    public static String TestData = "./src/test/resources/TestData/";
    public static String ExcelFiles = "./src/test/resources/TestData/Excel Files/";
    public static String PropertiesFiles = "./src/test/resources/TestData/Properties Files/";
    public static String Reports = "./src/test/resources/Reports/";
    public static Alert alert;
    public static Actions actions;
    public static Select select;




}
