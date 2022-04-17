package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Month;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class HW1 {
    /*
    Go to aa.com/homePage.do
select depart date
select return date
select destination
click on search
quit the browser
     */
    public static String url = "https://www.aa.com/homePage.do";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement departDate = driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]"));
        departDate.click();
        WebElement dMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
        String dMonthText = dMonth.getText();
        while (!dMonthText.equals("October")) {
            WebElement nextButton = driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
            nextButton.click();
            dMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
            dMonthText = dMonth.getText();
        }
        List<WebElement> departDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement departDay : departDays){
            if(departDay.getText().equals("3")){
                departDay.click();
                break;
            }
        }

        WebElement returnDate = driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]"));
        returnDate.click();
        WebElement rMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
        String rMonthText = rMonth.getText();
        while (!rMonthText.equals("December")) {
            WebElement nextButton = driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
            nextButton.click();
            rMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
            rMonthText = rMonth.getText();
        }
        List<WebElement> returnDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement returnDay : returnDays){
            if(returnDay.getText().equals("11")){
                returnDay.click();
                break;
            }
        }

        WebElement searchButton = driver.findElement(By.xpath("(//span[@class='icon icon-search'])[2]"));
        searchButton.click();

        WebElement ddCountry = driver.findElement(By.xpath("//select[@id='countryCode']"));
        Select select = new Select(ddCountry);
        select.selectByVisibleText("United States");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='stateCode']")));
        WebElement ddState = driver.findElement(By.xpath("//select[@id='stateCode']"));
        select = new Select(ddState);
        select.selectByVisibleText("California");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='LAX']")));
        WebElement airportLookup = driver.findElement(By.xpath("//span[text()='LAX']"));
        airportLookup.click();

        WebElement searchButton2 = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
        searchButton2.click();

        driver.quit();









//        driver.quit();


    }
}
