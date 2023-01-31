package ders05_junitAssertions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;
import utilities.TestBaseMethod;

public class Soru5SelectMethod extends TestBaseMethod {

    @Test

    public void test1(){
        //Amazon arama kutusunun yanindaki dropdown da bir option arayip yazdirin ve kac option oldugunu bulun


        driver.get("https://www.amazon.com");
        //arama kutusunun yanindaki dropdown locate
        WebElement dropdown=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        Select select= new Select(dropdown);

        select.selectByVisibleText("Software");

        //secilen optionu yazdirma getFirstSelectedOption methodu, ama bu bir webElement yine de get.Text yapmaliyiz

        System.out.println(select.getFirstSelectedOption().getText());
// getOptions()  bize optionlari list olarak verir size ile uzunlugunu alabiliriz
//28 e esit oldugunu test edelim Assert  ile


        int optiyonSayisi=select.getOptions().size();
        Assert.assertEquals(28,optiyonSayisi);

    }
}
