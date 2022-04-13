package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW1 {
    /*
    Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
click on leave
click on leave list
choose from "From calendar"
choose from "To calendar"
click only on cancelled and rejected checkboxes
uncheck Pending Approval
select IT support from DD
click search
quit the browser
     */
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //login
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[contains(@name, 'txtP')]"));
        password.sendKeys("Hum@nhrm123");
        WebElement login = driver.findElement(By.xpath("//input[@value='LOGIN']"));
        login.click();
        //click on leave
        WebElement leaveButton = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        leaveButton.click();
        //click on leave list
        WebElement leaveListButton = driver.findElement(By.id("menu_leave_viewLeaveList"));
        leaveListButton.click();
        //choose from "From calendar"
        WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
        fromCalendar.click();
        WebElement monthDD = driver.findElement(By.className("ui-datepicker-month"));
        Select select = new Select(monthDD);
        select.selectByVisibleText("Oct");
        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement fromDate : fromDates) {
            String date = fromDate.getText();
            if (date.equals("3")) {
                fromDate.click();
                break;
            }
        }
        //choose from "To calendar"
        WebElement toCalendar = driver.findElement(By.xpath("(//img[@class='ui-datepicker-trigger'])[2]"));
        toCalendar.click();
        monthDD = driver.findElement(By.className("ui-datepicker-month"));
        Select select1 = new Select(monthDD);
        select1.selectByVisibleText("Nov");
        fromDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement fromDate : fromDates) {
            String date = fromDate.getText();
            if (date.equals("2")) {
                fromDate.click();
                break;
            }
        }
        //click only on cancelled and rejected checkboxes
//        WebElement rejectedCheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
//        rejectedCheckbox.click();
//        WebElement cancelledCheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
//        cancelledCheckbox.click();
//        //uncheck Pending Approval
//        WebElement pendingApprovalCheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[4]"));
//        pendingApprovalCheckbox.click();

        //click only on cancelled and rejected checkboxes and uncheck Pending approval
        List<WebElement> checkboxes = driver.findElements(By.xpath("(//input[@type='checkbox'])"));
        for (int i = 0; i < checkboxes.size(); i++) {
            if(i==1 || i==2 || i==3){
                checkboxes.get(i).click();
            }
        }
        //select IT support from DD
        WebElement subUnitDD = driver.findElement(By.xpath("//select[@name='leaveList[cmbSubunit]']"));
        Select select2 = new Select(subUnitDD);
        select2.selectByIndex(1);
        //click search
        WebElement searchButton = driver.findElement(By.name("btnSearch"));
        searchButton.click();
        //quit browser
        driver.quit();



    }
}
