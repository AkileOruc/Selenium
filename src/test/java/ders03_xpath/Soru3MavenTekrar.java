package ders03_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru3MavenTekrar {
    public static void main(String[] args) throws InterruptedException {
       /* 1- C01_TekrarTesti isimli bir class olusturun
        2- https://www.google.com/ adresine gidin
        3- cookies uyarisini kabul ederek kapatin
        4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        5- Arama cubuguna “Nutella” yazip aratin
        6- Bulunan sonuc sayisini yazdirin
        7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        8- Sayfayi kapatin*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        //3
        driver.findElement(By.xpath("//*[text()='Tout accepter']")).click();
        //4
        String expectedTitle="Google";
        WebElement yaziElementi = driver.findElement(By.xpath("//img[@height='92']"));
        String actualTitle=yaziElementi.getText();

        if (expectedTitle.contains(actualTitle)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        //5
        WebElement arabaCubugu= driver.findElement(By.xpath("//input[@class='gLFyf']"));
        arabaCubugu.sendKeys("Nutella"+ Keys.ENTER);
        Thread.sleep(2000);

        //6
        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
        //Environ 153 000 000 résultats (0,26 secondes)
        //7
        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));


        int baslangic =result.getText().indexOf(" ", result.getText().indexOf("Environ") + 1);
        int bitis = result.getText().indexOf("résultats"+1);
        int sonuc =Integer.parseInt(result.getText().substring(baslangic,bitis));
        if (sonuc > 10000000) {
            System.out.println("10Milyondan fazla, Test PASSED");
        } else {
            System.out.println("10 Milyondan az, Test FAILED");

        }
        driver.close();
        }
    }

