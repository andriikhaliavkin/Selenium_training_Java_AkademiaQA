package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsFormPage {
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


}
