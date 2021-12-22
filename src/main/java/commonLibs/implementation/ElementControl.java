package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementControl {
    WebDriver driver;

    public ElementControl(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String message) {
        element.sendKeys(message);
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public boolean isVisible(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void selectViaVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectViaIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }


}
