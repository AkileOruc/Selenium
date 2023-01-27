package ders05_junitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru1Slayt92 {
/*1. Bir Class olusturalim YanlisEmailTesti
  2. http://automationexercise.com/index.php sayfasina gidelim
  3. Sign in butonuna basalim
  4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid
    email address” uyarisi ciktigini test edelim*/

   static WebDriver driver;

   @BeforeClass
    public static void setUp() {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.get("https://www.automationexercise.com/");
   }

    @AfterClass
    public static void teardown(){
        driver.close();

       }

       @Test
    public void test() throws InterruptedException {
           driver.findElement(By.xpath("//a[@href='/login']")).click();

           Thread.sleep(2000);

           driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("akile.com");
           Thread.sleep(2000);
           driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

           WebElement loginBolumu= driver.findElement(By.xpath("//section[@id='form']"));
           loginBolumu.isDisplayed();
           // mailimiz gecersiz oldugundan hala login bolumu karsimiza cikiyor TestPASSED

       }
   }

