package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    /*
    navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
    fill out the form
    click on register
    close the browser
     */
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");

        driver.findElement(By.id("customer.firstName")).sendKeys("Kate");
        driver.findElement(By.id("customer.lastName")).sendKeys("Shield");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Hollywood St");
        driver.findElement(By.id("customer.address.city")).sendKeys("Hollywood");
        driver.findElement(By.id("customer.address.city")).sendKeys("CA");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("123456");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("987-654-3216");
        driver.findElement(By.id("customer.ssn")).sendKeys("456-98-2635");
        driver.findElement(By.id("customer.username")).sendKeys("kates235");
        driver.findElement(By.id("customer.password")).sendKeys("abcd1234@");
        driver.findElement(By.id("repeatedPassword")).sendKeys("abcd1234@");

        driver.findElement(By.className("button")).click();
        driver.quit();




    }
}
