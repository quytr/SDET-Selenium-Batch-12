package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task2 {
    /*
    TC 1: Amazon link count:
    Open chrome browser
    Go to "https://www.amazon.com/"
    Get all links
    Get number of links that has text
    Print to console only the links that has text
     */
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Numbers of link on Amazon " + allLinks.size());

        int numLinkText =0;
        for(WebElement link : allLinks){
            String linkText = link.getText();
            String fullLink = link.getAttribute("href");

            if(!linkText.isEmpty()){
                System.out.println(linkText + " " + fullLink);
                numLinkText++;
            }
        }
        System.out.println("The number of links that has text: " + numLinkText);

        Thread.sleep(3000);

        driver.quit();



    }
}
