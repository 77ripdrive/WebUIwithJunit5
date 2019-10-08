package example.webUI;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckFindCarMinPriceMazda extends BaseTest
{
    @ParameterizedTest
    @ValueSource(strings = {"https://cars.av.by/mazda"})
    public void findCarWithMinPrice(String imput)
    {
        String carWithMinPriceSiteSort = mainPage.openPage(imput).findCarWithButtonSortOnPage();
        String carWithMinPriceFromPage = mainPage.findCarWithMinPriceFromPage();

        assertEquals(carWithMinPriceSiteSort, carWithMinPriceFromPage);
    }
}
