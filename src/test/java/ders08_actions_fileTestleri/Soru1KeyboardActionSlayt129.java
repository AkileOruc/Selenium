package ders08_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class Soru1KeyboardActionSlayt129 extends TestBaseMethod {

/*1- Bir Class olusturalim KeyboardActions1
2- https://www.amazon.com sayfasina gidelim
3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
4- aramanin gerceklestigini test edin*/

@Test
    public void test1() throws InterruptedException {
//2- https://www.amazon.com sayfasina gidelim
    driver.get("https://www.amazon.com");
    WebElement aramaCubugu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

 //  3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
  // actions methodsuz :)  aramaCubugu.sendKeys("Samsung A71"+ Keys.ENTER);

    Actions actions= new Actions(driver);

    actions.clickAndHold(aramaCubugu).perform();     //istenen webelement ustunde click yapip beklemis oluruz

    actions.sendKeys("Samsung A71"+Keys.ENTER).perform();

    Thread.sleep(2000);

//4  aramanin gerceklestigini test edin*/
    WebElement ilkSonuc= driver.findElement(By.xpath("(//*[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]"));

    Assert.assertTrue(ilkSonuc.getText().contains("Samsung")&&ilkSonuc.getText().contains("A71"));
    System.out.println((ilkSonuc.getText()));
}


}
