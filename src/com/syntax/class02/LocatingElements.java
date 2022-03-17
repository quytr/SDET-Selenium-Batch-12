package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        //find element ID that has the value email
        //.sendKeys to type something (sent some text) in the box after find that element
        driver.findElement(By.id("email")).sendKeys("fafasfaff@yahoo.com");

        driver.findElement(By.id("pass")).sendKeys("whatever");

        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);
//        driver.findElement(By.linkText("Forgot password?")).click();

        driver.findElement(By.partialLinkText("Forgot")).click();
        driver.quit();

    }
}
