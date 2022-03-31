package com.syntax.class06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationAlert {
    // to handle authentication alert, you can put username:password@ in front of the link starts, right after https://
    public static String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
                                //username:password@

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
    }
}
