package net.ficbook.irinanovik.pages;

import net.ficbook.irinanovik.driver.DriverSingleton;
import net.ficbook.irinanovik.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookiePage {
    WebDriver driver;

    public CookiePage() {
        this.driver = DriverSingleton.getDriver();
    }

    public void clickButtonCloseCookie() {
        Waiters.waitFor(3);
        By clickButtonCloseBy = By.xpath(CookiePageXPath.BUTTON_CLOSE_COOKIE_XPATH);
        WebElement buttonClose = driver.findElement(clickButtonCloseBy);
        buttonClose.click();
    }
}
