package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableFunc
{
    private WebDriver _driver;
    private WebDriverWait _wait;
    public ReusableFunc(WebDriver driver)
    {
        this._driver=driver;
        _wait=new WebDriverWait(_driver,60);
    }
    public void switchToFrame(By loc) throws Exception {
        try{
        WebElement ele= this.returnEle(loc);
        _driver.switchTo().frame(ele);
        }
        catch(Exception e)
        {
            throw new Exception("error ocuured");
        }
    }
    public void switchToDefault()
    {
        _driver.switchTo().defaultContent();
    }
    public void switchToAlert()
    {
        _driver.switchTo().alert();
    }

    public WebElement returnEle(By loc)
    {
        _wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
        return _driver.findElement(loc);
    }
}
