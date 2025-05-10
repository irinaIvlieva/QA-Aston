import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//h2[contains(., 'Онлайн пополнение')]")
    private WebElement pageTitle;

    @FindBy(id = "pay")
    private WebElement paymentTypeSelect;

    @FindBy(id = "connection-phone")
    private WebElement connectionPhoneInput;

    @FindBy(id = "connection-sum")
    private WebElement connectionSumInput;

    @FindBy(id = "connection-email")
    private WebElement connectionEmailInput;

    @FindBy(xpath = "//form[@id='pay-connection']//button[@type='submit']")
    private WebElement connectionSubmitButton;

    @FindBy(id = "internet-phone")
    private WebElement internetPhoneInput;

    @FindBy(id = "internet-sum")
    private WebElement internetSumInput;

    @FindBy(id = "internet-email")
    private WebElement internetEmailInput;

    @FindBy(id = "score-instalment")
    private WebElement instalmentAccountInput;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSumInput;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmailInput;

    @FindBy(id = "score-arrears")
    private WebElement arrearsAccountInput;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSumInput;

    @FindBy(id = "arrears-email")
    private WebElement arrearsEmailInput;

    @FindBy(css = ".pay__partners li img")
    private java.util.List<WebElement> paymentSystemLogos;

    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement detailsLink;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText().replace("\n", " ").replaceAll("\\s+", " ").trim();
    }

    public void selectPaymentType(String type) {
        new Select(paymentTypeSelect).selectByVisibleText(type);
    }

    public void fillConnectionForm(String phone, String sum, String email) {
        connectionPhoneInput.sendKeys(phone);
        connectionSumInput.sendKeys(sum);
        connectionEmailInput.sendKeys(email);
    }

    public void submitConnectionForm() {
        connectionSubmitButton.click();
    }

    public String getConnectionPhonePlaceholder() {
        return connectionPhoneInput.getAttribute("placeholder");
    }

    public String getConnectionSumPlaceholder() {
        return connectionSumInput.getAttribute("placeholder");
    }

    public String getConnectionEmailPlaceholder() {
        return connectionEmailInput.getAttribute("placeholder");
    }

    public String getInternetPhonePlaceholder() {
        return internetPhoneInput.getAttribute("placeholder");
    }

    public String getInternetSumPlaceholder() {
        return internetSumInput.getAttribute("placeholder");
    }

    public String getInternetEmailPlaceholder() {
        return internetEmailInput.getAttribute("placeholder");
    }

    public String getInstalmentAccountPlaceholder() {
        return instalmentAccountInput.getAttribute("placeholder");
    }

    public String getInstalmentSumPlaceholder() {
        return instalmentSumInput.getAttribute("placeholder");
    }

    public String getInstalmentEmailPlaceholder() {
        return instalmentEmailInput.getAttribute("placeholder");
    }

    public String getArrearsAccountPlaceholder() {
        return arrearsAccountInput.getAttribute("placeholder");
    }

    public String getArrearsSumPlaceholder() {
        return arrearsSumInput.getAttribute("placeholder");
    }

    public String getArrearsEmailPlaceholder() {
        return arrearsEmailInput.getAttribute("placeholder");
    }

    public int getPaymentSystemLogosCount() {
        return paymentSystemLogos.size();
    }

    public boolean isPaymentSystemLogoDisplayed(int index) {
        return paymentSystemLogos.get(index).isDisplayed();
    }

    public String getDetailsLinkHref() {
        return detailsLink.getAttribute("href");
    }

    public boolean isDetailsLinkDisplayed() {
        return detailsLink.isDisplayed();
    }
}