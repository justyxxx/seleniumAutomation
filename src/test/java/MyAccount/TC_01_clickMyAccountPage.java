package MyAccount;

import TestBase.testBase;
import uiMyAccountActions.uiMyAccount;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_01_clickMyAccountPage extends testBase
{


    @BeforeClass
    public void setUp() throws IOException
    {
        init();
        log.info(" -------------------  EXECUTION STARTED -------------------------------");
        log.info("1. Open the browser : Opened in crome");
        log.info("2. Enter the URL http://practice.automationtesting.in ");
    }

    @Test
    public void clickMyAccountButton()
    {
        try
        {
            uiMyAccount MyAccount = new uiMyAccount(driver);
            MyAccount.clickOnMyaccountButton();
            getScreenShot("TC_01_clickMyAccountPage_Success");
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            getScreenShot("TC_01_clickMyAccountPage_Failure");
        }
    }

    @AfterClass
    public void endTest()
    {
        closeBrowser();
        log.info("---------------------EXECUTION ENDED -------------------------------------");
    }
}

