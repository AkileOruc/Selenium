package ders08_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class Soru3ActionSlayt133IframeAction extends TestBaseMethod {
/* 1- Bir Class olusturalim KeyboardActions2
   2- https://html.com/tags/iframe/ sayfasina gidelim
   3- video’yu gorecek kadar asagi inin
   4- videoyu izlemek icin Play tusuna basin
   5- videoyu calistirdiginizi test edin*/


    @Test

  public void test() throws InterruptedException {

driver.get("https://html.com/tags/iframe/");

       // 3- video’yu gorecek kadar asagi inin

        Actions actions= new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();


        // 4- videoyu izlemek icin Play tusuna basin
        // AMA BURDA IFRAME DE VARDI HATIRLA!!!

        //TAG i IFRAME olan bir locate bulmalisin!!!

        WebElement frameElementi = driver.findElement(By.xpath("//*[@height='315']"));

        driver.switchTo().frame(frameElementi);
        driver.switchTo().defaultContent();

       Thread.sleep(3000);
       actions.moveToElement(frameElementi).click().perform();

        Thread.sleep(3000);


        //WebElement videoOynat = driver.findElement(By.xpath("//*[@class='ytp-cued-thumbnail-overlay-image']"));
       // WebElement videoOynat = driver.findElement(By.xpath("//*[@style='background-image: url(\"https://i.ytimg.com/vi_webp/owsfdh4gxyc/hqdefault.webp\");']"));
        WebElement videoOynat = driver.findElement(By.xpath("(//*[@data-layer='4'])[1]"));
        Thread.sleep(3000);
        actions.moveToElement(videoOynat).click().perform();


      //5- videoyu calistirdiginizi test edin*/
      WebElement videoBilgiYazisi=driver.findElement(By.xpath("(//a[@href='https://www.youtube.com/watch?v=owsfdh4gxyc'])[2]"));

      Assert.assertTrue(videoBilgiYazisi.isDisplayed());
    }
}
