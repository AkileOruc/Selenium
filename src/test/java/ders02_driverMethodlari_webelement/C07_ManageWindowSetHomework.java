package ders02_driverMethodlari_webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_ManageWindowSetHomework {
    public static void main(String[] args) throws InterruptedException {
      /*  1. Yeni bir Class olusturalim.C07_ManageWindowSet
        2. Amazon soyfasina gidelim. https://www.amazon.com/
        3. Sayfanin konumunu ve boyutlarini yazdirin
        4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        6. Sayfayi kapatin*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        //3
        System.out.println("Sayfanin maximum konumu" + driver.manage().window().getPosition());

        System.out.println("Sayfanin maximum boyutu" + driver.manage().window().getSize());
        //4
        driver.manage().window().setPosition(new Point(-2, -2));
        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(1500, 800));
        Thread.sleep(3000);
        //5

        Point actuelPosition = driver.manage().window().getPosition();
        Dimension actuelSize = driver.manage().window().getSize();

        if (actuelPosition.getX() == -2 && actuelPosition.getY() == -2
                && actuelSize.getWidth() == 1500 && actuelSize.getHeight() == 800) {
            System.out.println("Sayfa istenen boyuta ulasti");

        }else
            System.out.println("Sayfa istenen boyuta ulasamadi");
        //6
        driver.close();
    }
}
