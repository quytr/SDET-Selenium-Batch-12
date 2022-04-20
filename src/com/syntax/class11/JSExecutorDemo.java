package com.syntax.class11;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JSExecutorDemo {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // login actions
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[contains(@name, 'txtP')]"));
        password.sendKeys("Hum@nhrm123");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor='yellow'",username);
        js.executeScript("arguments[0].style.backgroundColor='green'",password);

        WebElement login = driver.findElement(By.xpath("//input[@value='LOGIN']"));
//        login.click();
        js.executeScript("arguments[0].click()", login);



    }
}
















