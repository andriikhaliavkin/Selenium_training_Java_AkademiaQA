import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void test() {

    }


}
