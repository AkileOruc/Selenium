package ders03_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RelativeXpath {
    public static void main(String[] args) throws InterruptedException {
     /* 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        2- Add Element butonuna basin
        3- Delete butonu’nun gorunur oldugunu test edin
        4- Delete tusuna basin
        5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         //1
        driver.get("https://the-internet.herokuapp.com/add_remove_elements");
         //2
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
         //3
        WebElement deleteButonu = driver.findElement(By.xpath("//button[@class='added-manually']"));

     if (deleteButonu.isDisplayed()){
     System.out.println("test Passed");
     }else {
     System.out.println("test Failed");
      }
     Thread.sleep(2000);
          //4
        deleteButonu.click();
          //5
        // boyleydi  biz icinden h3 u alip  //h3  yazdik--> <h3>Add/Remove Elements</h3>

      WebElement addRemoveYaziElementi=driver.findElement(By.xpath("//h3"));

      if (addRemoveYaziElementi.isDisplayed()){
          System.out.println("Add remove yazisi gorunuyor , test Passed");
       }else{
        System.out.println("Add remove yazisi gorunmuyor, Test FAILED");
          Thread.sleep(2000);
          driver.close();
      }
    }
}
