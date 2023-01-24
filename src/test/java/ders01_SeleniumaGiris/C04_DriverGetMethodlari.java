package ders01_SeleniumaGiris;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

public class C04_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {
        // Otomasyonun ilk adimi driver i olusturmak ve bunun icin gerekli ayarlari yapmaktir

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wisequarter.com");


        System.out.println(driver.getCurrentUrl());   //https://wisequarter.com/
        System.out.println(driver.getTitle());       //IT Bootcamp, Distance education method - Wise Quarter Course

        System.out.println(driver.getPageSource());  // kaynagini dondurur

        System.out.println(driver.getWindowHandle());  //CDwindow-51BF42CAD6DE0E828F339511CD8A1CAF

        //Her olusturuldugunda benzersiz handle degerler alir

        //System.out.println(driver.getWindowHandles());  birden fazla sayfa icin


        Thread.sleep(5000);
        driver.close();
       // driver.quit();  tum sayfalari kapatir


    }
}
