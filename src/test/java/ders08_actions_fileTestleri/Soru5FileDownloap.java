package ders08_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseMethod;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Soru5FileDownloap extends TestBaseMethod {


   @Test
    public void test01() throws InterruptedException {

       //2. https://the-internet.herokuapp.com/download adresine gidelim.
       //3.  img.png dosyasını indirelim

driver.get("https://the-internet.herokuapp.com/download");

driver.findElement(By.xpath("//*[text()='img.png']")).click();
       Thread.sleep(5000);

String dosyaYolu= System.getProperty("user.home")+"/Downloads/img.png";
     //  Files.exists(Paths.get(dosyaYolu));    // true veya false
       Assert.assertTrue( Files.exists(Paths.get(dosyaYolu)));


    }

}
