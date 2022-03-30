package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownHandling {

    public static String url = "https://www.syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement daysDD= driver.findElement(By.id("select-demo"));
        Select select = new Select(daysDD);
        select.selectByIndex(3);   // indexing starts from 0

        Thread.sleep(1000);

        select.selectByVisibleText("Thursday");

        Thread.sleep(1000);

        select.selectByValue("Sunday");

        List<WebElement> allOptions = select.getOptions();
        int size = allOptions.size();
        System.out.println(size);

        for (int i = 1; i < size; i++) {
            String option = allOptions.get(i).getText();  //get text for each element
            System.out.println(option);
            Thread.sleep(1000);
            select.selectByIndex(i);
        }

        driver.quit();



    }
}
