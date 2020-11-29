package Review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchWindow() {

        System.setProperty("chrome.driver.exe", "chrome.driver.exe path");
        WebDriver driver = new ChromeDriver();
        driver.get("www.google.com");


        /*every page has id or window handle
         */

        driver.findElement(By.linkText("About")).click();
        System.out.println(driver.getWindowHandle());//parent's window id.we did not switch yet


        driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[1]/section[13]/div[1]/a[1]")).click();
        System.out.println(driver.getWindowHandle());//parent's window id.we did not switch yet


        driver.findElement(By.xpath("//a[contains(text(),'Contact us')]")).click();
        System.out.println(driver.getWindowHandle());//parent's window id.we did not switch yet

        //driver just focus on first window

        Set<String> set=driver.getWindowHandles();
        System.out.println(set);

        Iterator<String> it=set.iterator();
        String parent=it.next();
        String child=it.next();
        String grandchild=it.next();
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());
        ///////////////////////////////////////////////////////
        driver.switchTo().window(child);
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());


        //////////////////////SECON DWAY////////////////////////

        String oldwindow=driver.getWindowHandle();//old window id

        Set<String> set1=driver.getWindowHandles();

        for (String each : set1) {
            if(!each.equals(oldwindow)){
                driver.switchTo().window(each);
                System.out.println(driver.getTitle());
                System.out.println(driver.getWindowHandle());
            }

        }

        driver.switchTo().window(oldwindow);//go to old window

    }

}