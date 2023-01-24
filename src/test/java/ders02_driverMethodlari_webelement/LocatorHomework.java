package ders02_driverMethodlari_webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LocatorHomework {
    /*1- https://www.amazon.com/ sayfasına gidin.
      2- Arama kutusuna “city bike” yazip aratin
      3- Görüntülenen sonuçların sayısını yazdırın
      4- Listeden ilk urunun resmine tıklayın.*/
    public static void main(String[] args) throws InterruptedException {
        //1
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        //2
        WebElement aramaKutu = driver.findElement(By.name("field-keywords"));
        aramaKutu.sendKeys("city bike" + Keys.ENTER);
        //3

        List<WebElement> istenenElementListesi = driver.findElements(By.className("sg-col-inner"));
        // bu listenin 1.elementi bulunan sonuc sayisi

        System.out.println(istenenElementListesi.get(0).getText());

        //4 Sonra karşınıza çıkan ilk sonucun resmine tıklayın.

        driver.findElement(By.className("s-image")).click();
        /*
        Eger bir locate ile birden fazla element bulunuyorsa
        selenium ilk elementi kullanir
         */
        Thread.sleep(5000);

        driver.close();
    }
}
