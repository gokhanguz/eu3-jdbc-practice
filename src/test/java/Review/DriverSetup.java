package Review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSetup {
    public static void main(String[] args) {
        //1-chromedriver.exe indir ve projenin foldrına yapıstır
        // -With System.setPoroperty and set property and pass chrome.driver exe path

        System.setProperty("webdriver.chrome.driver","path yapıştır");
        //Instantiate chromedriver
        WebDriver driver=new ChromeDriver();
        //get url
        driver.get("www.google.com");

        //2.
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver1=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver1.get("url");

        //3.Utilities page icine Browser factory claas oluştur
        //string browser name alıyor ve if else göre browser açıyor.

        // Option_1
     /*  public static void main(String[] args) {
      System.setProperty("webdriver.chrome.driver","/Users/IdeaProjects/SeleniumReview/chromedriver");
      WebDriver driver=new ChromeDriver();
      driver.get("https://google.com");
      }*/

        // Option_2
     /* @Test
    public void setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        driver.get("https://google.com");
      }*/
        // Option_3
     /* @Test
    public void setup(){
        WebDriver driver=new ChromeDriver();
        driver= Driver.get("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        driver.get("https://google.com");
    }
*/


    }







}
