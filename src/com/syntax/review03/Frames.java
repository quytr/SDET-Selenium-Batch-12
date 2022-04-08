package com.syntax.review03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Frames {

    public static String url = "https://chercher.tech/practice/frames";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(frameElement);
        frameElement = driver.findElement(By.xpath("//iframe[@id='frame3']"));
        driver.switchTo().frame(frameElement);

        WebElement checkBox = driver.findElement(By.xpath("//input[@id='a']"));

        checkBox.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);


    }
}
