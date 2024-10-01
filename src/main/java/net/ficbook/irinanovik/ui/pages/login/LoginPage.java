package net.ficbook.irinanovik.ui.pages.login;

import net.ficbook.irinanovik.ui.driver.DriverSingleton;
import net.ficbook.irinanovik.ui.pages.home.HomePageXPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public void clickButtonLogin() {
        By buttonLoginBy = By.xpath(HomePageXPath.BUTTON_LOGIN_XPATH);
        //WebElement buttonLogin = driver.findElement(buttonLoginBy);
        WebElement buttonLogin = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(buttonLoginBy));
        buttonLogin.click();
    }

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
        //return errorText(LoginPageXPath.ERROR_LOGIN_DATA_XPATH);
        return errorText(LoginPageXPath.LOGIN_FORM_ALL_DATA_XPATH);
    }

    public String errorPasswordText() {
        return errorText(LoginPageXPath.ERROR_PASSWORD_XPATH);
    }

    private String errorText(String xpath) {
        By errorBy = By.xpath(xpath);
     //   WebElement webElement = driver.findElement(errorBy);
        if (webDriverWait.until(ExpectedConditions.presenceOfElementLocated(errorBy)).isDisplayed()){
            WebElement error2 = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(errorBy));
            return error2.getText();
        } else {
            return "";}
    }
}
