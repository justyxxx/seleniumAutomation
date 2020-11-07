package uiMyAccountActions;

import TestBase.testBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class uiMyAccount extends testBase
{
    public static final Logger log = Logger.getLogger(uiMyAccount.class.getName());
    @FindBy(xpath="//a[contains(text(),'My Account')]")
    WebElement MyAccbutton;

    @FindBy(xpath="//h2[contains(text(),'Login')]")
    WebElement LoginTitle;

    @FindBy(xpath="//input[@id='username']")
    WebElement LoginInputUsername;

    @FindBy(xpath="//input[@id='password']")
    WebElement LoginInputPassword;

    @FindBy(className="woocommerce-Button")
    WebElement LoginSubmitButton;

    @FindBy(xpath="//a[contains(text(),'Sign out')]")
    WebElement LoginSignOut;

    @FindBy(className="woocommerce-error")
    WebElement LoginSubmitError;

    @FindBy(xpath="//li[contains(text(),' Username is required.')]")
    WebElement LoginEmptyErrorText;

    @FindBy(xpath="//li[contains(text(),': Invalid username. ')]")
    WebElement LoginUsernameErrorText;

    @FindBy(xpath="//li[contains(text(),'The password you entered for the username')]")
    WebElement LoginPasswordErrorText;



    public uiMyAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMyaccountButton() {
        MyAccbutton.click();
        log.info("3. Click on MyAccount Menu - Passed");
        String LoginText = LoginTitle.getText();
        Assert.assertEquals(LoginText, "Login");
        log.info("3. check that have passed successfully" + LoginText);
    }

    public void TypeLoginPass (String login, String password) {
        LoginInputUsername.sendKeys(login);
        LoginInputPassword.sendKeys(password);
        LoginSubmitButton.click();
    }
    public void AssertLogin(WebElement locator, String error) {
        Assert.assertEquals(locator.getText(), error);
    }
    public void loginSuccesfulyEnter() {
        TypeLoginPass("qwerasdf", "q!w@e#r$");
        AssertLogin(LoginSignOut,"Sign out");

    }

    public void loginFailedEmptyInpunts() {
        TypeLoginPass("", "");
        waitForElement(driver, 2000, LoginSubmitError);
        AssertLogin(LoginEmptyErrorText, "Error: Username is required.");
    }

    public void loginFailedWrongUsername() {
        TypeLoginPass("asdfgfgd", "q!w@e#r$");
        waitForElement(driver, 2000, LoginSubmitError);
        AssertLogin(LoginUsernameErrorText, "ERROR: Invalid username. Lost your password?");
    }

    public void loginFailedWrongPasswrod() {
        TypeLoginPass("qwerasdf", "q!w@e#r$asd");
        waitForElement(driver, 2000, LoginSubmitError);
        AssertLogin(LoginPasswordErrorText, "ERROR: The password you entered for the username qwerasdf is incorrect. Lost your password?");
    }

}
