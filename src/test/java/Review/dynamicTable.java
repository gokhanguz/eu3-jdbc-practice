package Review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class dynamicTable {

    @Test
    public  void Row(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("url");


        List<WebElement> row=driver.findElements(By.xpath("//table//td/tr"));

        for (WebElement element : row) {
            System.out.println(element.getText());
        }
        int i=1;
        driver.findElement(By.xpath("//table['"+i+"']"));//manipulate
    }
}
