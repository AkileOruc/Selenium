package ders08denSonraHomework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

public class alert extends TestBaseMethod {
@Test
public void test01() throws InterruptedException {

    driver.get("https://practice.cydeo.com/javascript_alerts");
Thread.sleep(3000);
driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();

driver.switchTo().alert().accept();

WebElement mesaj= driver.findElement(By.id("result"));
String expected="You successfully clicked an alert";

Assert.assertEquals(expected,mesaj.getText());

}

}
