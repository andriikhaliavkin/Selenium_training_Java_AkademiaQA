import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {

    private WebDriver driver; // komunikacja z przeglądarką
    private WebElement element; // obsługa elenentów na stronie

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


}
