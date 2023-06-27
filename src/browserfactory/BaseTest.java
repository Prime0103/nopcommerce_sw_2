package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest
{
    public static WebDriver driver;
    String baseUrl = "https://demo.nopcommerce.com/";
    public void openBrowser(String baseUrl)
    {
        driver= new ChromeDriver();
        // Launch the Browser
        driver.get(baseUrl);
        //Launch the Url into the browser
        driver.manage().window().maximize();
        //Maximize the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // We give implicit time to driver
        System.out.println("Title is :"+driver.getTitle());
        // Get the Title of the web page
    }
    public void closeBrowser()
    {
        driver.close();
        // Close the Browser
    }
}
