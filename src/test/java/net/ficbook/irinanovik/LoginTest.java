package net.ficbook.irinanovik;

import net.ficbook.irinanovik.driver.DriverSingleton;
import net.ficbook.irinanovik.pages.HomePage;
import net.ficbook.irinanovik.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    public void testLoginWithNotExistTextOfUsernameAndPassword() {

        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickButtonLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.inputUsername("dfghjkj");
        loginPage.inputPassword("gykhjl");
        loginPage.clickButtonEnter();

        String actualTextPassword = loginPage.errorPasswordOrUsernameText();
        String expectedTextPassword = "Логин не существует";

        Assertions.assertEquals(expectedTextPassword, actualTextPassword);
    }

    @Test
    public void testLoginWithEmptyPassword() {

        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickButtonLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.inputUsername("fdgbzfd");
        loginPage.inputPassword("");
        loginPage.clickButtonEnter();

        String actualTextPassword = loginPage.errorPasswordText();
        String expectedTextPassword = "Логин не существует";

        Assertions.assertEquals(expectedTextPassword, actualTextPassword);
    }

    @AfterEach
    public void close() {
        DriverSingleton.closeDriver();
    }

}
