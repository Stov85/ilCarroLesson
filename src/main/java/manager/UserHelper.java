package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
         super(wd);
    }

    public void openLoginForm() {
          click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submitForm() {
        click(By.cssSelector("[type='submit']"));
    }

    public void openRegistrationForm() {
        ///**********
//        wd.findElement(By.linkText(" Sign up "));
//        wd.findElement(By.partialLinkText(" Sign up "));
        wd.findElement(By.xpath("//a[text()=' Sign up ']")).click();
    }

    public void fillRegistrationForm(String name, String lastname, String email, String password) {
        // if form displayed --> fill
        if (wd.findElement(By.tagName("form")).isDisplayed()) {
            // fill form
            type(By.id("name"), name);
            type(By.cssSelector("#lastName"), lastname);
            type(By.id("email"), email);
            type(By.cssSelector("#password"), password);
        }

    }

    public void fillRegistrationForm(User user) {
        // if form displayed --> fill
        if (wd.findElement(By.tagName("form")).isDisplayed()) {
            // fill form
            type(By.id("name"), user.getName());
            type(By.cssSelector("#lastName"), user.getLastName());
            type(By.id("email"), user.getEmail());
            type(By.cssSelector("#password"), user.getPassword());
        }

    }

    public void checkPolicy() {
        if (!wd.findElement(By.id("terms-of-use")).isSelected()) {
            click(By.xpath("//label[@for='terms-of-use']"));
        }
    }

    public boolean isRegistrationSuccess() {
//        // dialog is displayed???
//      Boolean res = new WebDriverWait(wd, 10)
//                .until(ExpectedConditions
//                        .textToBePresentInElement
//                                (wd.findElement(By.xpath("//div[@class='dialog-container']//h2")), "You are logged in success"));
        WebElement until = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-container']//h2")));
        String text = until.getText();
        System.out.println(text);
        return text.equals("You are logged in success");

    }

    public void  checkPolicyByXY(){
        WebElement label= wd.findElement(By.xpath("//label[@for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int x= rect.getX()+5;
        int y= rect.getY()+10;
Actions actions = new Actions(wd);
actions.moveByOffset(x,y).click().release().perform();

    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    public void clickOkButton() {
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-container']")));
        click(By.xpath("//*[text()='Ok']"));
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitForm();
        clickOkButton();
        pause(2000);
    }
}
