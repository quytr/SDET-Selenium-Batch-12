package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SimpleWindowHandling {

    /*
    Click on Help Link
    Switch between tabs
     */

    public static String url = "http://accounts.google.com/signup";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // get window handle for the main page:
        String mainPageHandle = driver.getWindowHandle();
        System.out.println(mainPageHandle);
        // click on help link and switch to a different window:
        WebElement helpLink = driver.findElement(By.linkText("Help"));
        helpLink.click();

        //store all the handles in a set
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());

        // have an iterator in order to iterate through the handles
        Iterator<String> it = allWindowHandles.iterator();
        // take the first step and assign the main handle
        mainPageHandle = it.next();
        //take the second step and have a child handle
        String childHandle = it.next();
        System.out.println(childHandle);

        Thread.sleep(2000);
        // switch to the main window
//        driver.switchTo().window(mainPageHandle); // to interact with the main page. if you want to close the main tab,
                                                  // then just simply driver.close() but you have to switch to childPage
        driver.switchTo().window(childHandle);    // to switch focus on childPage to interact with that ChildPage

        driver.close();
        driver.switchTo().window(mainPageHandle);
        helpLink.click();

        driver.quit();





    }
}
