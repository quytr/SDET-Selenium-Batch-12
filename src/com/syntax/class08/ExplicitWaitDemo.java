package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {
    /*
    Click on get new user
    get the first name text
    print out in console
     */
    public static String url = "http://syntaxprojects.com/dynamic-data-loading-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement getUserButton = driver.findElement(By.id("save"));
        getUserButton.click();

        //Create an object for WebDriver wait
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //ExpectedConditions is a class
        //ExpectedCondition is an interface
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'First Name')]")));

        WebElement firstName = driver.findElement(By.xpath("//p[contains(text(), 'First Name')]"));
        System.out.println(firstName.getText());

    }
}
