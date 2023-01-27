package ders03_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru1Xpath {

    public static void main(String[] args) throws InterruptedException {
     /* 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        2- Add Element butonuna basin
        3- Delete butonu’nun gorunur oldugunu test edin
        4- Delete tusuna basin
        5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1
        driver.get(" https://the-internet.herokuapp.com/add_remove_elements/");
        //2
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        //3
        WebElement DeleteButonu = driver.findElement(By.xpath(" //button[text()= 'Delete']"));
        if (DeleteButonu.isDisplayed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        Thread.sleep(2000);

        //4
        DeleteButonu.click();
        //5
        WebElement AddRemoveButonu = driver.findElement(By.xpath(" //h3[text()= 'Add/Remove Elements']"));
        if (AddRemoveButonu.isDisplayed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
