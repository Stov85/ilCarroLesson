package tests;

import models.User;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestsBase{

    @BeforeMethod
    public void preCondition() {
        // if logged [logout present???] ---> logout

        if (app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logout();
        }
    }

    @Test
    public void registrationSuccess(){
int index = (int)(System.currentTimeMillis()/1000%3600);
        System.out.println(index);
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm("Bobi", "Dil1", "bbbobdil1"+index+"@gmail.com", "BobD1234%.com");
        app.getUserHelper().checkPolicyByXY();
        app.getUserHelper().pause(3000);

        // app.getUserHelper().checkPolicy();

        app.getUserHelper().submitForm();
        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());
    }
    @Test
    public void registrationSuccessModel() {


        int index = (int) (System.currentTimeMillis() / 1000 % 3600);
        System.out.println(index);

        User user = new User().withName("Bobi").withLastName("Dil1").withEmail("bbbobdil1"+index+"@gmail.com").withPassword("BobD1234%.com");

        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().checkPolicy();
        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());
    }
    @AfterMethod
    public void postCondition() {
        app.getUserHelper().clickOkButton();

    }
}
