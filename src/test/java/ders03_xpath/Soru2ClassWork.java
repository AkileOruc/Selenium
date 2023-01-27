package ders03_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Soru2ClassWork {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

      /*  Class Work Amazon Search Test
        1- https://www.amazon.com/ sayfasina gidelim
        2- arama kutusunu locate edelim
        3- “Samsung headphones” ile arama yapalim
        4- Bulunan sonuc sayisini yazdiralim
        5- Ilk urunu tiklayalim
        6- Sayfadaki tum basliklari yazdiralim*/
        //1
        driver.get("https://www.amazon.com/");
        //2
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        //3
        aramaKutusu.sendKeys("Samsung headphones"+Keys.ENTER) ;
        //4
        WebElement aramaSonucu= driver.findElement(By.xpath("//div[@class='sg-col-inner'] "));
        System.out.println(aramaSonucu.getText());

        String sonucSayisiStr=aramaSonucu.getText();// 1-16 of 243 results for "Samsung headphones"

      sonucSayisiStr=sonucSayisiStr.substring((sonucSayisiStr.indexOf("of")+3),(sonucSayisiStr.indexOf("results")-1));
        System.out.println(sonucSayisiStr);
        //5
       WebElement ilkUrun= driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]"));
       ilkUrun.click();
       //6 tum basliklari yazdirmak icin geri gitmeliyiz
        driver.navigate().back();
        List<WebElement> basliklarListesi= driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));

        for (WebElement each:basliklarListesi
             ) {
            System.out.println(each.getText());

        }
        driver.close();

    }
}
