package Pages;

import commonLibs.implementation.ElementControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    WebDriver driver;
    @FindBy(id = "txtUsername")
    private WebElement usernameField;
    @FindBy(id = "txtPassword")
    private WebElement passwordField;
    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication(String username, String password) {

        elementControl.enterText(usernameField, username);
        elementControl.enterText(passwordField, password);
        elementControl.click(loginButton);

    }
}

