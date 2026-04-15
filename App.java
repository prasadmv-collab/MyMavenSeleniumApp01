package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {

        // Optional: Set path if chromedriver is not in PATH
        // System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        // Configure Chrome for headless Linux/VM execution
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");              // Run in headless mode
        options.addArguments("--no-sandbox");                // Required for Linux/VM
        options.addArguments("--disable-dev-shm-usage");     // Prevent /dev/shm issues
        options.addArguments("--disable-gpu");               // Safe fallback
        options.addArguments("--window-size=1920,1080");     // Set resolution
        options.addArguments("--remote-allow-origins=*");    // Fix for newer Chrome

        // Optional but useful for stability
        options.addArguments("--disable-software-rasterizer");
        options.addArguments("--disable-extensions");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Open website
            driver.get("https://www.saucedemo.com/");

            // Perform login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Print page title
            System.out.println("Page Title: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always close browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
