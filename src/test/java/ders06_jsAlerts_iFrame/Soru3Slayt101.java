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

import java.time.Duration;

public class Soru3Slayt101 {
/*1. http://zero.webappsecurity.com/ Adresine gidin
 2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
    kontrol edin.*/

static WebDriver driver;

@BeforeClass
    public static void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.manage().window().maximize();
    driver.get(" http://zero.webappsecurity.com/");
}
@AfterClass
    public static void teardown() {
    driver.close();
}

   @Test
   public void test(){
    //2. Sign in butonuna basin
      driver.findElement(By.xpath("//*[@id='signin_button']")).click();

    //3. Login kutusuna “username” yazin
       driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");

    //4. Password kutusuna “password.” yazin
       driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

    //5. Sign in tusuna basin
       driver.findElement(By.xpath("//*[@value='Sign in']")).click();

       // burada back yapmamiz gerekiyor
       driver.navigate().back();
    //6. Online banking menusunden Pay Bills sayfasina gidin
    driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
    driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
       //7. “Purchase Foreign Currency” tusuna basin

    driver.findElement(By.xpath("(//*[@class='ui-state-default ui-corner-top'])[2]")).click();
       //8. “Currency” drop down menusunden Eurozone’u secin

    driver.findElement(By.xpath("//*[@id='pc_currency']")).sendKeys("Eurozone");

       //9. “amount” kutusuna bir sayi girin
    driver.findElement(By.xpath("(//*[@name='amount'])[2]")).sendKeys("100");

    //10. “US Dollars” in secilmedigini test edin

    WebElement dolarButonu=driver.findElement(By.xpath("//*[@id='pc_inDollars_true']"));

    Assert.assertFalse(dolarButonu.isSelected());

     //11. “Selected currency” butonunu secin
       driver.findElement(By.xpath("(//*[@type='radio'])[2]")).click();

      //12 “Calculate Costs” butonuna basin sonra “purchase” butonuna basin

       driver.findElement(By.xpath("(//*[@type='radio'])[2]")).click();




    }
}


