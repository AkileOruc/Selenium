package ders08denSonraHomework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

import java.util.ArrayList;
import java.util.Set;

public class Soru4HandleSlayt152 extends TestBaseMethod {
/* 1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
 5."username" ve "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
8.Ok diyerek Popup'i kapatin
9.Ilk sayfaya geri donun
10.Ilk sayfaya donuldugunu test edin*/

    @Test
    public void test01 () throws InterruptedException {
        driver.get("http://webdriveruniversity.com/");
 //2."Login Portal" a kadar asagi inin     3."Login Portal" a tiklayin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String ilkSayfaHandle= driver.getWindowHandle();
 //4.Diger window'a gecin

    driver.findElement(By.xpath("//*[text()='Login Portal']")).click();
        Thread.sleep(2000);

     //============ICINDE OLMADIGIMIZ YENI HANDLE DEGERINI BULMALIYIZ=================

      Set<String> tumHandleDegerleri= driver.getWindowHandles();
      String ikinciSayfaHandle="";

      //  System.out.println(ilkSayfaHandle);
      //  System.out.println(tumHandleDegerleri);
//SET TE index yok
        for (String each:tumHandleDegerleri
             ) {
           if (!each.equals(ikinciSayfaHandle)){
               ikinciSayfaHandle=each;

           }
        }

driver.switchTo().window(ikinciSayfaHandle);

// 5."username" ve "password" kutularina deger yazdirin

        WebElement username = driver.findElement(By.xpath("//*[@id=\"text\"]"));
        actions.doubleClick(username).perform();
        username.sendKeys("tester");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("testpassword");
        Thread.sleep(2000);

// 6."login" butonuna basin

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);
//7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
String expectedAlertText="validation failed";
String actuelAlertText=driver.switchTo().alert().getText();
Assert.assertEquals(expectedAlertText,actuelAlertText);

//8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //String validationMessage = popup.getText();
        //Assert.assertEquals("Validation failed", validationMessage);
//9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaHandle);
//10.Ilk sayfaya donuldugunu test edin*/

        Assert.assertEquals(driver.getWindowHandle(),ilkSayfaHandle);
    }

}
