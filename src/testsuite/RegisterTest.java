package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;

public class RegisterTest extends BaseTest
{
    String baseurl = "https://demo.nopcommerce.com";
    String email;

    @Before
    public void setUp() {
        // Open browser and launch base url
        openBrowser(baseurl);
    }

    @Test
    public void UserShouldNavigateToRegisterPageSuccessfully(){
        String expectedMessage = "Register";
        //element to click on register tab
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //element to get the message
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        //verification of actual and expected message
        Assert.assertEquals("fail to click on register tab",expectedMessage,actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {

        String uuid = UUID.randomUUID().toString();
        email = "admin" + uuid + "@gmail.com";

        // click on the ‘Register’ link
        driver.findElement(By.xpath("//div[@class='header-upper']//a[text()='Register']")).click();
        // Select gender radio button
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        // Enter First name
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("joy");
        // Enter Last name
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Cash");
        //Select Day Month and Year
        Select select = new Select(driver.findElement(By.name("DateOfBirthDay")));
        select.selectByVisibleText("4");
        // driver.findElement(By.xpath("//div[@class='form-fields']//label[text()='Date of birth:']")).click();
        select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        select.selectByVisibleText("March");
        select = new Select(driver.findElement(By.name("DateOfBirthYear")));
        select.selectByVisibleText("1992");
        // Enter Email address
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        //  Enter Password
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("admin123");
        // Enter Confirm password
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("admin123");
        // Click on REGISTER button
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
    }

    @After
    public void tearDown() {
        // close browser method
        closeBrowser();
    }


}
