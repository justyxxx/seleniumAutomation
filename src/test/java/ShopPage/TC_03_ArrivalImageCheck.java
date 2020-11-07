package ShopPage;

import TestBase.testBase;
import UIShopActions.uiActionShopPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_03_ArrivalImageCheck extends testBase
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
    public void verifyAaddToCart()
    {
        try {
            uiActionShopPage shopPage = new uiActionShopPage(driver);
            shopPage.clickOnShopAndopenHome();
            shopPage.getArrivals();
            shopPage.ArrivalImageCheck();
            getScreenShot("TC_03_ArrivalImageCheck_Success");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            getScreenShot("TC_03_ArrivalImageCheck_Failure");
        }
    }

    @AfterClass
    public void endTest()
    {
        closeBrowser();
        log.info("---------------------EXECUTION ENDED -------------------------------------");
    }

}
