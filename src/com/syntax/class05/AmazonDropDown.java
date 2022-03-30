package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonDropDown {

    public static String url = "https://www.amazon.com/";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //1. get element
        WebElement categoriesDD = driver.findElement(By.id("searchDropdownBox"));
        //2. create an object from select class
        Select select = new Select(categoriesDD);
        //3. create a List to store all the options
        List<WebElement> options = select.getOptions();
        for (WebElement option : options){
            String optionText = option.getText();
            System.out.println(optionText);
        }

        select.selectByValue("search-alias=baby-products");

        driver.quit();


    }
}
