package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestsBase {
    protected static ApplicationManager app = new ApplicationManager();


    @BeforeMethod
    public void setUp() {
        app.init();
    }

//    @AfterMethod
//  public void tearDown() {
//       app.stop();
//    }



}
