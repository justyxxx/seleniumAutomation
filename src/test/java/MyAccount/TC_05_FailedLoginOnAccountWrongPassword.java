package MyAccount;

import TestBase.testBase;
import uiMyAccountActions.uiMyAccount;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_05_FailedLoginOnAccountWrongPassword extends testBase
{


    @BeforeClass
    public void setUp() throws IOException
    {
        init();
        log.info(" -------------------  EXECUTION STARTED -------------------------------");
        log.info("1. Open the browser : Opened in chrome");
        log.info("2. Enter the URL http://practice.automationtesting.in ");
    }

    @Test
    public void loginInAccount()
    {
        try
        {
            log.info("3. Wrong password into form login and password");
            uiMyAccount MyAccount = new uiMyAccount(driver);
            MyAccount.clickOnMyaccountButton();
            MyAccount.loginFailedWrongPasswrod();
            getScreenShot("TC_05_FailedLoginOnAccountWrongPassword_Success");
            log.info("4. Failed logged into your account: have ERROR: The password you entered for the username qwerasdf is incorrect. Lost your password?");
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            getScreenShot("TC_05_FailedLoginOnAccountWrongPassword_Failure");
        }
    }

    @AfterClass
    public void endTest()
    {
        closeBrowser();
        log.info("---------------------EXECUTION ENDED -------------------------------------");
    }
}

