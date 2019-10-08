package example.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.String.format;

public class MainPage extends AbstractPage {

    private String baseString = "//strong[contains(.,'%s')]/../preceding-sibling::*/div[contains(@class,'item-title')]//a";
    private By sortButton = By.xpath("//*[text()='цене']");
    private By allSortElements = By.xpath("//div[@class='listing-item-title']/h4/a");
    private By allElementsOnPage = By.xpath("//strong[contains(text(),'')]");
    private WebElement popUpWindow = driver.findElement(By.cssSelector("span.survey-popup-close.js-survey-popup-close"));

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openPage(String startUrl) {
        driver.get(startUrl);
        return new MainPage(driver);
    }

    public String findCarWithButtonSortOnPage() {
        closePopUp(popUpWindow);
        driver.findElement(sortButton).click();
        List<WebElement> listSortedCars = driver.findElements(allSortElements);
        return listSortedCars.get(0).getText();
    }

    public String findCarWithMinPriceFromPage() {
        List<WebElement> listWeb = driver.findElements(allElementsOnPage);
        WebElement carMinPrice = driver.findElement(
                By.xpath(String.format(baseString, format("%,d", minPrice(listWeb)).replace(",", " "))));
        saveScreenshot(carMinPrice);
        return carMinPrice.getText();
    }

    private void saveScreenshot(WebElement webElement) {
        File screenCapture = webElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/" + getCurrentTimeAsString() + ".png"));
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }
       
    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
    
    private void closePopUp(WebElement webElement) {
        for (String winhandle : driver.getWindowHandles()) {
            driver.switchTo().window(winhandle);
            webElement.click();
        }
    }
    
     private Integer minPrice(List<WebElement> list){
        return   list.stream()
                .map(s -> s.getText())
                .map(s -> s.replaceAll("[\\D+ ]", ""))
                .map(Integer::parseInt).min(Integer::compareTo).get();
    }
}

