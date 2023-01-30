package ders02_driverMethodlari_webelement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru2ikinciCozum {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(300, 500));

        int xPoz = driver.manage().window().getPosition().getX();
        int yPoz = driver.manage().window().getPosition().getY();
        int genis = driver.manage().window().getSize().getWidth();
        int yuksek = driver.manage().window().getSize().getHeight();

        System.out.println(xPoz + "  " + yPoz + "   " + genis + "  " + yuksek);

        if (xPoz == 0 && yPoz == 0 && genis == 300 && yuksek == 500) {
            System.out.println("PASS");
        } else {
            System.out.println("FAILED");
        }
        driver.quit();
    }
}
