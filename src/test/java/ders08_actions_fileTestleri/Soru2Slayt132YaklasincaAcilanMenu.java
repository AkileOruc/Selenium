package ders08_actions_fileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class Soru2Slayt132YaklasincaAcilanMenu extends TestBaseMethod {
   /* 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
2- Hover over Me First" kutusunun ustune gelin
3- Link 1" e tiklayin
 4- Popup mesajini yazdirin
5- Popup'i tamam diyerek kapatin
 6- “Click and hold" kutusuna basili tutun
 7-“Click and hold" kutusunda cikan yaziyi yazdirin
  8- “Double click me" butonunu cift tiklayin*/

    @Test
    public void test1() throws InterruptedException {
driver.get("http://webdriveruniversity.com/Actions");

 //  2- Hover over Me First" kutusunun ustune gelin
WebElement meFirst=driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));

Actions actions=new Actions(driver);

actions.moveToElement(meFirst).perform();

// 3- Link 1" e tiklayin
        WebElement meSecond=driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        meSecond.click();
       Thread.sleep(2000);
// 4- Popup mesajini yazdirin
        String alertYazisi= driver.switchTo().alert().getText();
        System.out.println(alertYazisi);
        Thread.sleep(2000);
 // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
//6- “Click and hold" kutusuna basili tutun


        WebElement ClikckButonu=driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        actions.clickAndHold(ClikckButonu).perform();

 // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement butonYazisi=driver.findElement(By.xpath("//*[@id='click-box']"));
        System.out.println(butonYazisi.getText());
        Thread.sleep(2000);
 //8- “Double click me" butonunu cift tiklayin*/

        WebElement clickMe=driver.findElement(By.xpath("//*[text()='Double Click Me!']"));

        actions.doubleClick(clickMe).perform();
        Thread.sleep(2000);
    }
}