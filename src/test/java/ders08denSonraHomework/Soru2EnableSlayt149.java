package ders08denSonraHomework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class Soru2EnableSlayt149 extends TestBaseMethod {
/* 1. Bir class olusturun : EnableTest
   2. Bir metod olusturun : isEnabled()
   3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
   4. Textbox’in etkin olmadigini(enabled) dogrulayın
   5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
   6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
   7. Textbox’in etkin oldugunu(enabled) dogrulayın.*/

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

//4. Textbox’in etkin olmadigini(enabled) dogrulayın

        WebElement texbox=driver.findElement(By.xpath("//*[@type='text']"));

        Assert.assertFalse(texbox.isEnabled());

// 5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        driver.findElement(By.xpath("(//*[@autocomplete='off'])[2]")).click();
        Thread.sleep(2000);

// 6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

       WebElement mesaj= driver.findElement(By.xpath("//*[@id='message']"));
       Assert.assertEquals(mesaj.getText(),"It's enabled!");

//7. Textbox’in etkin oldugunu(enabled) dogrulayın.*/
        WebElement texBox= driver.findElement(By.xpath("//*[@type='text']"));

        Actions actions=new Actions(driver);
        actions.moveToElement(texBox).click();

        Thread.sleep(2000);
        Assert.assertTrue(texbox.isEnabled());

    }

}

