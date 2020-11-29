package Review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class dropdown {
    @Test
    public void dropdown(){

        System.setProperty("chromedriver.exe","path");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("url");

        WebDriverManager.chromedriver().setup();
        WebDriver driver1=new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver1.get("url");


        driver.findElement(By.xpath("dropdownpath")).click();

        //sing select dropdown

        WebElement element=driver.findElement(By.xpath("dropdown"));

        Select slct=new Select(element);
        slct.selectByVisibleText("TR");//text
        slct.selectByValue("2");//tag value
        slct.selectByIndex(2);//write index number

        slct.getFirstSelectedOption();
        slct.getFirstSelectedOption().getText();//give value that select option

        //multi-select dropdown

        WebElement element1=driver.findElement(By.xpath("dropdown"));

        Select slct1=new Select(element);
        slct1.selectByVisibleText("Java");
        slct1.selectByIndex(2);
        slct1.deselectAll();
      //getOptions
        List<WebElement> opt=slct1.getOptions();

        //if Drop down have not select tag

        //click dropdowm and click you want options

    }
}
