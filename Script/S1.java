package t23;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddProductTest {

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

        // Navigate to "Add Product"
        driver.findElement(By.linkText("Product Management")).click();
        driver.findElement(By.linkText("Add Product")).click();

        // Fill in product details
        driver.findElement(By.name("product_name")).sendKeys("Sample Product");
        driver.findElement(By.name("price")).sendKeys("100");
        driver.findElement(By.name("description")).sendKeys("This is a sample product.");

        // Save
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Validate
        String actual_url = driver.getCurrentUrl();
        if (actual_url.contains("product_list")) {
            System.out.println("Add Product Test: Pass");
        } else {
            System.out.println("Add Product Test: Fail");
        }

        driver.quit();
    }
}
