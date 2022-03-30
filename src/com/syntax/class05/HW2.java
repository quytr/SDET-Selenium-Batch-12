package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW2 {
    /*
    Go to facebook sign up page
    Fill out the whole form
    Click signup
     */
    public static String url = "https://www.facebook.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement createNewAcc = driver.findElement(By.linkText("Create new account"));
        createNewAcc.click();
        Thread.sleep(1000);
        //1.First name
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Kate");
        //2. Last name
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("Perry");
        //3.Mobile number or email
        WebElement email = driver.findElement(By.cssSelector("input[name='reg_email__']"));
        email.sendKeys("yolo@gmail.com");
        //4.Re-enter email
        WebElement reenterEmail = driver.findElement(By.name("reg_email_confirmation__"));
        reenterEmail.sendKeys("yolo@gmail.com");
        //5.Password:
        WebElement password = driver.findElement(By.id("password_step_input"));
        password.sendKeys("1234asdf@");
        //6.Select DOB
        WebElement monthDD = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthDD);
        selectMonth.selectByVisibleText("Oct");
        WebElement dayDD = driver.findElement(By.name("birthday_day"));
        Select selectDay = new Select(dayDD);
        selectDay.selectByIndex(2);
        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        selectYear.selectByValue("1992");
        //7.Gender
        WebElement gender = driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
        gender.click();
        //8.Submit
        WebElement submit = driver.findElement(By.name("websubmit"));
        submit.click();

        driver.quit();


    }
}
