package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JsExecutorDemo3 {
    public static String url = "https://www.google.com/";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // open a  new tab and navigates to amazon
        js.executeScript("window,open('http://amazon.com');");
        //window.open(); -- open a blank tab


        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("adasdasfasfdasfasdf");

    }
}
