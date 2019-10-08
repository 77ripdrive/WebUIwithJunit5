package example;

import static java.lang.String.format;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
    private String baseString = "//strong[contains(.,'%s')]/../preceding-sibling::*/div[contains(@class,'item-title')]//a";
    private List<WebElement> listWeb ;
    private List<WebElement> listWebSorted ;
    private WebElement sortCoastField;
    protected MainPage(WebDriver driver)
    {
        super(driver);
    }

    public MainPage openPage()
    {
        driver.get("https://cars.av.by/dodge");
        return new MainPage(driver);
    }

    public String sortCoastFieldName()
    {    sortCoastField = driver.findElement(By.xpath("//*[text()='цене']"));
        new WebDriverWait(driver,10)
            .until(ExpectedConditions.visibilityOf(sortCoastField));
        sortCoastField.click();
        listWebSorted=driver.findElements(By.xpath("//div[@class='listing-item-title']/h4/a"));
        String minElement=listWebSorted.get(0).getText();
        System.out.println(minElement);
        return minElement;

    }

    public String findMinElement()
    {    listWeb=driver.findElements(By.xpath("//strong[contains(text(),'')]"));
        Integer listFF = listWeb.stream().map(s -> s.getText()).map(s -> s.replaceAll("[\\D+ ]", "")).map(
                Integer::parseInt).min(Integer::compareTo).get();
        System.out.println(listFF);
        saveScreenshot();
        String carMin = driver.findElement(
                By.xpath(String.format(baseString, format("%,d", listFF).replaceAll(",", " ")))).getText();
        return carMin;
    }

    private void saveScreenshot()
    {
        File screenCapture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/" + getCurrentTimeAsString() + ".png"));
        }
        catch (IOException e)
        {
            e.getLocalizedMessage();
        }
    }

    private String getCurrentTimeAsString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}

