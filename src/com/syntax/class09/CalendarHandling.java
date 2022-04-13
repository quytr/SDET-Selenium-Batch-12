package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarHandling {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // log in option
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[contains(@name, 'txtP')]"));
        password.sendKeys("Hum@nhrm123");
        WebElement login = driver.findElement(By.xpath("//input[@value='LOGIN']"));
        login.click();

        WebElement leaveButton = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        leaveButton.click();
        WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
        fromCalendar.click();

        WebElement monthDD = driver.findElement(By.className("ui-datepicker-month"));
        Select select = new Select(monthDD);
        select.selectByVisibleText("Jul");

        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class= 'ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement fromDate : fromDates) {
            String dateText = fromDate.getText();
            if (dateText.equals("4")) {
                fromDate.click();
                break;
            }
        }

    }

}