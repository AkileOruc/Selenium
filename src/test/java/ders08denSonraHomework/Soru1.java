package ders08denSonraHomework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

public class Soru1 extends TestBaseMethod {
  /*  1. Bir class olusturun : WaitTest
2. Iki tane metod olusturun : implicitWait() , explicitWait() Iki metod icin de asagidaki adimlari test edin.
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Remove butonuna basin.
5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
6. Add buttonuna basin
7. It’s back mesajinin gorunduguzu test edin*/

   @Test

    public void test01(){
      driver.get("https://the-internet.herokuapp.com/dynamic_controls");

      driver.findElement(By.xpath("//*[@*='swapCheckbox()']")).click();


     WebElement mesaj= driver.findElement(By.xpath("//*[@id='message']"));

     Assert.assertTrue(mesaj.isDisplayed());


      driver.findElement(By.xpath("//*[@type='button']")).click();


     WebElement mesaj2= driver.findElement(By.xpath("//*[@id=\"message\"]"));

     Assert.assertTrue(mesaj2.isDisplayed());





   }






}
