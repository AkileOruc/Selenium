package ders02_driverMethodlari_webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru4AmazonAramaTestiSlayt38 {
    public static void main(String[] args) throws InterruptedException {
      /*  Amazon Arama Testi
        1- Bir test class’i olusturun ilgili ayarlari yapin
        2- https://www.amazon.com adresine gidin
        3- amazon arama kutusunu locate edin
        4- arama kutusuna “Nutella” yazdirin
        5- arama islemini yapabilmek icin ENTER tusuna basin*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2
        driver.get("https://www.amazon.com");
        //3
        WebElement boite= driver.findElement(By.id("twotabsearchtextbox"));
        //4
        boite.sendKeys("Nutella"+Keys.ENTER);
        Thread.sleep(2000);

        boite= driver.findElement(By.id("twotabsearchtextbox"));

        driver.close();






    }
}
