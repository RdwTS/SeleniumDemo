import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public void sauceDemoTest(){
        WebDriver browser = WebDriverManager.chromedriver().create();
        browser.get("https://www.saucedemo.com/");

        //locator Css
        browser.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");

        //locate Xpath
        browser.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");

        //locator Id
        browser.findElement(By.id("login-button")).click();

    }

}
