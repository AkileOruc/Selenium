package dersPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ders05 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() throws InterruptedException {
        // https://www.booking.com/ sayfasina gidelim
        driver.get("https://www.booking.com/");
        driver.findElement(By.xpath("//*[text()='Accepter']")).click();
        Thread.sleep(2000);
        WebElement paraBirimi= driver.findElement(By.xpath("//button[@data-testid='header-currency-picker-trigger']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(paraBirimi).click().perform();
        WebElement turkLirasi= driver.findElement(By.xpath("//*[text()='TRY']"));
//  actions.scrollToElement(turkLirasi).click(turkLirasi).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).click(turkLirasi).perform();
        WebElement dil= driver.findElement(By.xpath("//button[@data-testid='header-language-picker-trigger']"));
        actions.click(dil).perform();
        WebElement dilsecimi= driver.findElement(By.xpath("(//button[@data-testid='selection-item'])[31]"));
        actions.click(dilsecimi).perform();
        // sayfanin en altindan ulkeler kismini secelim
        actions.sendKeys(Keys.END).build().perform();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//a[@data-ga='seoindexlinks'])[1]")).click();



    }
        @After
        public void tearDown () {
            // driver.close();


        }
    }