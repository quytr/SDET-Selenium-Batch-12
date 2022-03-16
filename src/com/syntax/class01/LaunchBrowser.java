package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

    public static void main(String[] args) {
        //1st arg is the built-in value.
        //2nd arg is the path
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); //for windows add extension .exe
                                                                                   // you can use \\
        WebDriver driver = new ChromeDriver();  //launch the browser
        driver.get("https://www.google.com/");
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }
}
