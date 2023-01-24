package ders02_driverMethodlari_webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_ManageWindowHomework {
/*1. Yeni bir Class olusturalim.C06_ManageWindow
  2. Amazon soyfasina gidelim. https://www.amazon.com/
  3. Sayfanin konumunu ve boyutlarini yazdirin
  4. Sayfayi simge durumuna getirin
  5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
  6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
  7. Sayfayi fullscreen yapin
  8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
  9. Sayfayi kapatin*/

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2
        driver.get("https://amazon.com");
        //3
        System.out.println(driver.manage().window().getPosition());    //(-8, -8)
        System.out.println(driver.manage().window().getSize());        //(1552, 832)
        //4
        driver.manage().window().minimize();
        //5
        Thread.sleep(3000);
        driver.manage().window().maximize();
        //6
        System.out.println(driver.manage().window().getPosition());  //(-8, -8)
        System.out.println(driver.manage().window().getSize());      //(1552, 832)
        //7
        driver.manage().window().fullscreen();
        //8
        System.out.println(driver.manage().window().getPosition());  //(0,0)
        System.out.println(driver.manage().window().getSize());    // (1536, 864)
        //9
        driver.close();






    }

}
