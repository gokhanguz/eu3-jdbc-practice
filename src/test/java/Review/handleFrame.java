package Review;

import com.mysql.cj.jdbc.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class handleFrame {

    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("www.practice.cybertekschool.com");

        WebElement el= driver.findElement(By.id("nce_fr"));
        driver.switchTo().frame(el);//switch to inner frame
        System.out.println(driver.getTitle());

        el.clear();//remove the default text
        driver.switchTo().defaultContent();//it switch main frame

        int numberofframe=driver.findElements(By.id("frame")).size();
    }

    @Test
    public  void test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("www.practice.cybertekschool.com");

        WebElement el= driver.findElement(By.id("nce_fr"));

        /*bigfather frame
          *frame top
             -left
             -middle
             -right
          * frame bottom
         */

        driver.switchTo().frame("top");
        driver.switchTo().frame("left");//call by value

        //go to middle
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);//call by index number
        //go to bottom
        driver.switchTo().defaultContent();
        driver.switchTo().frame(el);//call by webelement

    }
}
