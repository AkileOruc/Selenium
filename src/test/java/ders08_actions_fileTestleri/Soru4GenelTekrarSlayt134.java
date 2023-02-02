package ders08_actions_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseMethod;

import java.util.List;

public class Soru4GenelTekrarSlayt134 extends TestBaseMethod {
  /*  Test01 :==================
1- amazon gidin
2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
3- dropdown menude 28 eleman olduğunu doğrulayın
======Test02=============
1- dropdown menuden elektronik bölümü seçin
2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
4- ikinci ürüne relative locater kullanarak tıklayin
5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
======Test03==================
1- yeni bir sekme açarak amazon anasayfaya gidin
2-dropdown’dan bebek bölümüne secin
3-bebek puset aratıp bulundan sonuç sayısını yazdırın 4-sonuç yazsının puset içerdiğini test edin
5-üçüncü ürüne relative locater kullanarak tıklayin
6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
======== Test 4=============
1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın*/


    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        //2 Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın

        WebElement drop= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        drop.click();

        Select select=new Select(drop);

        List<WebElement> options = select.getOptions();

        System.out.println("Dropdowndaki liste sayisi: "+options.size());

        for (WebElement each : options) {
            System.out.println(each.getText());
        }
Thread.sleep(2000);
       //3 dropdown menude 28 eleman olduğunu doğrulayın
        int expectedSize = 28;
        Assert.assertTrue(expectedSize==options.size());
    }



    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.amazon.com/");

// 1- dropdown menuden elektronik bölümü seçin
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));


        Select select=new Select(ddm);

        ddm.sendKeys("Electronics");
         Thread.sleep(3000);
//2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın

        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));


        aramaKutusu.sendKeys("iphone"+ Keys.ENTER);
// 3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));


       String  resultActual=sonuc.getText();
       String resultExpected="iphone";

       Assert.assertTrue(resultActual.contains(resultExpected));
//4- ikinci ürüne relative locater kullanarak tıklayin

        WebElement birinciUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));


         //altindaki urunu bulup ustune bak demek icin

        WebElement altindakiUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[11]"));


        WebElement ikinciUrun = driver.findElement(RelativeLocator.with(By.className("s-image")).above(altindakiUrun));
        Thread.sleep(2000);
        ikinciUrun.getText();
//5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        Thread.sleep(2000);


 WebElement title = driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        String titleStr=(title.getText());

        ikinciUrun.click();
 WebElement fiyat = driver.findElement(By.xpath("(//span[@aria-hidden='true'])[13]"));
        String fiyatStr=(fiyat.getText());

        fiyat.click();
// / 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
WebElement buyNow= driver.findElement(By.xpath("//*[@id='buy-now-button']"));

         buyNow.click();
        //System.out.println("Urun:"+ titleStr +"/Urun fiyati:"+ fiyatStr);

 WebElement emailButonu= driver.findElement(By.xpath("//*[@type='email']"));

        emailButonu.click();

        Faker faker=new Faker();
Thread.sleep(2000);
        Actions actions=new Actions(driver);

     String fakemail=faker.internet().emailAddress();
     String fakeSifre=faker.internet().password();

        emailButonu.sendKeys(fakemail+Keys.ENTER);

      driver.findElement(By.id("auth-create-account-link")).click();

      WebElement isimButonu=driver.findElement(By.xpath("//*[@id='ap_customer_name']"));


        actions.click(isimButonu).click()
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakemail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .click();


    }


   @Test

   public void test03() throws InterruptedException {
    driver.switchTo().newWindow(WindowType.TAB);
    driver.get("https://www.amazon.com/");

       WebElement dropDown= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

       dropDown.click();

       Select select=new Select(dropDown);
// 2-dropdown’dan bebek bölümüne secin

       dropDown.sendKeys("Baby");

// 3-bebek puset aratıp bulundan sonuç sayısını yazdırın
       WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

       aramaKutusu.sendKeys("pousette"+ Keys.ENTER);
       WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));


       String sonucStr=sonucYazisi.getText();

       //System.out.println(sonucStr);    //1-16 of 31 results for "pousette"

       sonucStr=sonucStr.substring((sonucStr.indexOf("of")+3),(sonucStr.indexOf("results")-1));

       System.out.println("Bulunan Urun Sayisi=" +sonucStr);

// 4-sonuç yazsının puset içerdiğini test edin

       Assert.assertTrue(sonucYazisi.getText().contains("pousette"));

// 5-üçüncü ürüne relative locater kullanarak tıklayin

WebElement ikinciUrun= driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));


WebElement ucuncuUrun= driver.findElement(RelativeLocator.with(By.className("sg-col-inner")).above(ikinciUrun));

ucuncuUrun.click();
Thread.sleep(2000);

// 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin



       WebElement urunTitle= driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[3]"));


       String urun=urunTitle.getText();
       urunTitle.click();
 Thread.sleep(2000);
// fiyat bulamiyorum stokta kalmamis
     //  WebElement urunFiyat= driver.findElement(By.xpath("//span[@class='a-price-whole']"));

     //  String fiyat=urunFiyat.getText();


Thread.sleep(2000);


       WebElement satinAlButonu= driver.findElement(By.xpath("//*[@title='Add to List']"));
       satinAlButonu.click();


       WebElement emailButonu= driver.findElement(By.xpath("//*[@type='email']"));
       emailButonu.click();


       Faker faker=new Faker();
       Thread.sleep(2000);
       String fakemail=faker.internet().emailAddress();

       emailButonu.sendKeys(fakemail+Keys.ENTER);


   }
}