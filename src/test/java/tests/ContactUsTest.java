package tests;


import Pages.PopularItemsPage;
import Pages.TopMenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PageTitleUtils;

import java.time.Duration;
import static org.assertj.core.api.Assertions.assertThat;

public class ContactUsTest extends BaseTests {

    private TopMenuPage topMenuPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
    }

    @Test
    public void shouldNotAllowToSendEmptyContactUsForm() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        topMenuPage.clickContactUsLink();
        driver.findElement(By.id("submitMessage")).click();
        assertThat(driver.findElement(By.className("alert-danger")).isDisplayed()).isTrue();
    }

    @Test
    public void shouldNotAllowToSendContactUsFormWithOnlyEmail() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        topMenuPage.clickContactUsLink();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("submitMessage")).click();
        assertThat(driver.findElement(By.className("alert-danger")).isDisplayed()).isTrue();
    }
}
