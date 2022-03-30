package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW3 {
    /*
    Go to ebay.com
    get all the categories and print them in the console
    select Computers/Tables & Networking
    click on search
    verify the header
     */
    public static String url = "https://www.ebay.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement categoriesDD = driver.findElement(By.cssSelector("select[id='gh-cat']"));
        Select select = new Select(categoriesDD);
        List<WebElement> options = select.getOptions();
        //1.Print all the categories
        for(WebElement option : options){
            String optionText = option.getText();
            System.out.println(optionText);
        }
        //2. Select Computers/Tablets & Networking"
        select.selectByVisibleText("Computers/Tablets & Networking");
        WebElement search = driver.findElement(By.cssSelector("input[type='submit']"));
        search.click();
        //3.Verify the header
        String title = driver.getTitle();
        if(title.equals("Computers, Tablets & Network Hardware")){
            System.out.println("The tittle is correct");
        }else{
            System.out.println("The tittle is not correct");
        }

        driver.quit();




    }
}
