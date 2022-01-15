package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestsBase{

    @Test
    public void registrationSuccess(){

        app.getUserHelper().openFillForm();

        app.getUserHelper().fillRegForm("Bobi", "Dil1", "bbbobdil1@gmail.com", "BobD1234%.com");

        app.getUserHelper().checkPolicy();

        app.getUserHelper().submitForm();

    }
}
