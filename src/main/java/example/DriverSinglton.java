package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSinglton
{
    private final static ThreadLocal<WebDriver> driver= new ThreadLocal<>();

    private DriverSinglton()
    {
    }

    public static void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }
    public static WebDriver getDriver()
    {
        driver.get().manage().window().maximize();



        return driver.get();
    }

    public static void closeDriver()
    {
        driver.get().quit();
        driver.remove();
    }

}


