package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class CommonDriver {
    String browserName;
    WebDriver driver;
    String currentWorkingDirectory;
    int pageLoadTimeout, elementVisibilityTimeout;

    public void setPageLoadTimeout(int pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public void setElementVisibilityTimeout(int elementVisibilityTimeout) {
        this.elementVisibilityTimeout = elementVisibilityTimeout;
    }

    public CommonDriver(String browserName) {
        this.browserName = browserName;
        pageLoadTimeout = 10;
        elementVisibilityTimeout = 10;
        currentWorkingDirectory = System.getProperty("user.dir");
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("msedge")) {
            System.setProperty("webdriver.edge.driver", currentWorkingDirectory + "/driver/msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void navigateToURL(String url) {
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(elementVisibilityTimeout, TimeUnit.SECONDS);
        driver.get(url);
    }

    public void closeBrowser() {
        driver.close();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void browserWait(int seconds) throws InterruptedException {
        driver.wait(seconds);
    }
}
