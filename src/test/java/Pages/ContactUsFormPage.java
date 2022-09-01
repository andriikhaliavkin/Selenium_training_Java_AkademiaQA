package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsFormPage extends BasePage {

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitMessage")
    WebElement submitMessageButton;

    @FindBy(className = "alert-danger")
    WebElement alertDanger;

    @FindBy(id = "email")
    WebElement emailInput;

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

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }


}
