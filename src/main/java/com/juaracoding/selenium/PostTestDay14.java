package com.juaracoding.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PostTestDay14 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        System.out.println("get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        driver.findElement(By.id("first-name")).sendKeys("Anggit");
        driver.findElement(By.id("last-name")).sendKeys("Pangestu");
        driver.findElement(By.id("job-title")).sendKeys("dreamer");


        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-1")).click();

        WebElement selectMenu = driver.findElement(By.id("select-menu"));
        selectMenu.click();
        List<WebElement> options = selectMenu.findElements(By.cssSelector("option[value='1']"));
        options.get(0).click();

        driver.findElement(By.id("datepicker")).sendKeys("09/03/2023");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();
        System.out.println("Data Berhasil Dismipan");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        System.out.println("===Delay 3 second===");
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw  new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Quit Browser");
    }
}