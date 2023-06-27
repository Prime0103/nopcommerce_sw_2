package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{
    String baseurl = "http://demo.nopcommerce.com/";
    @Before
    public void setUpBrowser(){
        //open browser and get url
        openBrowser(baseurl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //find the login link and click on the login link
        driver.findElement(By.linkText("Log in")).click();

        //find the element to get message
        String expectedText = "Welcome, Please Sign In!";
        String actualTest = driver.findElement(By.xpath("//h1")).getText();

        //verify both expected and actual Message
        Assert.assertEquals("failed to click on Login Page", expectedText,actualTest);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        // Element to click on login
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        // Element to send username
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abc123@gmail.com");

        // Element to send password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("jv123");

        //find the element to click on login button
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

        //find to get message
        String expectedMessage = "Log out";
        WebElement getmessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = getmessage.getText();

        //verify for both messages
        Assert.assertEquals("Fail to login",expectedMessage,actualMessage);

    }

    @Test
    public void verifyTheErrorMessage(){
        //find the element to click the login
        driver.findElement(By.linkText("Log in")).click();

        //find the emailfield and enter the email
        driver.findElement(By.id("Email")).sendKeys("abc123@gmail.com");

        //find the password field and enter the password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("asd123");
        //get the message
        WebElement getMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = getMessage.getText();
        Assert.assertEquals("Fail to display error message while invalid login", expectedMessage, actualMessage);

    }

    @After
    public void closeBrowser(){
        //closeing the browser
        driver.quit();
    }
}
