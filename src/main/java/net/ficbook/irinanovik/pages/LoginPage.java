package net.ficbook.irinanovik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public void clickButtonEnter() {
        By buttonEnterBy = By.xpath(LoginPageXPath.BUTTON_ENTER_XPATH);
        WebElement buttonEnter = driver.findElement(buttonEnterBy);
        buttonEnter.click();
    }

    public void inputUsername(String username) {
        By inputUsernameBy = By.xpath(LoginPageXPath.INPUT_USERNAME_XPATH);
        WebElement inputUsername = driver.findElement(inputUsernameBy);
        inputUsername.sendKeys(username);
    }

    public void inputPassword(String password) {
        By inputPasswordBy = By.xpath(LoginPageXPath.INPUT_PASSWORD_XPATH);
        WebElement inputPassword = driver.findElement(inputPasswordBy);
        inputPassword.sendKeys(password);
    }
    public String errorPasswordOrUsernameText() {
        return
    }

    public String errorPasswordText() {
    }
}
