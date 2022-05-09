package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestsBase {

    @BeforeMethod
    public void preCondition() {
// if logged --> login()
        if (!app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().login(new User().withEmail("bobdilan@gmail.com").withPassword("Bobdil1234$.com"));
        }

    }

    @Test
    public void addNewCarSuccess() {
        //open carform->fill form-- attach file-- submitBTM
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(index);
        Car car = Car.builder()
                .address("Tel Aviv")
                .name("BMW")
                .model("X7")
                .year("2021")
                .engine("4.0")
                .fuel("Diesel")
                .gear("AT")
                .wD("AWD")
                .doors("5")
                .seats("7")
                .clasS("SUV")
                .fuelconsumption("10.0")
                .carRegNumber("111-22-" + index)
                .price("150")
                .distanceIncluded("700")
                .features("type of")
                .about("Perfect car")
                .build();

        app.getCarHelper().openCarForm();
        app.getCarHelper().fillCarForm(car);
        app.getCarHelper().atachPhoto("C:/Users/user/Pictures/mcqueen.jpeg");
        app.getCarHelper().submitForm();

        Assert.assertTrue(app.getCarHelper().isCarAdded());
    }

    @Test
    public void addNewCarSuccess2() {
        //open carform->fill form-- attach file-- submitBTM
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(index);
        Car car = Car.builder()
                .address("Tel Aviv")
                .name("BMW")
                .model("X7")
                .year("2021")
                .engine("4.0")
                .fuel("Diesel")
                .gear("AT")
                .wD("AWD")
                .doors("5")
                .seats("7")
                .clasS("SUV")
                .fuelconsumption("10.0")
                .carRegNumber("111-22-" + index)
                .price("150")
                .distanceIncluded("700")
                .features("type of")
                .about("Perfect car")
                .build();

        app.getCarHelper().openCarForm();
        app.getCarHelper().fillCarForm(car);
        app.getCarHelper().atachPhoto("C:/Users/user/Pictures/mcqueen.jpeg");
        app.getCarHelper().submitForm();

        Assert.assertTrue(app.getCarHelper().isCarAdded());
    }

    @AfterMethod
    public void postCondition() {
        app.getCarHelper().clickSearchButton();
        app.getUserHelper().logout();
    }
}