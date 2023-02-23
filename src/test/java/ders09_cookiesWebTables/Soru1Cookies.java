package ders09_cookiesWebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseMethod;

import java.util.Set;
import java.util.concurrent.Callable;

public class Soru1Cookies extends TestBaseMethod {

    /* 1- https://www.kiwi.com sayfasina gidin
        2- tum cookie’leri listeleyin
        3- Sayfadaki cookies sayisinin 10’dan buyuk oldugunu test edin
        4- ismi SKYPICKER_AFFILIATE olan cookie degerinin "skypicker" oldugunu test edin
        5- ismi “en sevdigim cookie” ve degeri “findikli” olan bir cookie olusturun ve sayfaya ekleyin
        6- eklediginiz cookie’nin sayfaya eklendigini test edin
        7- ismi FPID olan cookie’yi silin
        8- tum cookie’leri silin ve silindigini test edin*/

    @Test
            public void test01(){
        driver.get("https://www.kiwi.com");
//2
        Set<Cookie> cookiesSeti=driver.manage().getCookies();
         int siraNo= 1;
        for (Cookie each:cookiesSeti
             ) {
            System.out.println("Cookies "+siraNo+"- "+ each);
            siraNo++;
        }
//3
        Assert.assertTrue(cookiesSeti.size()>10);

//4
        String expectedDeger="skypicker";
        String actualDeger=driver.manage().getCookieNamed("SKYPICKER_AFFILIATE").getValue();
        Assert.assertEquals(expectedDeger,actualDeger);

//5
Cookie eklenenCookie=new Cookie("enSevdigimCookie","findikli");

driver.manage().addCookie(eklenenCookie);

        cookiesSeti=driver.manage().getCookies();
        System.out.println("-----------------------------------");
        siraNo= 1;
        for (Cookie each:cookiesSeti
        ) {
            System.out.println("Cookies "+siraNo+"- "+ each);
            siraNo++;
        }
//6
     expectedDeger="findikli";
     actualDeger=driver.manage().getCookieNamed("enSevdigimCookie").getValue();
        Assert.assertEquals(expectedDeger,actualDeger);
//7
driver.manage().deleteCookieNamed("FPID");
//8
driver.manage().deleteAllCookies();
   cookiesSeti=driver.manage().getCookies();

   Assert.assertTrue(cookiesSeti.size()==0);

    }
}
