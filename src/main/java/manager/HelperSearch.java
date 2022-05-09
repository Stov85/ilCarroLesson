package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase {

    public HelperSearch(WebDriver wd) {
        super(wd);

    }

    public void fillSearchFormCurrentMonth(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectPeriodCurrentMonth(dateFrom, dateTo);
    }

    public void fillInputCity(String city) {
        type(By.id("city"), city);
        pause(500);
        click(By.cssSelector(".pac-item"));
        pause(500);

    }

    public void selectPeriodCurrentMonth(String dateFrom, String dateTo) {
        //     1/28/2022 - 1/30/2022 -----> 28 - 30
        click(By.id("dates"));

        String[] dataF = dateFrom.split("/"); //--->>>> [1],[28],[2022] ----> get[1] = 28
        String[] dataT = dateTo.split("/"); // ---->>>> [1], [30], [2022]  ---->get[1] = 30

        String locator = "//div[text()=' " + dataF[1] + " ']"; //     //div[text()=' 28 ']
        String loc = String.format("//div[text()=' %s ']",dataF[1]);  //div[text()=' 28 ']

        click(By.xpath(locator)); // 28

        String locator2 = "//div[text()=' " + dataT[1] + " ']";
        click(By.xpath(locator2));
        pause(5000);

    }


    public boolean isListOfCarsAppeared() {

        return isElementPresent(By.cssSelector(".search-results"));
    }

    public void returnToHome() {
        click(By.cssSelector("a[href$='/search']"));
    }


    public void fillSearchFormInFuture(String city, String from, String to) {
        fillInputCity(city);
        selectAnyData(from, to);
    }

    private void selectAnyData(String dataFrom, String dataTo) {

        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate now = LocalDate.now();

        click(By.id("dates"));

        int mouthDiff = from.getYear() - now.getYear()
                == 0 ? from.getMonthValue() - now.getMonthValue() : 12 - now.getMonthValue() + from.getMonthValue();
        clickNextMonth(mouthDiff);
        String dataLocator = String.format("//div[text()=' %s ']", from.getDayOfMonth());
        click(By.xpath(dataLocator));

        mouthDiff = to.getYear() - from.getYear()
                == 0 ? to.getMonthValue() - from.getMonthValue() : 12 - from.getMonthValue() + to.getMonthValue();
        clickNextMonth(mouthDiff);

        dataLocator = String.format("//div[text()=' %s ']", to.getDayOfMonth());

        click(By.xpath(dataLocator));
    }


    private void clickNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.cssSelector("button[aria-label='Next month']"));

        }
    }

    public void fillSearchFormInPast(String city, String from, String to) {
        fillInputCity(city);
        typePeriodInPast(from, to);
    }

    private void typePeriodInPast(String from, String to) {
        type(By.id("dates"), from + " - "+to);
        click(By.cssSelector(".cdk-overlay-container"));

    }

    public boolean isDataInPast() {

        WebElement el = wd.findElement(By.cssSelector(".error .ng-star-inserted"));
        String  text = el.getText();
        new WebDriverWait(wd, 5)
                .until(ExpectedConditions.textToBePresentInElement(el,text));

        System.out.println(text);

         return text.contains("Dates are required");
    }

    public boolean isYallaButtonInactive() {
        return !wd.findElement(By.cssSelector("[type='submit']")).isEnabled();
    }
}