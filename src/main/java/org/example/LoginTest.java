package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    String URL_login = "http://localhost/wordpress/wp-login.php";
    String URL_dashBoard = "http://localhost/wordpress/wp-admin/";
    String user_login = "user_login";
    String user_pass = "user_pass";
    String submitBtn = "wp-submit";

    public void login(String userName, String password) {
        driver = new FirefoxDriver();
        driver.get(URL_login);
        driver.findElement(By.id(user_login)).sendKeys(userName);
        driver.findElement(By.id(user_pass)).sendKeys(password);
        driver.findElement(By.id(submitBtn)).click();
    }

    @Test
    public void loginByAdmin() {
        login("giang", "123456789");
        Assert.assertEquals(driver.getCurrentUrl(), URL_dashBoard);
        driver.quit();
    }

    @Test
    public void loginWithBlankField() {
        login("", "");
        Assert.assertEquals(driver.getCurrentUrl(), URL_login);
        driver.quit();
    }
}
