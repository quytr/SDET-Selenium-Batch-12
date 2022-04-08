package com.syntax.review03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Waits {
    public static String url = "https://chercher.tech/practice/implicit-wait-example";

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //wait time is the maximum time out, after 20s then can throw an exceptions
        //minimum is 12s and max is 20s
        //usually if the element does not appear in 20s, then the element will not be there. no need to waste time to wait.
        //thread.sleep that when you force the driver pause for ... seconds
        //declare once and can reuse it
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();


    }
}
