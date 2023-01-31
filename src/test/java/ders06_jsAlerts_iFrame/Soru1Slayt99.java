package ders06_jsAlerts_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Soru1Slayt99 {
/* Bir class oluşturun: DropDown
● https://the-internet.herokuapp.com/dropdown adresine gidin.
1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
4.Tüm dropdown değerleri(value) yazdırın
5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,degilse False yazdırın.*/

    static WebDriver driver;

    @BeforeClass
   public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
   @AfterClass
   public static void teardown() {
      driver.close();

   }
        @Test
                public void test01(){
     WebElement dropdown=driver.findElement(By.xpath("//*[@id='dropdown']"));
          //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
            Select select=new Select(dropdown);

          select.selectByIndex(1);

            System.out.println("Seçenek 1: " +select.getFirstSelectedOption().getText());
            //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

          select.selectByValue("2");
            System.out.println("Seçenek 2: " + select.getFirstSelectedOption().getText());

            //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
            select.selectByVisibleText("Option 1");
            System.out.println("Seçenek 1: " + select.getFirstSelectedOption().getText());

            //4.Tüm dropdown değerleri(value) yazdırın
           List<WebElement> tumDdmdeg=select.getOptions();
            for (WebElement each:tumDdmdeg
            )
            {
                    System.out.println(each.getText());
            }
             //5  Dropdown’da 4 öğe varsa konsolda True ,degilse False yazdırın.
                if(tumDdmdeg.size() == 4)
                    System.out.println("True");
                else
                    System.out.println("False");



        }
   }

