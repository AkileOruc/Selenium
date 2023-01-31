package ders08_actions_fileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class soru1ActionSlayt133 extends TestBaseMethod {
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

        WebElement youtube = driver.findElement(By.xpath("//*[@class='ytp-cued-thumbnail-overlay']"));

        actions.moveToElement(youtube);

        WebElement videoOynat = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));

        //actions.moveToElement(videoOynat).click();

        videoOynat.click();

//5- videoyu calistirdiginizi test edin*/

    }
}
