package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
    /*
     * 1. launch the browser
     * 2. navigate to amazon web site
     * 3. print out the title and the url in the console
     * 4. close the browser
     */
    public static void main(String[] args) {
        //set the property
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        //create an obj to launch chrome browser
        WebDriver driver = new ChromeDriver();

        //navigate to amazon website by using get
        driver.get("https://www.amazon.com/");

        //to get the current URL
        String url = driver.getCurrentUrl();

        //to get the title
        String title = driver.getTitle();
        System.out.println(title + " " + url);

        //to quit the browser
        driver.quit();
    }
}
