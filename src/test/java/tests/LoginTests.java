package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTests extends TestsBase {

    @Test
    public void loginSuccess() {
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("bobdilan@gmail.com", "Bobdil1234$.com");
        app.getUserHelper().submitForm();

    //Assert
    }

}
