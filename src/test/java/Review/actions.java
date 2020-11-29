package Review;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class actions {
    @Test
    public void actions(){
        /* Actions class used with mouse and keyboard evemts
        Mouse Events.:
        click();,doubleclick,clickANdHold,dragANdDrop,moveToelement,release,perform,build,
        rightclick==>contextClick

        Keyboard events;
        KeyUp,Keydown,Keys.AltKey,Keys.Shift,Keys.Control,Keys.Enter
         */
        System.setProperty("chrome.driver.exe","path yapıştır");
        WebDriver driver=new ChromeDriver();
        driver.get("cybertekschool.com");
        driver.findElement(By.xpath("cybertek hover sayfası git")).click();


       //Move to Element
        Actions act=new Actions(driver);
        List<WebElement> element=driver.findElements(By.cssSelector("hover image"));

        for (WebElement each : element) {
            act.moveToElement(each).perform();
            System.out.println(each.getText());
        }

        //Drag and Drop
        //1.way
        WebElement target= driver.findElement(By.xpath("target"));
        WebElement source= driver.findElement(By.xpath("tsource"));
        act.dragAndDrop(source,target).perform();
        //2. way

        act.clickAndHold(source).moveToElement(target).release().build().perform();
        //build use create chain of actions

        //Double Click and Right Click

        driver.get("cybertek.student.actions");
        WebElement doubleBUtton=driver.findElement(By.cssSelector("double"));
        act.moveToElement(doubleBUtton).doubleClick().perform();

        act.moveToElement(target).contextClick().perform();//==>rightClick

        //////////////////////////////////KEYBOARD///////////////////////////////////////////

        //1.KeyTab
        WebElement mail=driver.findElement(By.id("user"));
        act.click(mail)
                .sendKeys("mike@h-gmail.com", Keys.TAB)
                .sendKeys("mike",Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //2.KeyUp
        WebElement elt=driver.findElement(By.id("fakeinput"));
        act.keyDown(elt,Keys.SHIFT);//keyDown means press the button
        act.sendKeys("box");
        act.keyUp(elt,Keys.SHIFT);
        act.perform();

        //lazy way
        act.keyDown(elt,Keys.SHIFT).sendKeys("box").keyUp(Keys.SHIFT).perform();

        //3.Tab ctrl
        act.keyDown(elt,Keys.CONTROL).keyDown(mail,Keys.CONTROL).perform();


    }
}
