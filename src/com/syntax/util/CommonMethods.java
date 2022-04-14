package com.syntax.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    /*
    Create package SeleniumUtil and create 2 methods:
openBrowser() and close/quitBrowser().  for openBrowser() you meet to pass argument as URL
     */
    public static WebDriver driver;
    public static void openBrowser(String url){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver =  new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void closeBrowser(){
        if(driver!=null){
            driver.close();
        }
    }

    public static void quitBrowser(){
        if(driver!=null){
            driver.quit();
        }
    }
}
