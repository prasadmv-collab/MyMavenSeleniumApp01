package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");

        // Stability flags for Linux/VM
        options.addArguments("--disable-software-rasterizer");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-background-networking");
        options.addArguments("--disable-sync");
        options.addArguments("--metrics-recording-only");
        options.addArguments("--disable-default-apps");
        options.addArguments("--no-first-run");
        options.addArguments("--disable-notifications");

        // Optional (safe)
        options.setBinary("/usr/bin/google-chrome");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            System.out.println("Page Title: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
