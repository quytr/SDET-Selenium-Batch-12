package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    /*
    Open chrome browser
    Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
    Enter valid username and password (username - Admin, password - Hum@nhrm123)
    Click on login button
    Then verify Syntax Logo is displayed.
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[contains(@name, 'txtP')]"));
        password.sendKeys("Hum@nhrm123");

        WebElement login = driver.findElement(By.xpath("//input[@value='LOGIN']"));
        login.click();

        WebElement logo  = driver.findElement(By.xpath("(//img[starts-with(@src, '/human')])[1]"));
        boolean logoIsDisplayed = logo.isDisplayed();

        if(logoIsDisplayed){
            System.out.println("The Syntax Logo is displayed");
        }else{
            System.out.println("The Syntax Logo is not displayed");
        }

        driver.quit();

    }
}
