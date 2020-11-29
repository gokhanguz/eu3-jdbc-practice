package Review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    WebDriver driver;

    @Test
    public void test() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("url");


        //FİRST WAY
        WebElement table=driver.findElement(By.xpath("table"));
        File srcFile=table.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("./test-output/screenshot/webtable.png"));

        //SECOND WAY
        WebElement email= driver.findElement(By.id("email"));
        email.sendKeys("sss@mail.com");

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("sss@mail.com");


        TakesScreenshot srcShot=(TakesScreenshot)email;
        File file=srcShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("./test-output/screenshot/"+"filename"+".png\""));

        //THIRD WAY



    }
}
