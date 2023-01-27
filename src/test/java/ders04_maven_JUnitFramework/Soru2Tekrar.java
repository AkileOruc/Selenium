package ders04_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.time.Duration;

public class Soru2Tekrar {
/*1. http://zero.webappsecurity.com sayfasina gidin
  2. Signin butonuna tiklayin
  3. Login alanine “username” yazdirin
  4. Password alanina “password” yazdirin
  5. Sign in buttonuna tiklayin ve bir onceki sayfaya gidin
  6. Online banking menusunden Pay Bills sayfasina gidin
  7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
  8. tarih kismina “2020-09-10” yazdirin
  9. Pay buttonuna tiklayin
  10. “The payment was successfully submitted.” mesajinin ciktigini test edin*/

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1
        driver.get("http://zero.webappsecurity.com");
        //2
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //3
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //4
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //5
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();
        //6
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //7
        driver.findElement(By.xpath(" //input[@id='sp_amount']")).sendKeys("200");
        //8
        driver.findElement(By.xpath(" //input[@id='sp_date']")).sendKeys("2020-09-10");
        //9
        driver.findElement(By.xpath(" //input[@type='submit']")).click();
        //10
        driver.findElement(By.xpath(" //div[@style='display: block;']")).click();
        //11
        WebElement mesajElement = driver.findElement(By.xpath("//div[@id='alert_content']"));
        if (((WebElement) mesajElement).isDisplayed()) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Mesaj gorunmuyor, testFAILED");

            driver.close();
        }
    }
}
