package Review;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver=new ChromeDriver();
        WebDriver driver=new ChromeDriver();
        driver.get("ww.google.com");


        //1.ID==>if it is not contain numbers ,it should be first preferences
           driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple", Keys.ENTER);
           //second way click method

        //2.Name==>
          driver.findElement(By.name("search")).sendKeys("apple");
          driver.findElement(By.name("submit")).click();

        //3.Linktext
        driver.findElement(By.linkText("Best Seller"));

        //4-Partial Linktext
        driver.findElement(By.partialLinkText("Best"));

        //5-Tagname
        driver.findElement(By.tagName("span"));

        //6-CSS
        driver.findElement(By.cssSelector("#nav-sws > a")).click();

        //8-Xpath

          //1.Absolute xpath=>it starts single slash from root to bottom
        driver.findElement(By.xpath("/html/bla/bla")).click();

          //2.Relative xpath=>it starts double slash
        driver.findElement(By.xpath("//span[@id='ad']")).click();

        //contains,start-with,ends-with,and,or......

        //xpath
        driver.findElement(By.xpath("//span[contains(@id,'glass')]")).click();
        driver.findElement(By.xpath("//span[starts-with(@id,'app']")).click();
        driver.findElement(By.xpath("//input[@id='title' and @type='text']")).click();
        driver.findElement(By.xpath("//input[@id='title' or @type='text']")).click();
        driver.findElement(By.xpath("//a[(text()='apple']")).click();

        //css
        driver.findElement(By.cssSelector("[id*='apple']")).click();//contains
        driver.findElement(By.cssSelector("[id^='apple']")).click();//start-with
        driver.findElement(By.cssSelector("[id$='apple']")).click();//ends-with

        //Traverse between parent and child

        driver.findElement(By.xpath("//span[contains(@id,'glass')]//span"));//parent to child(/ or //)
        driver.findElement(By.xpath("//span[contains(@id,'glass')]/parent::div"));//child to parent

        //travers between siblings
        driver.findElement(By.xpath("//span[contains(@id,'glass')]/preciding-sibling::div"));
        driver.findElement(By.xpath("//span[contains(@id,'glass')]/preciding-sibling::div"));

        // Traverse betwwen parent
        // 1-  child to parent    /parent::tagName     yada       /..
        // Traverse between siblings
        // 1- preceding sibling   /preceding::sibling
        // 2- following sibling   /following::sibling
        // nth-child   (if values same this one is not working )
        // locator>tagName:nth-child(5);
        // nth-of-type
        // locator>tagName:nth-of-type(5);



    }


}
