package net.ficbook.irinanovik.ui.pages.home;

import net.ficbook.irinanovik.ui.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private final String URL = "https://ficbook.net/";

    public HomePage() {
        this.driver = DriverSingleton.getDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public void openSite() {
        driver.get(URL);
    }

    public void clickButtonLogin() {
        By buttonLoginBy = By.xpath(HomePageXPath.BUTTON_LOGIN_XPATH);
        //WebElement buttonLogin = driver.findElement(buttonLoginBy);
        WebElement buttonLogin = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(buttonLoginBy));
        buttonLogin.click();
    }
}
