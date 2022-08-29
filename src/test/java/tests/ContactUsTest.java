package tests;


import Pages.ContactUsFormPage;
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
    private ContactUsFormPage contactUsFormPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        contactUsFormPage = new ContactUsFormPage(driver);

    }

    @Test
    public void shouldNotAllowToSendEmptyContactUsForm() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        topMenuPage.clickContactUsLink();
        contactUsFormPage.clickSubmitMessageButton();
        assertThat(driver.findElement(By.className("alert-danger")).isDisplayed()).isTrue();
    }

    @Test
    public void shouldNotAllowToSendContactUsFormWithOnlyEmail() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        topMenuPage.clickContactUsLink();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        contactUsFormPage.clickSubmitMessageButton();
        assertThat(driver.findElement(By.className("alert-danger")).isDisplayed()).isTrue();
    }
}
