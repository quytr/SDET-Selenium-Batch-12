package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW1 {
    /*
    TC 1: Facebook dropdown verification
    Open chrome browser
    Go to "https://www.facebook.com"
    click on create new account
    Verify:
    month dd has 12 month options
    day dd has 31 day options
    year dd has 115 year options
    Select your date of birth
    Quit browser
     */
    public static String url = "https://www.facebook.com/";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement createNewAcc = driver.findElement(By.linkText("Create new account"));
        createNewAcc.click();
        Thread.sleep(1000);
        //1. Month DD
        WebElement monthDD = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthDD);
        List<WebElement> optionsMonth = selectMonth.getOptions();
        int sizeMonth = optionsMonth.size();
        if(sizeMonth == 12 ){
            System.out.println("Month dd has 12 month options");
        }else{
            System.out.println("Month dd does not have 12 months. Month dd has " + sizeMonth + " month options");
        }
        //2. Day DD
        WebElement dayDD = driver.findElement(By.name("birthday_day"));
        Select selectDay = new Select(dayDD);
        List<WebElement> optionsDay = selectDay.getOptions();
        int sizeDay = optionsDay.size();
        if(sizeDay == 31){
            System.out.println("Day dd has 31 day options");
        }else{
            System.out.println("Day dd does not have 31 days. It has " + sizeDay + " day options");
        }
        //3.Year DD
        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        List<WebElement> optionsYear = selectYear.getOptions();
        int sizeYear = optionsYear.size();

        if(sizeYear == 115){
            System.out.println("Year dd has 115 year options");
        }else{
            System.out.println("Year dd does not have 115 years. It has " + sizeYear + " year options");
        }
        //4.Select DOB
        selectMonth.selectByVisibleText("Oct");
        selectDay.selectByIndex(2);
        selectYear.selectByValue("1992");
        //5.Quit browser
        driver.quit();



    }
}
