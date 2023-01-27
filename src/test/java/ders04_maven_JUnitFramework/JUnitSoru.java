package ders04_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JUnitSoru {
 /*1. “https://www.saucedemo.com” Adresine gidin
   2. Username kutusuna “standard_user” yazdirin
   3. Password kutusuna “secret_sauce” yazdirin
   4. Login tusuna basin
   5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
   6. Add to Cart butonuna basin
   7. Alisveris sepetine tiklayin
   8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
   9. Sayfayi kapatin*/

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }
        @Test

        public void test01 () throws InterruptedException {
        driver.get("https://www.saucedemo.com");

            driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
            Thread.sleep(2000);
        }
    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(2000);
        WebElement ilkElement = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        ilkElement.getText();
        driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test03() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
        WebElement ilkElement = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String itemNameInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        if (ilkElement.equals(itemNameInCart))
        {
            System.out.println("Ürün başarıyla sepete eklendi.");
        } else

        {
            System.out.println("Ürün sepete eklenirken hata oluştu.");
        }
    }
}
