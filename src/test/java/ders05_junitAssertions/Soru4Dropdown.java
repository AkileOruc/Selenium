package ders05_junitAssertions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseMethod;

public class Soru4Dropdown extends TestBaseMethod {
@Test
    public void test1() throws InterruptedException {

    driver.get("https://www.amazon.com");
    //arama kutusunun yanindaki dropdown dan Baby i secelim
    WebElement dropdown=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

    Select select= new Select(dropdown);

    select.selectByVisibleText("Baby");
//arama kutusuna girl yazip aratalim

    WebElement aramaCubugu =driver.findElement(By.xpath("//*[@aria-label='Search Amazon']"));
    aramaCubugu.sendKeys("girl"+ Keys.ENTER);

    WebElement sonuc =driver.findElement(By.xpath("//*[@cel_widget_id='UPPER-RESULT_INFO_BAR-0']"));

    //kac sonuc buldugunu yazdiralim
     //1-24 of over 50,000 results for "girl"

    String sonucYazisi=sonuc.getText();

    String[] sonucArr= sonucYazisi.split(" ");

    String sonucSayisiStr= sonucArr[3];

    sonucSayisiStr=sonucSayisiStr.replaceAll("\\D","");

    System.out.println("Cikan sonuc sayisi: "+sonucSayisiStr);

Thread.sleep(3000);



}

}
