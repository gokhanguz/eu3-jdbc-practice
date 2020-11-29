package Review;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ScrollDownAndUp {

    @Test
    public  void downAndUp(){

        System.setProperty("chrome.driver.exe","chrome.driver.exe path");
        WebDriver driver=new ChromeDriver();
        driver.get("www.amazon.com");

        JavascriptExecutor js=(JavascriptExecutor) driver;

        //scroll down
        for (int i = 0; i < 10; i++) {
             js.executeScript("window.scrollBy(0,250)");//250 pixel will go down

        }
        //scrollUp
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,-250)");//-250 pixel will go up

        }

        //go scroll to element
        //this script will be scroll down till the link is visible
        //once link element will be visible,it will  stop scrolling

        WebElement link= driver.findElement(By.tagName("element"));
        js.executeScript("arguments[0].scrollIntoView(true)",link);


        //////////////////////////////////////////////////////////
        Actions act=new Actions(driver);
        act.sendKeys(Keys.UP).perform();
        act.sendKeys(Keys.DOWN).perform();
        act.keyUp(link,Keys.DOWN).perform();//try


    }
}
