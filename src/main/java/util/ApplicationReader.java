package util;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

/**
 *
 * This Class responsible for reading data from applicationConfig File.
 *
 * @author Swarnaprabha Ghosh
 */

@Resource.Classpath("ApplicationConfig.properties")
public class ApplicationReader {


    public ApplicationReader() {
        PropertyLoader.newInstance().populate(this);
    }

    @Property(value = "Browser")
    private String Browser;

    @Property(value = "Url")
    private String WebsiteUrl;

    @Property(value = "MaxPageLoadTime")
    private int MaxPageLoadTime;

    @Property(value = "ImplicitlyWait")
    private int ImplicitlyWait;

    public String getBrowser() {
        return Browser;
    }

    public String getWebsiteUrl() {
        return WebsiteUrl;
    }

    public int getMaxPageLoadTime() {
        return MaxPageLoadTime;
    }

    public int getImplicitlyWait() {
        return ImplicitlyWait;
    }

}
