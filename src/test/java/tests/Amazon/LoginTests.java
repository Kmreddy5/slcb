package tests.Amazon;

import Utils.ReusableFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.*;
import pages.Amazon.Loginpage;

import java.sql.SQLOutput;

public class LoginTests {
    private WebDriver _driver;
    @BeforeClass
    public void lunchBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        _driver = new ChromeDriver();
        _driver.get("http://bgvm.eastus.cloudapp.azure.com:4028/BankGenie/Login/Loginpage.aspx");
    }
    @AfterClass
    public void closeBrowser() {
        // _driver.close();
        _driver.quit();
    }
    @Test(priority = 0,invocationCount = 1, dataProvider = "invaliddata")
    public void invalidUsernameLogin(String username, String password) {

        Loginpage loginpage = new Loginpage(_driver);
        loginpage.enterUsername(username);
        loginpage.enterPwd(password);
        loginpage.clickOnLoginIn();
    }

    @Test(priority = 2,dataProvider = "invaliddata")
    public void invalidPasswordLogin(String username, String password) {

        Loginpage loginpage = new Loginpage(_driver);
        loginpage.enterUsername(username);
        loginpage.enterPwd(password);
        loginpage.clickOnLoginIn();

    }
    @Test(priority = 3,dependsOnMethods = "invalidPasswordLogin",dataProvider = "invaliddata")
    public void invalidUsernamePasswordLogin(String username, String password) {

        Loginpage loginpage = new Loginpage(_driver);
        loginpage.enterUsername(username);
        loginpage.enterPwd(password);
        loginpage.clickOnLoginIn();
    }
    // @Parameters({"username","password"})
    @Test(priority = 4, dataProvider = "ValidLogindetails")

    //(priority = 0,dependsOnMethods = {"invalidUsernamePasswordLogin"},invocationCount = 5)
    public void validLogin(String username, String password) {

        Loginpage loginpage = new Loginpage(_driver);
        loginpage.enterUsername(username);
        loginpage.enterPwd(password);
        loginpage.clickOnLoginIn();
    }

    @DataProvider(name = "invaliddata")
    public Object[][] invalidDetails() {
        return new Object[][]{{"mouni","jjd"},{"tester1","Test@1231"},{"tester","Test@12"}};
       /* Object[][] credentials = new Object[5][2];
        //incorrect login/short login
        credentials[0][0] = "testss";
        credentials[0][1] = "testss";logindata
        //empty login
        credentials[1][0] = "";
        credentials[1][1] = "emptylogin";
        //emptypass
        credentials[2][0] = "emptypass";
        credentials[2][1] = "";
        //allempty
        credentials[3][0] = "";
        credentials[3][1] = "";
        //incorrect
        credentials[4][0] = "wrongUname";
        credentials[4][1] = "wrongPass";
        return credentials;

        */

        }
    @DataProvider(name = "ValidLogindetails")
    public Object[][] validDetails(){
        return new Object[][]{{"tester","Test@123"},{"tester","Test@1234"}};
    }
}
