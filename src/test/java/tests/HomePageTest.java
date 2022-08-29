package tests;

import Pages.PopularItemsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class HomePageTest extends BaseTests {

    private PopularItemsPage popularItemsPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        popularItemsPage = new PopularItemsPage(driver);
    }

    @Test
    public void shouldSeePopularItemsOnHomePage() {

        List<String> productNames = popularItemsPage.getProductNames();
        List<String> productsWithEmptyName = productNames.stream()
                .filter(productName -> productName.isEmpty())
                .collect(Collectors.toList());
        assertThat(productsWithEmptyName).isEmpty();
    }


}
