package ders02_driverMethodlari_webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

           /*
            Wait konusu ilerde detayli olarak anlatilacak
            su an icin bilmemiz gereken kismi
            implicitlyWait sayfanin yuklenmesi ve
            kullanilacak webelementlerinin bulunmasi icin bir sure belirler
            bu sure icerisinde gorevi yapabilirse hemen yoluna devam eder
            belirlenen sure bittiginde hala gorev yapilamadi ise
            hata verir
         */



        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
        System.out.println("maximal boyutta position"+driver.manage().window().getPosition());

        System.out.println("maximal boyutta size"+driver.manage().window().getSize());



        driver.manage().window().fullscreen();
        Thread.sleep(2000);

        System.out.println("fullscreen boyutta position"+ driver.manage().window().getPosition());
        System.out.println("fullscreen boyutta size"+ driver.manage().window().getSize());

        //istedigimiz boyuta getirme

        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(200,200));
        driver.manage().window().setPosition(new Point(34,34));
        System.out.println("istenen boyutta position"+ driver.manage().window().getPosition());
        System.out.println("istenen boyutta size"+ driver.manage().window().getSize());

        driver.close();
    }

}
