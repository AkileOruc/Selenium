package ders01_SeleniumaGiris;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TekrarTesti {
   /* 1. Yeni bir class olusturun (TekrarTesti)
      2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
    doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
      3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
    doğru URL'yi yazdırın.
      4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
      5. Youtube sayfasina geri donun
      6. Sayfayi yenileyin
      7. Amazon sayfasina donun
      8. Sayfayi tamsayfa yapin
      9.Ardından sayfa başlığının"Amazon"içerip içermediğini(contains)doğrulayınYoksa doğru başlığı(ActualTitle)yazdırn
      10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
      11.Sayfayi kapatin*/


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

       //2
        driver.navigate().to("https://youtube.com");

        String expectedResult= "youtube";
        String actualResult= "YouTube";
        if (expectedResult.equals(actualResult)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED --->"+" Dogru baslik: "+ driver.getTitle());
        }
        //3
        String expectedUrl="youtube";
        String actuelUrl="youtube";
        if (actuelUrl.contains(expectedUrl)){
            System.out.println("Sayfanin Url si "+expectedUrl+ " iceriyor");
        }
        else
            System.out.println("Sayfanin Url si "+expectedUrl+" icermiyor-->"+"Url:"+driver.getCurrentUrl());
        //4
         driver.navigate().to("https://amazon.com");
         Thread.sleep(3000);
         //5
         driver.navigate().back();
         //6
         driver.navigate().refresh();
         //7
         driver.navigate().forward();
         //8
         driver.manage().window().maximize();
         //9
        String expectedTitle="Amazon";
        String actuelTitle=driver.getTitle();

        if (actuelTitle.contains(expectedTitle)){
            System.out.println("Sayfanin Title'i "+expectedTitle);
        } else
            System.out.println("Sayfanin Title'i "+expectedTitle+"Title:"+driver.getTitle());
         //10

        String expectedUrl1="https://www.amazon.com";
        String actuelUrl1=driver.getCurrentUrl();
        if (actuelUrl1.contains(expectedUrl1)){
            System.out.println("Sayfanin Url si "+expectedUrl1+" iceriyor");
        }
        else
            System.out.println("Sayfanin Url si "+expectedUrl1+" icermiyor-->"+"Url:"+driver.getCurrentUrl());
        //11
        driver.quit();
    }
}
