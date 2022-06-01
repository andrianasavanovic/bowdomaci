/*
Domaći:
Napisati dva smoke testa za https://www.telerik.com/support/demos:
Proveriti da klikom na Desktop odlazimo na tu sekciju
Proveriti da klikom na Mobile odlazimo na tu sekciju
Koristiti TestNG, asserte.
Domaći na git./
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://www.telerik.com/support/demos");
        //driver.navigate().refresh();
    }

    @AfterClass
    public void afterMethod(){
        driver.close();
    }



    @Test
    public void desctopSection() {
        WebElement headerElement = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        String excpectedTitle = "Desktop";
        String actualTitle = headerElement.getText();
        Assert.assertEquals(actualTitle, excpectedTitle);
    }

    @Test
    public void mobileSection() {
        WebElement headerElement = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        String excpectedTitle = "Mobile";
        String actualTitle = headerElement.getText();
        Assert.assertEquals(actualTitle, excpectedTitle);
    }
}
