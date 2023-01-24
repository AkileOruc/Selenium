package ders02_driverMethodlari_webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_findElementMethodu {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

         /*
            bir webelementi kullanabilmek icin driver'a yerini tarif etmemiz lazim
            adres bilgisi locator'lar ile veriyoruz
            ,
            driver'in, adresi verilen webelemente gidip onu locate etmesi icin ise
            findElement(Locator) kullanilir

            Locate edilen elementi tekrar kullanabilmek icin bir Webelement objesi olusturup,o objeye atama yapariz
         */



        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        // arama cubuguna Nutella yazip aratalim

        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        Thread.sleep(2000);
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();

        // bir de Java aratalim

        aramaKutusu.sendKeys("Java"+Keys.ENTER);
        Thread.sleep(2000);
        driver.close();
    }
}
