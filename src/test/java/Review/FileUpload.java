package Review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {

    @Test(description = "fileUpload")
    public void upload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("ww.amazon.com");
        //1.Way
        WebElement uploadButton=driver.findElement(By.xpath("upload "));
        uploadButton.sendKeys("\"C:\\Users\\Gökhan\\Desktop\\tedy\"");

        //Not:file.seperator bak
        //2.Way

        /*Create .text file in the selenium
          copy path .text file
         */

        String path=System.getProperty("user.dir");
        String pathSlenium="src/test/resources/textfile.txt";
        String fullpath=path+"/"+pathSlenium;
        uploadButton.sendKeys(fullpath);



    }
}
