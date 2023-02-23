package ders09_cookiesWebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseMethod;

import java.util.List;

public class Soru2WebTables extends TestBaseMethod {
/*1."https://money.rediff.com" adresine gidin
2.Sayfanin en altina inin
3.Web table tum body’sini yazdirin
4.Web table’daki satir sayisinin 3 oldugunu test edin
5.Tum satirlari yazdirin
6. Web table’daki sutun sayisinin 5 olduğunu test edin
7. 5.sutunu yazdirin
8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun*/

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://money.rediff.com");
        Actions actions = new Actions(driver);
//2
        actions.sendKeys(Keys.END).perform();

        Thread.sleep(2000);
//3
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));

        //System.out.println(tumBody.getText());
//4
        List<WebElement> satirListesi = driver.findElements(By.xpath("//tbody/tr"));

        Assert.assertTrue(satirListesi.size() == 2);
//5
        int satirNo = 1;
        for (WebElement eachSatir : satirListesi
        ) {
            System.out.println("======Satir " + satirNo);
            System.out.println(eachSatir.getText());
            satirNo++;

//6
            List<WebElement> ilkSatirElementleri = driver.findElements(By.xpath("//tbody/tr[1]/td"));

            Assert.assertTrue(ilkSatirElementleri.size() == 5);

//7
            List<WebElement> ikinciSutunElementler = driver.findElements(By.xpath("//tbody/tr[1]/td[2]"));
            for (WebElement eachElement : ikinciSutunElementler
            ) {
                System.out.println("======ikinci Sutun Elementleri ");
                System.out.println(eachElement.getText());

//8

                System.out.println("==================\n"+ReusableMethods.getCellValue(2,3));


            }
        }
    }
}
