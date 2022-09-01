package Pages;

import model.Message;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(id = "id_contact")
    WebElement subjectSelect;

    @FindBy(id = "id_order")
    WebElement orderReferenceInput;

    @FindBy(id = "message")
    WebElement messageInput;

    @FindBy(className = "alert-success")
    WebElement alertSuccess;

    public void clickSubmitMessageButton() {
        submitMessageButton.click();
    }

    public boolean isAlertDangerDisplayed() {
        return isAlertBoxDisplayed(alertDanger);
    }

    public boolean isGreenAlertBoxDisplayed() {
        return isAlertBoxDisplayed(alertSuccess);
    }

    private boolean isAlertBoxDisplayed(WebElement alertBox) {

        boolean isDisplayed = false;
        try {
            isDisplayed = alertBox.isDisplayed();
        } catch (NoSuchElementException e) { }
        return isDisplayed;
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void sendContactUsForm(Message message) {
        Select select = new Select(subjectSelect);
        select.selectByVisibleText(message.getSubject().getSubject());
        emailInput.sendKeys(message.getEmail());
        orderReferenceInput.sendKeys(message.getOrderReference());
        messageInput.sendKeys(message.getMessage());
        submitMessageButton.click();



    }

}
