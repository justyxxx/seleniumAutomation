package MyAccount;

import TestBase.testBase;
import uiMyAccountActions.uiMyAccount;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_03_FailedLoginOnAccountEmptyInputs extends testBase
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
        {   log.info("3. Empty symbols into form login and password");
            uiMyAccount MyAccount = new uiMyAccount(driver);
            MyAccount.clickOnMyaccountButton();
            MyAccount.loginFailedEmptyInpunts();
            getScreenShot("TC_03_FailedLoginOnAccountEmptyInputs_Success");
            log.info("4. Failed logged into your account: have Error: Username is required.");
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            getScreenShot("TC_03_FailedLoginOnAccountEmptyInputs_Failure");
        }
    }

    @AfterClass
    public void endTest()
    {
        closeBrowser();
        log.info("---------------------EXECUTION ENDED -------------------------------------");
    }
}

