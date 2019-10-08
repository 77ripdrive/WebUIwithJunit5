package example.webUI;

import example.DriverSetup;
import example.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;

@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeEach
    public void setUp() {

        DriverSetup.setDriver("chrome");
        driver = DriverSetup.getDriver();
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void stopBrowser() {
        DriverSetup.closeDriver();
    }

}
