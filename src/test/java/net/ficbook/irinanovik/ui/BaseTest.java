package net.ficbook.irinanovik.ui;

import net.ficbook.irinanovik.ui.driver.DriverSingleton;
import net.ficbook.irinanovik.ui.pages.home.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void startPage(){
        HomePage homePage = new HomePage();
        homePage.openSite();
    }

    @AfterEach
    public void tearOff(){
        DriverSingleton.closeDriver();
    }
}
