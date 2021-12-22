package Pages;

import commonLibs.implementation.ElementControl;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;
    ElementControl elementControl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementControl = new ElementControl(driver);
    }
}
