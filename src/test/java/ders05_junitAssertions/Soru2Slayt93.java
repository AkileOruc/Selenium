package ders05_junitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Soru2Slayt93 {
   /* Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    a. Verilen web sayfasına gidin.   https://the-internet.herokuapp.com/checkboxes
    b. Checkbox1 ve checkbox2 elementlerini locate edin.
    c. Checkbox1 seçili değilse onay kutusunu tıklayın
    d. Checkbox2 seçili değilse onay kutusunu tıklayin  */
   static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @AfterClass
    public static void teardown(){
        driver.close();

    }

    @Test
    public void test() throws InterruptedException {
       // b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1Tiksiz= driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));

        WebElement checkbox2= driver.findElement(By.xpath("((//input[@type='checkbox']))[2]"));



        WebElement checkbox1Tikli= driver.findElement(By.xpath("//*[@id='checkboxes']"));

       // c. Checkbox1 seçili değilse onay kutusunu tıklayın

        Assert.assertNotEquals(checkbox1Tiksiz,checkbox1Tikli);
        Thread.sleep(2000);
        checkbox1Tiksiz.click();

        //d. Checkbox2 seçili değilse onay kutusunu tıklayin  */

        Assert.assertTrue(checkbox2.isSelected());

    }
}

