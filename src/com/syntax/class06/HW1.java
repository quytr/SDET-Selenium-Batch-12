package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {
    /*
    Navigate to https://syntaxprojects.com/bootstrap-iframe.php
    verify the header text AUTOMATION TESTING PLATFORM BY SYNTAX is displayed
    verify enroll today button is enabled
     */
    public static String url = "https://syntaxprojects.com/bootstrap-iframe.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement header = driver.findElement(By.linkText("AUTOMATION TESTING PLATFORM BY SYNTAX"));
        System.out.println("The header AUTOMATION TESTING PLATFORM BY SYNTAX is displayed: " + header.isDisplayed());

        driver.switchTo().frame(1);
        WebElement enrollButton = driver.findElement(By.className("text-block-2"));
        System.out.println("The enroll today button is enabled: " + enrollButton.isEnabled());

        driver.quit();


    }
}
