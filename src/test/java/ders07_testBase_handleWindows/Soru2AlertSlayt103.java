package ders07_testBase_handleWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

public class Soru2AlertSlayt103 extends TestBaseMethod {


    @Test
    public void test() throws InterruptedException {


        // https://the-internet.herokuapp.com/javascript_alerts
        // ilk butona click yapin

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        // OK diyerek alert'i kapatin
        Thread.sleep(2000);
       driver.switchTo().alert().accept();    //bir alert cikinca boyle
        Thread.sleep(2000);
        //simdi ikinci butona tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click(); //bu sefer 2 secenek var
        Thread.sleep(200);
        driver.switchTo().alert().dismiss();     //ok degil annuler i tiklamis olduk
        Thread.sleep(2000);
        //simdi ucuncu butona tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();//bu sefer bir alan acildi
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Selenyum javadan daha guzel");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }


}
