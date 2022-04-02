package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2 {
    /*
    Go to https://syntaxprojects.com/javascript-alert-box-demo.php
click on each button and handle the alert accordingly
     */
    public static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement alertBox = driver.findElement(By.xpath("(//button[text()='Click me!'])[1]"));
        alertBox.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement confirmBox = driver.findElement(By.xpath("(//button[text()='Click me!'])[2]"));
        confirmBox.click();
        Thread.sleep(1000);
        alert.dismiss();

        WebElement promptBox = driver.findElement(By.xpath("//button[text()='Click for Prompt Box']"));
        promptBox.click();
        Thread.sleep(1000);
        alert.sendKeys("Batch 12 is Best");
        alert.accept();

        driver.quit();




    }
}
