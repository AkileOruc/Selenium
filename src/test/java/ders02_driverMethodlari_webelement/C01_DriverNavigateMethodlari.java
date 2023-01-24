package ders02_driverMethodlari_webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        driver.navigate().to("https://www.wisequarter.com");
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();   //forward kullanabilmek icin back ile gitmek gerekir
        Thread.sleep(2000);

        driver.close();
    }
}
