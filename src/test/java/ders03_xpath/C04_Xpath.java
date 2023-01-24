package ders03_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Xpath {
    public static void main(String[] args) {

    /*  1- bir class olusturun
        2- https://www.amazon.com/ adresine gidin
        3- Browseri tam sayfa yapin
        4- Sayfayi “refresh” yapin
        5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        6- Gift Cards sekmesine basin
        7- Birthday butonuna basin
        8- Best Seller bolumunden ilk urunu tiklayin
        9- Gift card details’den 25 $’i secin
        10-Urun ucretinin 25$ oldugunu test edin
        11-Sayfayi kapatin*/
        //1
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2
        driver.get("https://www.amazon.com");
        //3
        driver.manage().window().maximize();
        //4
        driver.navigate().refresh();
        //5
        String expectedIcerik = "Spend less";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedIcerik)) {
            System.out.println("Title testi Passed");
        } else {
            System.out.println("Title testi Failed");
        }
        //6
        driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();
        //7
        driver.findElement(By.xpath("//img[@alt='Birthday']")).click();
        //8
        driver.findElement(By.xpath("(//div[@class='a-section a-spacing-mini a-spacing-top-micro acs-product-block__product-image'])" +
                "[1]")).click();     //Best Seller degisebileceginden dolayi class la yaptikilk urun dedigi icin [1] yaptik
        //9
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();
        //10
        WebElement urunUcretElementi = driver.findElement(By.xpath("//span[@id='gc-live-preview-amount']"));
        String expectedUcret = "25$";
        String actualUcret = urunUcretElementi.getText();

        if (expectedUcret.equals(actualUcret)) {
            System.out.println("Ucret testi Passed");
        } else {
            System.out.println("Ucret Testi Failed");
            System.out.println("actual ucret : " + actualUcret);
        }
        //11
        driver.close();
    }
}
