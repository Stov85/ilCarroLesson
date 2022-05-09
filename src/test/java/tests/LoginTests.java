package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTests extends TestsBase {
    @BeforeMethod
    public void preCondition() {
        // if logged [logout present???] ---> logout

        if (app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logout();
        }
    }

    @Test
    public void loginSuccess() {
        logger.info("The test start with email: [bobdilan@gmail.com] & password: [Bobdil1234$.com]");
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("bobdilan@gmail.com", "Bobdil1234$.com");
        app.getUserHelper().submitForm();

        app.getUserHelper().takeScreenShot("src/test/screenshots/scr1.png");
        //Assert
    }

    @Test
    public void loginSuccessModel() {

        User user = new User().withEmail("bobdilan@gmail.com").withPassword("Bobdil1234$.com");
        logger.info("The test start with data");

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitForm();

    }
    @AfterMethod
    public void postCondition() {
        app.getUserHelper().clickOkButton();

    }
}
