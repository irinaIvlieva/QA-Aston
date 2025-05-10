import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentModal {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".payment-modal .payment-sum")
    private WebElement paymentSum;

    @FindBy(css = ".payment-modal .payment-phone")
    private WebElement paymentPhone;

    @FindBy(css = ".payment-modal .card-number")
    private WebElement cardNumberInput;

    @FindBy(css = ".payment-modal .card-expiry")
    private WebElement cardExpiryInput;

    @FindBy(css = ".payment-modal .card-cvc")
    private WebElement cardCvcInput;

    @FindBy(css = ".payment-modal .submit-button")
    private WebElement submitButton;

    @FindBy(css = ".payment-modal .payment-system-icons img")
    private java.util.List<WebElement> paymentSystemIcons;

    public PaymentModal(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getPaymentSum() {
        return paymentSum.getText();
    }

    public String getSubmitButtonSum() {
        return submitButton.getText();
    }

    public String getPaymentPhone() {
        return paymentPhone.getText();
    }

    public String getCardNumberPlaceholder() {
        return cardNumberInput.getAttribute("placeholder");
    }

    public String getCardExpiryPlaceholder() {
        return cardExpiryInput.getAttribute("placeholder");
    }

    public String getCardCvcPlaceholder() {
        return cardCvcInput.getAttribute("placeholder");
    }

    public int getPaymentSystemIconsCount() {
        return paymentSystemIcons.size();
    }

    public void waitForModalVisible() {
        wait.until(ExpectedConditions.visibilityOf(paymentSum));
    }
}
