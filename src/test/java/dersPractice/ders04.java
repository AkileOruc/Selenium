package dersPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ders04 {
    // https://www.kiwi.com sayfasina gidin
    // Cookies i reddedin
    // Sayfa basliginin "kiwi" icerdigini test edin
    // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
    // Sectiginiz dil ve para birimini dogrulayin
    // Ucus secenegi olarak tek yon secelim
    // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
    // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
    // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
    // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim
    WebDriver driver;
    String https="https://www.";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01(){
driver.get(https+"kiwi.com");

driver.findElement(By.xpath("//*[text()='Reject all']"));

        Assert.assertTrue(driver.getTitle().contains("iwi"));

driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContentChildren__StyledButtonPrimitiveContentChildren-sc-mra4yy-0 HJizW'])[2]")).click();

        WebElement dropDownLanguage=driver.findElement(By.xpath("//select[@data-test='LanguageSelect']"));
        Select select=new Select(dropDownLanguage);

        select.selectByValue("tr");
    }

    @After
    public void  tearDown(){
       // driver.close();

    }






}
