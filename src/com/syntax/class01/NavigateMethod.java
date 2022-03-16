package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        //launching the browser only one obj = one tab
        WebDriver driver = new ChromeDriver();

        //.get() is a method
        driver.get("https://www.facebook.com/"); //navigate to the website

        //navigate has more abilities
        driver.navigate().to("https://www.google.com/"); //navigate to the website
        driver.navigate().back();
        driver.navigate().forward();

        //to pause the execution for 2 seconds (2000 millis = 2s) not recommended
        Thread.sleep(2000);
        //to refresh the page
        driver.navigate().refresh();

        //.close() closing the current tab
        driver.close();
        //.quit() close the whole browser
        driver.quit();
    }
}
