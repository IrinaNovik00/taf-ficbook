package net.ficbook.irinanovik.ui;

import net.ficbook.irinanovik.ui.data.RandomData;
import net.ficbook.irinanovik.ui.pages.cookies.CookiePage;
import net.ficbook.irinanovik.ui.pages.login.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @BeforeEach
    public void closeCookies(){
        CookiePage cookiePage = new CookiePage();
        cookiePage.clickButtonCloseCookie();
    }

    @Test
    public void testLoginWithNotExistTextOfUsernameAndPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickButtonLogin();
        loginPage.inputUsername(RandomData.getRandomLogin());
        loginPage.inputPassword(RandomData.getRandomPassword());
        loginPage.clickButtonEnter();
        String actualTextPassword = loginPage.errorPasswordOrUsernameText();
        if (!actualTextPassword.isEmpty()){
            String expectedTextPassword = "Логин не существует";
            Assertions.assertNotEquals(expectedTextPassword, actualTextPassword);
        }else {
            Assertions.assertEquals("", actualTextPassword);
        }
    }

    @Test
    public void testLoginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickButtonLogin();
        loginPage.inputUsername(RandomData.getRandomLogin());
        loginPage.inputPassword("");
        loginPage.clickButtonEnter();
        String actualTextPassword = loginPage.errorPasswordOrUsernameText();
        if (!actualTextPassword.isEmpty()){
            String expectedTextPassword = "Логин не существует";
            Assertions.assertNotEquals(expectedTextPassword, actualTextPassword);
        }else {
            Assertions.assertEquals("", actualTextPassword);
        }
    }

    @Test
    public void testLoginWithEmptyUsername() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickButtonLogin();
        loginPage.inputUsername("");
        loginPage.inputPassword(RandomData.getRandomPassword());
        loginPage.clickButtonEnter();
        String actualTextPassword = loginPage.errorPasswordOrUsernameText();
        if (!actualTextPassword.isEmpty()){
            String expectedTextPassword = "Логин не существует";
            Assertions.assertNotEquals(expectedTextPassword, actualTextPassword);
        }else {
            Assertions.assertEquals("", actualTextPassword);
        }
    }

    @Test
    public void testLoginWithEmptyUsernameandPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickButtonLogin();
        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickButtonEnter();
        String actualTextPassword = loginPage.errorPasswordOrUsernameText();
        if (!actualTextPassword.isEmpty()){
            String expectedTextPassword = "Логин не существует";
            Assertions.assertNotEquals(expectedTextPassword, actualTextPassword);
        }else {
            Assertions.assertEquals("", actualTextPassword);
        }
    }
}
