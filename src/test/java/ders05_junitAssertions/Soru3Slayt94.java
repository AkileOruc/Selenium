package ders05_junitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Soru3Slayt94 {
  /*  Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    a. Verilen web sayfasına gidin.
    https://facebook.com
    b. Cookies’i kabul edin
    c. Create an account buton’una basin
    d. Radio button elementlerini locate edin ve size uygun olani secin*/

    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebook.com");
    }
    @AfterClass
    public static void teardown(){
      //  driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        //b. Cookies’i kabul edin
driver.findElement(By.xpath("//*[@title='Autoriser les cookies essentiels et optionnels']")).click();
        Thread.sleep(2000);

        //c. Create an account buton’una basin
driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
WebElement isim= driver.findElement(By.xpath("//input[@tabindex='0']"));
isim.sendKeys("Akile");
        Thread.sleep(2000);

WebElement soyIsim=driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[2]"));
       soyIsim.sendKeys("Oruc");
WebElement numero=driver.findElement(By.xpath("(//input[@type='text'])[4]"));
numero.sendKeys("123456");
        Thread.sleep(2000);

WebElement sifre=driver.findElement(By.xpath("//*[@data-type='password']"));
sifre.sendKeys("654321");
        Thread.sleep(2000);


        WebElement ddmGun= driver.findElement(By.id("day"));
        Select select1=new Select(ddmGun);
        ddmGun.sendKeys("28");

        WebElement ddmAy= driver.findElement(By.id("month"));
        Select select2=new Select(ddmAy);
        ddmAy.sendKeys("mai");

        WebElement ddmYil= driver.findElement(By.id("year"));
        Select select3=new Select(ddmYil);
        ddmYil.sendKeys("1986");

        Thread.sleep(2000);

driver.findElement(By.xpath("//*[text()='Femme']")).click();

Thread.sleep(2000);

driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

WebElement uyariMesaji=driver.findElement(By.xpath("(//*[@class='_5dbc img sp_98fCI7IVTTz sx_54513f'])[3]"));


    }
}
