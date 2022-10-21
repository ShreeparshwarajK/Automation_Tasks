
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class First_Sample {
    public static void main(String[] args)  {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //1. Launch the URL-https://qa2.enphaseenergy.com/web/
        driver.get("https://qa2.enphaseenergy.com/web/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //2. Enter the email id:Automationtraining123@mailinator.com
        WebElement emailTextField = driver.findElement(By.id("email"));
        emailTextField.sendKeys("Automationtraining123@mailinator.com");

        //3. Enter the password: Test@123
        WebElement passwordTextField = driver.findElement(By.id("password"));
        passwordTextField.sendKeys("Test@123");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        System.out.println("Successfully Logged in");

        //4. Assert that you are on the "Meet the all-in-one solar and storage system" page
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actualTitle = "Meet the all-in-one solar and storage system";
        WebElement expectedTitleLabel = driver.findElement(By.className("postlogin__web-title"));
        Assert.assertEquals(actualTitle,expectedTitleLabel.getText(),"Expected Title Name is not matching with the Actual Title name");
        System.out.println("Title assertion is done");

        //5. Logout from the application
        WebElement hamburgerMenu = driver.findElement(By.xpath("//div[@role='button']/following::span[6]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", hamburgerMenu);
        System.out.println("clicked on Hamburger menu");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement logoutButton = driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
        js.executeScript("arguments[0].click();", logoutButton);
        System.out.println("Successfully Signed out");
        driver.close();

    }
}