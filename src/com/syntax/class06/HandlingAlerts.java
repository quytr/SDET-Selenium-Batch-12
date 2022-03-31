package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
    /*
      handle each and every alert on the page
     */

    public static String url = "http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        // Identify Simple Alert button
        WebElement simpleAlertButton = driver.findElement(By.id("alert"));
        simpleAlertButton.click();
        //switch my Selenium focus to the alert pop up in order to handle it and return an interface object:
        // Alert is an interface
        Alert simpleAlert = driver.switchTo().alert();  // switch the focus to alert
        Thread.sleep(2000);
        simpleAlert.accept();

        // Identify Confirmation Alert
        WebElement confirmAlertButton = driver.findElement(By.id("confirm"));
        confirmAlertButton.click();
        Thread.sleep(2000);
        Alert confirmAlert = driver.switchTo().alert();  // switch the focus to alert
        String alertText = confirmAlert.getText();
        System.out.println(alertText);
        confirmAlert.dismiss();

        //Identify Prompt Alert
        WebElement promptAlertButton = driver.findElement(By.cssSelector("button#prompt"));
        promptAlertButton.click();
        Thread.sleep(2000);
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Batch 12 is the Best!!!");
        promptAlert.accept();

    }
}
