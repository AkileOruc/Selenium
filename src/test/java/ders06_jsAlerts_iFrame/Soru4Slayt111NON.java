package ders06_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

public class Soru4Slayt111NON extends TestBaseMethod {
    /*1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
      2) sayfadaki iframe sayısını bulunuz.
      3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
      4) ilk iframe'den çıkıp ana sayfaya dönünüz
      5) ikinci iframe'deki (Jmeter Made Easy) linke
     (https://www.guru99.com/live-selenium-project.html) tıklayınız*/

@Test

    public void test() throws InterruptedException {

    // http://demo.guru99.com/test/guru99home/ sitesine gidiniz  //cookiesi gecemiyorum

    driver.get("https://the-internet.herokuapp.com/iframe");

      WebElement iframeElementi=driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
     iframeElementi.click();
     driver.switchTo().frame(iframeElementi);

    WebElement textBoxElementi = driver.findElement(By.xpath("//*[@id='tinymce']"));

    Thread.sleep(2000);
    textBoxElementi.clear();
    textBoxElementi.sendKeys("Merhaba");
    Thread.sleep(2000);

}
}



