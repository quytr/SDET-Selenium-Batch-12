package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

    public static String url = "http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        //switch to frame
        driver.switchTo().frame(0);
        WebElement textbox = driver.findElement(By.id("name"));
        textbox.sendKeys("Batch 12 forever");

        //switch back to the main page again
        driver.switchTo().defaultContent();

        WebElement alertButton = driver.findElement(By.id("alert"));
        alertButton.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();  //focus to the alert
        alert.accept();

        driver.switchTo().frame("iframe_a");  //switch to frame
        textbox.clear();
        textbox.sendKeys("We are back to frame");

        driver.switchTo().defaultContent();  //switch back to the main page

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@src='/Demo.html']"));
        driver.switchTo().frame(frameElement);  //switch to the frame
        textbox.clear();
        textbox.sendKeys("Hold your horses");
    }
}
