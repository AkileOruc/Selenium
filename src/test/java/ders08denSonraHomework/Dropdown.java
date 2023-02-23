package ders08denSonraHomework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;
import utilities.TestBaseMethod;

public class Dropdown extends TestBaseMethod {



    @Test
  public void test01() throws InterruptedException {
 driver.get("https://practice.cydeo.com/dropdown");

WebElement ddm1=driver.findElement(By.id("dropdown"));

        Select select=new Select(ddm1);
        select.selectByValue("2");
select.getFirstSelectedOption().getText();
Thread.sleep(2000);

        WebElement ddm2=driver.findElement(By.id("year"));

        select.selectByVisibleText("2022");
        select.getFirstSelectedOption().getText();

        WebElement ddm3=driver.findElement(By.id("year"));

        select.selectByValue("April");
        select.getFirstSelectedOption().getText();

        WebElement ddm4=driver.findElement(By.id("day"));

        select.selectByValue("10");
        select.getFirstSelectedOption().getText();



    }

}
