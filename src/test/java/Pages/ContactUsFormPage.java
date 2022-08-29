package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsFormPage {

    private WebDriver wait;
    public ContactUsFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "submitMessage")
    WebElement submitMessageButton;

    @FindBy(className = "alert-danger")
    WebElement alertDanger;

    public void clickSubmitMessageButton() {
        submitMessageButton.click();
    }

    public boolean isAlertDangerDisplayed() {

        boolean isDisplayed = false;
        try {
            isDisplayed = alertDanger.isDisplayed();
        } catch (NoSuchElementException e) { }
        return isDisplayed;
    }


}
