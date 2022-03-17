package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    /*
    navigate to fb.com
    click on create new account
    fill up all the textboxes
    click on sign up button
    close the pop up
    close the browser
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("Robert");
        driver.findElement(By.name("lastname")).sendKeys("Evan");
        driver.findElement(By.name("reg_email__")).sendKeys("rob.ev456@yahoo.com");
        Thread.sleep(2000);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("rob.ev456@yahoo.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("ebes412");
        Thread.sleep(2000);
        driver.findElement(By.name("birthday_month")).sendKeys("Oct");
        driver.findElement(By.name("birthday_day")).sendKeys("30");
        driver.findElement(By.name("birthday_year")).sendKeys("1992");



        driver.findElement(By.xpath("//*[@class='_8idr img']")).click();

        driver.quit();




//       driver.findElement(By.id("u_1b_9_Xs")).click();

    }
}
