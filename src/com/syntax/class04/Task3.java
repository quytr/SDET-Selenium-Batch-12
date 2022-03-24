package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    /*
    HRMS Application Negative Login:
    Open chrome browser
    Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
    Enter valid username
    Leave password field empty
    Click on login button
    Verify error message with text "Password cannot be empty" is displayed.
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        WebElement username = driver.findElement(By.cssSelector("input#txtUsername"));
        username.sendKeys("Admin");

        WebElement login = driver.findElement(By.cssSelector("input.button"));
        login.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("span[id*='span']"));
        boolean errorMessageIsDisplayed = errorMessage.isDisplayed();
        String errorMessageText = errorMessage.getText();

        if(errorMessageIsDisplayed && errorMessageText.equals("Password cannot be empty")){
            System.out.println("Error message with text is displayed");
        }else{
            System.out.println("Error message with text is not displayed");
        }

        driver.quit();

    }
}
