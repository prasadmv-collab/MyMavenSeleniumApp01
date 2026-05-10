package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ---------------------------------------------------
        // SauceDemo Automation
        // ---------------------------------------------------
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        // Enter Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        Thread.sleep(2000);

        // Enter Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        Thread.sleep(2000);

        // Click Login
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(4000);

        // Print success message
        System.out.println("Login Successful on SauceDemo!");

        Thread.sleep(3000);

        driver.quit();
    }
}
