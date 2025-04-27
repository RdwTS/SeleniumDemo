import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Selenium {

    @Test
    public void helloJayJay(){
        //browser
        WebDriver driver = WebDriverManager.chromedriver().create();
        //url
        driver.get("https://jayjay.co/");
        //get element attribute
//        String text = driver.findElement(By.className("content-info")).getText();
        String text = driver.findElement(By.cssSelector(".content-info h1")).getText();
        text = text.replace("\n", " ").trim();

        // Validasi teks lengkap
        assertEquals("Belajar dari para ahli terbaik berdasarkan program Eropa", text);
        //validasi
//        assertEquals("Belajar dari para ahli terbaik",text);

    }

    @Test
    public void sauceDemoTest() throws InterruptedException {
        WebDriver browser = WebDriverManager.chromedriver().create();
        browser.get("https://www.saucedemo.com/");

        //locator Css
        browser.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");

        //locate Xpath
        browser.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");

        //locator Id
        browser.findElement(By.id("login-button")).click();

        Thread.sleep(2000);

    }

    @Test
    public void browserMethodTest(){
        WebDriver browser = WebDriverManager.chromedriver().create();
        browser.get("https://www.saucedemo.com/");

        String title = browser.getTitle();
        String currentURL = browser.getCurrentUrl();

        System.out.println("TITLE PADA HALAMAN WEB INI : "+title);
        System.out.println("URL SAAT INI PADA HALAMAN WEB INI : "+currentURL);

    }

    @Test
    public void navigationMethodTest () throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.navigate().to("https://www.saucedemo.com/");
        driver.navigate().refresh();
        driver.navigate().to("https://www.jayjay.co/");
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);

        String title = driver.getTitle();
        String currentURL = driver.getCurrentUrl();

        System.out.println("TITLE PADA HALAMAN WEB INI : "+title);
        System.out.println("URL SAAT INI PADA HALAMAN WEB INI : "+currentURL);

    }

    @Test
    public void loginTestWithImplicitWait (){
        WebDriver driver = WebDriverManager.chromedriver().create();

        //implicit Wait
        //menunggu beberapa waktu sebelum cari elemen di halaman.
        //Jadi, misalnya halaman web loading lambat, atau elemen belum langsung muncul, WebDriver nggak langsung error ("element not found").
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText());
    }

}
