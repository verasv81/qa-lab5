package com.company;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab5Test {
    public static void main(String[] args) {
        // set driver
        System.setProperty("webdriver.chrome.driver",
                "/Users/verasv/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // open page
        driver.get("https://www.amazon.com");

        // search for "computer"
        WebElement searchBox = driver.findElement(By.name("field-keywords"));
        searchBox.sendKeys("computer");
        searchBox.submit();

        // check amazon header
        boolean exists = driver.findElement( By.xpath("//a[@aria-label=\'Amazon\']")).getSize() != null;
        if (exists) {
            driver.findElement( By.xpath("//a[@aria-label=\'Amazon\']")).click();
        }
        else {
            System.out.println("Amazon header not found on page");
        }
        driver.close();
    }
}
