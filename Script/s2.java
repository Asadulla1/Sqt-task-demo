package t23;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditProductTest {

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

        // Navigate to "Edit Product"
        driver.findElement(By.linkText("Product Management")).click();
        driver.findElement(By.linkText("Edit Product")).click();

        // Edit product details
        driver.findElement(By.name("price")).clear();
        driver.findElement(By.name("price")).sendKeys("150");

        // Save
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Validate
        String actual_url = driver.getCurrentUrl();
        if (actual_url.contains("product_list")) {
            System.out.println("Edit Product Test: Pass");
        } else {
            System.out.println("Edit Product Test: Fail");
        }

        driver.quit();
    }
}
