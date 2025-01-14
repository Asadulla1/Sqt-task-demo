package t23;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteProductTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Libs\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        // Login
        driver.get("http://collaborativemanagementsystemsqa.free.nf/view/login.php");
        driver.findElement(By.name("username")).sendKeys("foo");
        driver.findElement(By.name("password")).sendKeys("fjfj");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);

        // Delete Product
        driver.findElement(By.linkText("Product Management")).click();
        driver.findElement(By.linkText("Delete Product")).click();
        driver.findElement(By.name("confirm")).click();

        // Validate
        if (driver.getPageSource().contains("Product deleted successfully")) {
            System.out.println("Delete Product Test: Pass");
        } else {
            System.out.println("Delete Product Test: Fail");
        }

        driver.quit();
    }
}
