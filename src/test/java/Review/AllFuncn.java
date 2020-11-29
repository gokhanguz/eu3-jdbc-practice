package Review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class AllFuncn {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedrive.exe pathini yapıştır");
        WebDriver driver=new ChromeDriver();
        driver.get("www.amazon.com");

        //get attribute
        driver.findElement(By.id("day")).getAttribute("id");

        driver.getCurrentUrl();//comes url
        driver.getTitle();//comes page title

        //driver.get("url"); tüm sayfanın yüklenmesini bekliyor
        // driver.navigate().to("url"); sayfanın yüklenmsini beklemez,browserı acar
//        driver.navigate().forward();
//        driver.navigate().refresh(); many functionality


        System.out.println("******************CHECKBOX****************************");


    }
    @Test
    public void checkbox(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("url");

        List<WebElement> checkbox=driver.findElements(By.xpath("xpath "));

        for (WebElement each : checkbox) {
           if(!each.isSelected())
              each.click();
        }
     //for check the visibility of the element we use
     //isEnabled==>check if element is  enable
     //isDisplayed==>check is element is displayed

    }

    @Test
    public void radioButton(){
        System.setProperty("chrome.driver.exe","paste extension");
        WebDriver driver=new ChromeDriver();
        driver.get("url");


        List<WebElement> radio=driver.findElements(By.cssSelector("[cşaş]"));

        for (WebElement each : radio) {
            each.click();
        }

    }

}
