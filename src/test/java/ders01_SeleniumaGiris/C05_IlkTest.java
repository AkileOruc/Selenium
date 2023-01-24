package ders01_SeleniumaGiris;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_IlkTest {
    public static void main(String[] args) {
        // Gerekli ayarlamalari yapip driver i olusturun
        // sonra amazon anasayfaya gidin sonra gittiginizi test edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        //Tester olarak tum isimiz expected deger ile actuel degeri karsilastirmaktir
        //Eger 2 si de ayni ise test PASSED , ayni degilse FAILED olur

        //testi nasil yapacagimiz soylenmedigi icin kendi yontemimizi belirleyebiliriz
        //ben bu test icin gerceklesen(actuel) url in amazon kelimesi icerdigini kontrol edecegim
        String expectedMetin= "amazon";
        String actuelUrl= driver.getCurrentUrl();

        if (actuelUrl.contains(expectedMetin)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

    }
}
