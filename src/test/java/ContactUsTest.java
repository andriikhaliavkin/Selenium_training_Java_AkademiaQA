import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactUsTest {

    private WebDriver driver; // komunikacja z przeglądarką
    private WebElement elements;

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
    public void shouldNotAllowToSendEmptyContactUsForm() {

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Contact us")).click();
        driver.findElement(By.id("submitMessage")).click();
        assertThat(driver.findElement(By.className("alert-danger")).isDisplayed()).isTrue();
    }
}
