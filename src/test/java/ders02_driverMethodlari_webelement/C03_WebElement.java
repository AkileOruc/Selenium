package ders02_driverMethodlari_webelement;

public class C03_WebElement {
    public static void main(String[] args) {

        /*
        biz bir web sayfasina gittigimizde gozlerimizle gordugumuz her element
        bir WebElement'tir (yazilar, buton, resim, link, yazi kutulari vb..)
        Her webelemnt bir HTML kodu ile olusturulur

        ornegin amazon anasayfadaki arama kutusu bir webelement tir ve
        arama kutusunun HTML kodlari

        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords"
        autocomplete="off" placeholder="" class="nav-input nav-progressive-attribute"
        dir="auto" tabindex="0" aria-label="" spellcheck="false">
        Herbir webelementi olusturan HTML kodunda
        1- tag : baslik demektir, kucuktur isaretinden sonra gelen ilk yazidir.
        2- attribute
        3- attribute value
        Bunlar kullanilarak webelemnti unique bir sekilde tarif etmeliyiz
        Selenium'da webelementleri locate etmek(driver'a tarif etmek) icin 8 tane locator vardir
        bunlardan ilk 6'si spesifik elementler icin kullanilabilirken
        son iki tanesi olan xpath ve css selector HER WEBELEMENT icin kullanilabilir
        spesifik elemntler icin kullanilabilecek locator'lar
        1- id
        2- classname
        3- name
        bu uc tanesi attribute ismidir ve kullanacagimiz webelementin HTML kodunda bu attribute'ler varsa kullanilir
        ornegin 14.satirda yazdigimiz amazon arama kutusu icin ucu de kullanilabilir
        cunku 3 attribute de var
        ancak bu attribute'ler kullanildiginda unique locate oluyor mu kontrol etmeliyiz
        4- tagname
        tag name ile benzersiz deger bulmak coooook zordur
        genelde cok tercih edilmez
        5- linktext
        6- partialLinktext
        sadece linkler icin kullanilirlar.
        HTML elementlerde link'ler genelde a tag'i ile olusturulur
        eger link'teki tum yazi ile tarif edeceksek linkText
        eger yazinin tamamini degil de bir bolumu ile tarif edeceksek
        partialLinkText kullanilir
         */
        /*
          Selenium'da 8 adet Locator vardir
          bunlardan 6 tanesi HTML uzerindeki tag veya attribute'lere goredir
          2 tanesi ise daha spesifik olarak, ilk 6 tane locator ile bulamadigimiz
          webElementleri locate etmek icin kullanilir
          1- By.id
             id genelde unique verilir
             dolayisiyla bir HTML elementde id varsa once By.id denenebilir
          2- className
             class attribute'u genelde ayni islevi yapan webelementleri gruplandirmak icin kullanilir
             bu gruplandirmalar sayesinde css ile gruptaki tum webElementler tek yerden sekillendirilebilir
             class attribute'u kullanilirken eger class value'u space iceriyorsa,
             classname ile yapilan locate'ler hata verebilir
             genellikle classname ile yapilan locate'ler birden fazla webelement dondureceginden
             List<WebElement> seklinde olusturacagimiz bir List'e kaydolur
             Bu listedeki elementler WebElement oldugu icin
             bu liste direk yazdirilamaz,
             bunun yerine for-each loop kullanilarak webElement ozellikleri yazdirilabilir
           3- name
              eger HTML kodunda name attribute varsa kullanilabilir
           4- tagname
              tagname de classname gibi gruplandirmalar icin kullanilir
              dolayisiyla tagname ile genelde bir element degil
              benzer ozelliklerdeki bir listeye ulasilir
           5- linkText
              sadece link'ler icin kullanilir
              her link HTML elementinin uzerinde bir link yazisi olur
              bu yazi genelde kullanicinin front-end'de gortdugu yazi ile aynidir
              ncak bazen space gibi farkedemeyecegimiz eklemeler olabilir
              locate ederken linktext kullanilirsa, link yazisinin tamami kullanilmalidir
              (varsa bosluk vb... locate alinirken yazilmalidir"
           6- partialLinkText
              linktext gibi sadece linkler icin kullanilir
              linktext'den farki, tum yaziyi degil parcasini kullanmamizin da yeterli olmasidir.
         */



    }

    }

