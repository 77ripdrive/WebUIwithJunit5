package example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {
    private final static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverSetup() {
    }

     public static void setUp(String browser) {
       
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications", "--disable-popup-blocking", "–disable-infobars");
                driver.set(new ChromeDriver(options));
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-notifications", "--disable-popup-blocking", "–disable-infobars");
                driver.set(new FirefoxDriver(firefoxOptions));
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications", "--disable-popup-blocking", "–disable-infobars");
                driver.set(new EdgeDriver());
            }
        }
    }
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().quit();
        driver.remove();
    }

}


