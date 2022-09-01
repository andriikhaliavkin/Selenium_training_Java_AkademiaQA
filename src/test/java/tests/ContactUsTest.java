package tests;


import Pages.ContactUsFormPage;
import Pages.TopMenuPage;
import enums.MessageSubject;
import model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        topMenuPage.clickContactUsLink();
        contactUsFormPage.clickSubmitMessageButton();
        assertThat(contactUsFormPage.isAlertDangerDisplayed()).isTrue();
    }

    @Test
    public void shouldNotAllowToSendContactUsFormWithOnlyEmail() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        topMenuPage.clickContactUsLink();
        contactUsFormPage.enterEmail("test@test.com");
        contactUsFormPage.clickSubmitMessageButton();
        assertThat(contactUsFormPage.isAlertDangerDisplayed()).isTrue();
    }

    @Test
    public void shouldSendContactUsFromWithValidData() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        topMenuPage.clickContactUsLink();

        Message message = new Message();
        message.setSubject(MessageSubject.CUSTOMER_SERVICE);
        message.setEmail("test@test.com");
        message.setOrderReference("12345");
        message.setMessage("Test message");

        contactUsFormPage.sendContactUsForm(message);

        assertThat(contactUsFormPage.isGreenAlertBoxDisplayed()).isTrue();
    }



}
