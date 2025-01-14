package t23;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddUserTest {

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

        // Add User
        driver.findElement(By.linkText("User Management")).click();
        driver.findElement(By.linkText("Add User")).click();
        driver.findElement(By.name("username")).sendKeys("newUser");
        driver.findElement(By.name("email")).sendKeys("newuser@example.com");
        driver.findElement(By.name("password")).sendKeys("password123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Validate
        if (driver.getPageSource().contains("User added successfully")) {
            System.out.println("Add User Test: Pass");
        } else {
            System.out.println("Add User Test: Fail");
        }

        driver.quit();
    }
}