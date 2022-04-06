package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HW1a {
     /*
    Go to https://demoqa.com/browser-windows
    click on New Tab and print the text from new tab in the console
    click on New Window and print the text from new window in the console
    click on New Window Message and print the text from new window in the console
    Verify (compare) the titles for each page
    Print out the title of the all pages
     */

    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String mainHandle = driver.getWindowHandle();

        WebElement tabButton = driver.findElement(By.id("tabButton"));
        WebElement windowButton = driver.findElement(By.id("windowButton"));
        WebElement windowMessage = driver.findElement(By.id("messageWindowButton"));
        tabButton.click();
        windowButton.click();
        windowMessage.click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()){
            String handle = iterator.next();
            if(!mainHandle.equals(handle)){
                driver.switchTo().window(handle);
                WebElement console = driver.findElement(By.xpath("//body"));
                String consoleText = console.getText();
                System.out.println(consoleText);
            }
            String title = driver.getTitle();
            System.out.println("The title: " + title);
        }

    }

}
