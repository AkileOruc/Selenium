package dersPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ders03 {

    // ilgili kurulumlari tamamlayalim
// Kullanici https://www.google.com adresine gider
// Kullanici cookies i kabul eder
// Arama Kutusuna karsilastirma yapmak istedigi para birimlerini girer
// Para birimlerinin karsilastirmasini alir
// Karsilastirilacak olan para biriminin 1.5 den kucuk oldugu test edilir
WebDriver driver;
String https="https://www.";
    @Before

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
@Test

    public void google() throws InterruptedException {
driver.get(https+"google.com");

driver.findElement(By.xpath("(//div[@role='none'])[11]")).click();

WebElement googleAramaKutusu= driver.findElement(By.xpath("//*[@class='gLFyf']"));
 googleAramaKutusu.sendKeys("euro to dollar"+ Keys.ENTER);
    Thread.sleep(200);

WebElement paraninDegeri=driver.findElement(By.xpath("//*[@class='DFlfde SwHCTb']"));

String dollar=paraninDegeri.getText();
Thread.sleep(200);
    Assert.assertNotEquals(dollar,2);



}

@After
    public void  tearDown(){
driver.close();

}

}
