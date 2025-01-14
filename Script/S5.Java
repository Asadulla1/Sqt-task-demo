package t23;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditUserTest {

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

        // Edit User
        driver.findElement(By.linkText("User Management")).click();
        driver.findElement(By.linkText("Edit User")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("updateduser@example.com");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Validate
        if (driver.getPageSource().contains("User updated successfully")) {
            System.out.println("Edit User Test: Pass");
        } else {
            System.out.println("Edit User Test: Fail");
        }

        driver.quit();
    }
}
