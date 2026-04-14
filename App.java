package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
    public static void main(String[] args)
    {
        // Enable verbose logs (optional for debugging)
        System.setProperty("webdriver.chrome.verboseLogging", "true");

        // Chrome options for headless Linux/Jenkins
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");          // Headless mode
        options.addArguments("--no-sandbox");            // Required for root/Jenkins
        options.addArguments("--disable-dev-shm-usage"); // Fix memory issues
        options.addArguments("--disable-gpu");           // Prevent GPU crashes
        options.addArguments("--remote-allow-origins=*");// Fix connection issues
        options.addArguments("--window-size=1920,1080"); // Avoid UI issues

        // Explicit Chrome binary path (important in Linux)
        options.setBinary("/usr/bin/google-chrome");

        // Create driver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open website
            driver.get("https://www.saucedemo.com/");

            // Perform login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Small wait (optional)
            Thread.sleep(3000);

            System.out.println("Test executed successfully!");
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            // Close browser
            driver.quit();
        }
    }
}
