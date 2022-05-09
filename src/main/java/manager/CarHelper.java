package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase {
    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        click(By.cssSelector("[href='/let-car-work']"));
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getAddress());
        type(By.id("make"), car.getName());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.cssSelector("#engine"), car.getEngine());
        //  type(By.id(""))
        select(By.id("fuel"), car.getFuel());
        select(By.id("gear"), car.getGear());
        select(By.id("wheelsDrive"), car.getWD());
        type(By.id("doors"), car.getDoors());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getClasS());
        type(By.id("fuelConsumption"), car.getFuelconsumption());
        type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice());
        type(By.id("distance"), car.getDistanceIncluded());
        type(By.cssSelector(".feature-input"), car.getFeatures());
        type(By.id("about"), car.getAbout());
    }

    private void select(By locator, String option) {
        //  new Select(wd.findElement(locator)).selectByIndex();
        new Select(wd.findElement(locator)).selectByValue(option);
        //new Select(wd.findElement(locator)).selectByVisibleText("Gas");
    }

//    private void typeLocation(String address) {
//        type(By.id("pickUpPlace"), address);
//        click(By.cssSelector(".pac-item"));
//        pause(500);
//    }

    private void typeLocationXY(String address) {
        type(By.id("pickUpPlace"), address);

        WebElement city = wd.findElement(By.id("pickUpPlace"));
        Rectangle rect = city.getRect();

        Actions actions = new Actions(wd);
        actions.moveToElement(city).release().build().perform();
int y= rect.getHeight();
        actions.moveByOffset(0,y).click().release().build().perform();
    }

    public void atachPhoto(String link) {
        wd.findElement(By.id("photos")).sendKeys(link);
    }

    public void submitForm() {
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//button[.='Submit']"))));
        click(By.xpath("//button[text()='Submit']"));
    }

    public boolean isCarAdded() {
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));
        String message = wd.findElement(By.cssSelector("div.dialog-container h1")).getText();
        //Car added
        //div.dialog-container h1
        return message.equals("Car added");
    }

    public void clickSearchButton() {
        click(By.xpath("//button[text()='Search cars']"));
    }
}
