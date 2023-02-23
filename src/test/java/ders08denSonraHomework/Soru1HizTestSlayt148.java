package ders08denSonraHomework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseMethod;

import java.time.Duration;

public class Soru1HizTestSlayt148  {
  /*  1. Bir class olusturun : WaitTest
2. Iki tane metod olusturun : implicitWait() , explicitWait() Iki metod icin de asagidaki adimlari test edin.
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Remove butonuna basin.
5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
6. Add buttonuna basin
7. It’s back mesajinin gorunduguzu test edin*/

   @Test
   public void test01() {

   WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();

        WebElement mesaj = driver.findElement(By.xpath("//*[@id='message']"));

        Assert.assertTrue(mesaj.isDisplayed());

        driver.findElement(By.xpath("//*[@type='button']")).click();

        WebElement mesaj2 = driver.findElement(By.xpath("//*[@id=\"message\"]"));

        Assert.assertTrue(mesaj2.isDisplayed());

        driver.close();
    }

     @Test
     public void test02(){
           WebDriverManager.chromedriver().setup();
           WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();

           driver.get("https://the-internet.herokuapp.com/dynamic_controls");

           driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();


           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
           //element  gorunene kadar, visible olana kadar beklemesini istiyoruz
           WebElement itsGoneElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
           Assert.assertTrue(itsGoneElementi.isDisplayed());

         driver.close();

       }

   }

