package ders06_jsAlerts_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Soru2Slayt100 {

   /* ● Bir class oluşturun: C3_DropDownAmazon
● https://www.amazon.com/ adresine gidin.
            - Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28 oldugunu test edin
-Test 2
1. Kategori menusunden Books secenegini secin
2. Arama kutusuna Java yazin ve aratin
3. Bulunan sonuc sayisini yazdirin
4. Sonucun Java kelimesini icerdigini test edin*/

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @AfterClass
    public static void teardown(){
     driver.close();

    }

    @Test
    public void  test01() throws InterruptedException {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin(Dropdown)

        WebElement kategori= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        kategori.click();

        Select select=new Select(kategori);

       List<WebElement> kategoriList= select.getOptions();

      Assert.assertEquals(28,kategoriList.size());
    }
    @Test
    public void  test02() throws InterruptedException {
       // -Test 2
       /* 1. Kategori menusunden Books secenegini secin
        2. Arama kutusuna Java yazin ve aratin
        3. Bulunan sonuc sayisini yazdirin
        4. Sonucun Java kelimesini icerdigini test edin*/

        WebElement kategori= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(kategori);

        select.selectByVisibleText("Books");
        Thread.sleep(3000);

     WebElement arama=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
     arama.sendKeys("Java"+ Keys.ENTER);

     WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
     String expectedResault="Java";
     String actualResault=sonucYazisi.getText();

     Assert.assertTrue(actualResault.contains(expectedResault));

    }
}
