package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestsBase {
    protected static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestsBase.class);

    @BeforeMethod
    public void startLogger(Method m) {
    logger.info("Name of test--->" +m.getName());
    }

    @BeforeSuite
    public void setUp() {
        app.init();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }


}
