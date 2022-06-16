package tests.login;
import framework.config.TestConfig;
import framework.pages.HomePage;
import framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginTest extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    void setup(){
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        homePage = new HomePage(driver);
    }

    @Test
    void loginTest(){
        loginPage.enterEmail(TestConfig.CONFIG.userEmail());
        loginPage.enterPassword(TestConfig.CONFIG.userPassword());
        loginPage.clickOnLoginButton();
        Assert.assertEquals(homePage.getCation(), "Вітаємо у BUTLERS!");
    }
}
