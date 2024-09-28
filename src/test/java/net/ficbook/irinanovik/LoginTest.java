package net.ficbook.irinanovik;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void testLoginWithNotExistTextOfEmailAndPassword() {

        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickButtonLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.inputUsername("dfghjkj");
        loginPage.inputPassword("gykhjl");
        loginPage.clickButtonEnter();

        String actualTextPassword = loginPage.errorPasswordOrUsernameText();
        String expectedTextPassword = "Логин не существует";

        Assertions.assertEquals(expectedTextPassword,actualTextPassword);
    }

    @AfterEach
    public void close() {
        DriverSingleton.closeDriver();
    }

}
