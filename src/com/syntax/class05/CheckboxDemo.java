package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxDemo {

    public static String url = "https://www.syntaxprojects.com/basic-checkbox-demo.php";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        // locating checkboxes and storing them in the list
        List<WebElement> optionCheckBoxed = driver.findElements(By.cssSelector("input[class='cb1-element']"));
        int size = optionCheckBoxed.size();
        System.out.println(size);

        // looping through each element from the List line 19
        for(WebElement option : optionCheckBoxed){
            // can't use getText() because text "Option 2" is not inside <input> tagname;
//            String checkBoxText = option.getText();  // getText() WebElement command
            //using getAttribute() to get one attribute in the <input> tagname
            String checkBoxText = option.getAttribute("value");  //getAttribute() is a WebElement command
            if(checkBoxText.equals("Option-2")){
                option.click();
                break;
            }
        }
        driver.quit();

    }
}
