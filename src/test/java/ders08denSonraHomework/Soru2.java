package ders08denSonraHomework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class Soru2 extends TestBaseMethod {

/*“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
2. “Our Products” butonuna basin
3. “Cameras product”i tiklayin
4. Popup mesajini yazdirin
5. “close” butonuna basin
6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin*/


    @Test
    public void test01 () throws InterruptedException {
driver.get("http://webdriveruniversity.com/IFrame/index.html");

//2. “Our Products” butonuna basin

        //IFRAME var

 WebElement iframe=  driver.findElement(By.xpath("//*[@id='frame']"));
 driver.switchTo().frame(iframe);

 driver.findElement(By.xpath("//*[text()='Our Products']")).click();



//3. Cameras product”i tiklayin   4. Popup mesajini yazdirin

 driver.findElement(By.xpath("(//*[@class='sub-heading'])[2]")).click();


WebElement popUp=driver.findElement(By.xpath("//*[@class='modal-header']"));
        System.out.println(popUp.getText());


        Thread.sleep(2000);
// 5. “close” butonuna basin
  driver.findElement(By.xpath("//*[text()='Close']")).click();
// IFRAME ile isimis bitti kapatabiliriz
        driver.switchTo().defaultContent();


 //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        //her locati denedim olmadi Action la denedim Super oldu :)
        WebElement link= driver.findElement(By.xpath("//*[@id=\"nav-title\"]"));
        Actions actions=new Actions(driver);

        actions.moveToElement(link).click().perform();

      Thread.sleep(2000);
//7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin*/

String expectedUrl="http://webdriveruniversity.com/index.html";
        Assert.assertTrue(driver.getCurrentUrl().equals(expectedUrl));

    }
}