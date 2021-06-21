package pages.Amazon;

import Utils.ReusableFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage extends ReusableFunc {
    private WebDriver _driver;
    private By username= By.id("txtusername");
    private By password=By.id("txtpassword");
    private By login=By.id("btnLogin");

   public Loginpage(WebDriver driver)
   {
        super(driver);
        this._driver=driver;
    }
    public void enterUsername(String username)
    {
        WebElement ele=returnEle(this.username);
        ele.sendKeys(username);
    }
    public void enterPwd(String password)
    {
        WebElement ele=returnEle(this.password);
        ele.sendKeys(password);
    }
   public void clickOnLoginIn()
   {
       WebElement ele=returnEle(this.login);
       ele.click();
   }
}
