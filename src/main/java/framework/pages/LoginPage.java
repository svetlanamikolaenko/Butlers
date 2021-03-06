package framework.pages;

import framework.helpers.JavaScriptHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage{

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div/input[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//h1")
    private WebElement caption;

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
        PageFactory.initElements(driver, this);
        javaScriptHelper = new JavaScriptHelper(driver);
    }

    @Step("Enter Email")
    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    @Step("Enter Password")
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @Step("Click On Login Button")
    public void clickOnLoginButton() {
        loginButton.click();
    }

    @Override
    public void openPage() {
        driver.get(BASE_PAGE + "/login");
        waitElementUntilVisible(caption);
    }
}
