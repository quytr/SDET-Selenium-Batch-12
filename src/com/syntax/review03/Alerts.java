package com.syntax.review03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //find the alert and click on it
        WebElement simpleAlert = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
        simpleAlert.click();

        //handling the alert
        Alert alert = driver.switchTo().alert();

        Thread.sleep(1000);
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



    }
}
