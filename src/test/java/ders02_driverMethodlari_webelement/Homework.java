package ders02_driverMethodlari_webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework {
    public static void main(String[] args) throws InterruptedException {
  /*1.Yeni bir class olusturalim (Homework)
    2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
    (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
    3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
    4.https://www.walmart.com/ sayfasina gidin.
    5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
    6. Tekrar “facebook” sayfasina donun
    7. Sayfayi yenileyin
    8. Sayfayi tam sayfa (maximize) yapin
    9.Browser’i kapatin*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2
        driver.navigate().to("https:/facebook.com");
        Thread.sleep(3000);
        String expectedTitle= "facebook";
        String actuelTitle= driver.getTitle();

        if (expectedTitle.equals(actuelTitle)){
            System.out.println("Title test PASSED");
        }else
            System.out.println("Title test FAILED "+"Title: "+driver.getTitle());
        //3
        String expectedUrl= "facebook";
        String actuelUrl= driver.getCurrentUrl();
        if (expectedUrl.contains(actuelUrl)){
            System.out.println("Url test PASSED");
        }else
            System.out.println("Url test FAILED "+"Url: "+driver.getCurrentUrl());
        //4
        driver.navigate().to("https://www.walmart.com");
        Thread.sleep(3000);
        //5
        String expectedTitle1= "walmart";
        String actuelTitle1= driver.getTitle();

        if (expectedTitle1.contains(actuelTitle1)){
            System.out.println("Title walmart iceriyor");
        }else
            System.out.println("Title walmart icermiyor "+"Title: "+driver.getTitle());
        //6
        driver.navigate().back();
        Thread.sleep(3000);
        //7
        driver.navigate().refresh();
        //8
        driver.manage().window().maximize();
        //9
        driver.close();

    }
}
