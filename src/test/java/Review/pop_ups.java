package Review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class pop_ups {

    @Test
    public void alert(){

        /*Alert is interface
        Simple alert:A simple alert just has an ok button.we will use accept().
        Confirmation Alert:this type of alert comes with an option.accept,dismiss
        Prompt Alert=there is a text field after sendkeys() vwe will use accept,dismiss
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("url");

        Alert alert=driver.switchTo().alert();
        driver.findElement(By.xpath("cybertek sayfasındaki js alert limkine tıkla"));
        alert.accept();//click ok button
        alert.dismiss();//(click cancel button)


        //Prompt alert
        driver.switchTo().alert().sendKeys("sami@gmail.com");
        driver.switchTo().alert().accept();
    }

}
