package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CarCheckPOM {

    By textsearch = By.name("i");
    By cookbut = By.xpath("//button[@type='submit']");

    WebDriver driver=null;

    public CarCheckPOM(WebDriver driver1){
        this.driver=driver1;
    }

    public void carsearch(String text) {
        driver.findElement(textsearch).sendKeys(text);
       // driver.findElement(textsearch).sendKeys(Keys.RETURN);
    }

    public void btclick() {
        driver.findElement(cookbut).click();
    }

    public void cardetails(){

        //td[normalize-space()='BMW']
//td[normalize-space()='120D M SPORT']
//td[normalize-space()='2008']

        List<WebElement> tdElements = driver.findElements(By.xpath("/*[@id=\"content\"]/div[1]/div[3]/div/div/div[2]/table"));

        // Print text from each TD
        for (WebElement td : tdElements) {
            System.out.println(td.getText());
        }


    }
}
