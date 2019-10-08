package example.webUI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CheckFindCarMinPriceHummer extends BaseTest
{
    @ParameterizedTest
    @ValueSource(strings = {"https://cars.av.by/hummer"})
    public void findCarWithMinPrice(String imput)
    {
        String carWithMinPriceSiteSort = mainPage.openPage(imput).findCarWithButtonSortOnPage();
        String carWithMinPriceFromPage = mainPage.findCarWithMinPriceFromPage();

        assertEquals(carWithMinPriceSiteSort, carWithMinPriceFromPage);
    }
}
