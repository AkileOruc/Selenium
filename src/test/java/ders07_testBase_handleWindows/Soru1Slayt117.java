package ders07_testBase_handleWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseMethod;

public class Soru1Slayt117 extends TestBaseMethod {

    /*Yeni bir class olusturun: WindowHandle
● Amazon anasayfa adresine gidin.
● Sayfa’nin window handle degerini String bir degiskene atayin
● Sayfa title’nin “Amazon” icerdigini test edin
● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
● Sayfa title’nin “Wise Quarter” icerdigini test edin
● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
● Sayfa title’nin “Walmart” icerdigini test edin
● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin*/


@Test
public void test1() {

    driver.get("https://amazon.com");
String ilkhandleDegeri= driver.getWindowHandle();

String expectedTitle="Amazon";
String actualTitle=driver.getTitle();



    Assert.assertTrue(actualTitle.contains(expectedTitle));
//Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://wisequarter.com");

//Sayfa title’nin “wisequarter” icerdigini test edin

    String expectedTitle1="Wise Quarter";
    String actualTitle1=driver.getTitle();
    System.out.println(driver.getTitle());

    Assert.assertTrue(actualTitle1.contains(expectedTitle1));

//Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
driver.switchTo().newWindow(WindowType.TAB);
driver.get("https://walmart.com");
//Sayfa title’nin “Walmart” icerdigini test edin


    String expectedTitle2="Walmart";
    String actualTitle2=driver.getTitle();

    Assert.assertTrue(actualTitle2.contains(expectedTitle2));

//● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin*/
    driver.switchTo().window(ilkhandleDegeri);
    String expectedUrl="https://www.amazon.com/";
    String actualUrl=driver.getCurrentUrl();

    Assert.assertEquals(expectedUrl,actualUrl);


}
}
