import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeTest {

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("1111");
        browser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = browser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }

    // Проверка поля "Zip Code" на буквы
    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("abcde");
        browser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = browser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }

    //Проверка корректного ввода "Zip Code"
    @Test
    public void test3() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value = Continue]")).click();
        WebElement email = browser.findElement(By.name("email"));
        Assert.assertTrue(email.isDisplayed());
        browser.quit();
    }

    //Проверка поля "Zip Code" на символы
    @Test
    public void test4() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("%$^&");
        browser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = browser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();

    }
    //Проверка длины "Zip Code", ввод более 5 цифр
    @Test
    public void test5() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("111111");
        browser.findElement(By.cssSelector("[value = Continue]")).click();
        String errorMessage = browser.findElement(By.cssSelector("[class = error_message]")).getText();
        Assert.assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }
}