package com.sahabt.testmaster2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class AddFavorites {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public AddFavorites (WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,30,150);

    }

    public void LoggingIn(String username, String password, String product){

        webDriver.get("https://www.hepsiburada.com/");
        webDriver.findElement(By.cssSelector(".insider-opt-in-notification-button.insider-opt-in-disallow-button")).click();
        openLoginMenu();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("login"))).click();
        webDriver.findElement(By.id("email")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.cssSelector(".btn.full.btn-login-submit")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("productSearch"))).click();

        Search(product);

    }

    private void openLoginMenu() {
        WebElement LogInButton = webDriver.findElement(By.id("myAccount"));
        LogInButton.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(LogInButton).build().perform();
    }

    public void Search (String product){


        webDriver.findElement(By.id("productSearch")).sendKeys(product);
        webDriver.findElement(By.id("buttonProductSearch")).click();
        webDriver.findElement(By.cssSelector(".product-image.owl-lazy")).click();
        webDriver.findElement(By.cssSelector(".favorite")).click();

        //        webDriver.findElement(By.xpath("//a[@class='goToMyFavoriteList']")).click();
        //       webDriver.findElement(By.linkText("Favori Listeme Git")).click();

    }



}
