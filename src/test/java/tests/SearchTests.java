package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestsBase {

//    @Test
//    public void searchPeriodCurrentMonth() {
//
//        //1/28/2022 - 1/30/2022
//        app.search().fillSearchFormCurrentMonth("Tel Aviv, Israel", "04/19/2022", "04/25/2022");
//        app.getUserHelper().submitForm();
//        app.search().pause(2000);
//        Assert.assertTrue(app.search().isListOfCarsAppeared());
// LocalDate


 //   }
 @Test
 public void typePeriodInPast(){
     // "1/15/2021","1/18/2021"

     app.search().pause(2000);
     app.search().fillSearchFormInPast("Bat Yam, Israel","1/15/2021","1/18/2021");
     app.search().pause(2000);
     Assert.assertTrue(app.search().isDataInPast());
     app.search().pause(2000);
     Assert.assertTrue(app.search().isYallaButtonInactive());

 }

    @Test
    public void searchPeriodAnyFuture() {

        app.search().fillSearchFormInFuture("Rehovot, Israel", "05/30/2022", "06/25/2022");
        app.getUserHelper().submitForm();
        app.search().pause(2000);
        Assert.assertTrue(app.search().isListOfCarsAppeared());

    }


    @AfterMethod
    public void posCondition() {
        app.search().returnToHome();
    }

}