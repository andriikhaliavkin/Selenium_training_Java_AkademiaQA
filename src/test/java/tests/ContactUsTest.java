package tests;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.time.Duration;
import static org.assertj.core.api.Assertions.assertThat;

public class ContactUsTest extends BaseTests {


    @Test
    public void shouldNotAllowToSendEmptyContactUsForm() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("Contact us")).click();
        driver.findElement(By.id("submitMessage")).click();
        assertThat(driver.findElement(By.className("alert-danger")).isDisplayed()).isTrue();
    }

    @Test
    public void shouldNotAllowToSendContactUsFormWithOnlyEmail() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("Contact us")).click();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("submitMessage")).click();
        assertThat(driver.findElement(By.className("alert-danger")).isDisplayed()).isTrue();
    }
}
