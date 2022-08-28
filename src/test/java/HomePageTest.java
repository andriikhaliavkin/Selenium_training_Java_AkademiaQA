import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageTest {

    private WebDriver driver; // komunikacja z przeglądarką
    private WebElement elements; // obsługa elenentów na stronie

    // uruchomi się przed wszystkimi testami
    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    // uruchomi się przed każdym testem
    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
    }
    // uruchomi się po każdym teście
    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldReturnCorrectPageTitle() {
        driver.get("http://automationpractice.com/index.php");
        Assertions.assertThat(driver.getTitle()).isEqualTo("My Store");
        System.out.println(driver.getTitle());
    }

    @Test
    public void shouldSeePopularItemsOnHomePage() {
        driver.get("http://automationpractice.com/index.php");
        List<WebElement> productNames = driver.findElements(By.cssSelector("#homefeatured .product-name"));

        List<WebElement> productsWithEmpyName = productNames.stream()
                .filter(productName -> productName.getText().isEmpty())
                .collect(Collectors.toList());
        Assertions.assertThat(productsWithEmpyName).isEmpty();
    }


}
