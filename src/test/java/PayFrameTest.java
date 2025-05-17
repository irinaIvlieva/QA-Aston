import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Платежная система MTS")
@Feature("Окно ввода реквизитов карты")
@DisplayName("Проверка окна ввода реквизитов карты")
public class PayFrameTest {
    public static WebDriver driver;
    public static MtsHomePage mtsHomePage;
    public static PayFrame payFrame;
    public static final String PAGE_URL = "https://mts.by";
    public static final String TEST_PHONE_NUMBER = "297777777";
    public static final String TEST_SUM = "10.00";

    @BeforeAll
    @Step("Настройка тестового окружения")
    static void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mtsHomePage = new MtsHomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        mtsHomePage.clickCookieCancelBtn();
        mtsHomePage.setConnectionPhone(TEST_PHONE_NUMBER);
        mtsHomePage.setСonnectionSum(TEST_SUM);
        mtsHomePage.clickPayBtn();
        payFrame = new PayFrame(driver, mtsHomePage.payFrame);
    }

    @AfterAll
    @Step("Завершение тестов и закрытие браузера")
    static void after() {
        driver.quit();
    }

    @Test
    @DisplayName("Сумма в заголовке")
    @Description("Проверка корректности отображения суммы в заголовке платежного окна")
    @Severity(SeverityLevel.CRITICAL)
    void descriptionCost() {
        String name = "Текст описания суммы в заголовке";
        String actualValue = payFrame.getPayFrameDescriptionCost();
        assertEquals(TEST_SUM + " BYN", actualValue, name + " не совпадает");
    }

    @Test
    @DisplayName("Текст кнопки оплаты")
    @Description("Проверка корректности текста на кнопке оплаты")
    @Severity(SeverityLevel.CRITICAL)
    void btnText() {
        String name = "Текст кнопки";
        String actualValue = payFrame.getPayFrameBtnText();
        assertEquals("Оплатить " + TEST_SUM + " BYN", actualValue, name + " не совпадает");
    }

    @Test
    @DisplayName("Номер телефона в заголовке")
    @Description("Проверка корректности отображения номера телефона в заголовке платежного окна")
    @Severity(SeverityLevel.CRITICAL)
    void descriptionPhone() {
        String name = "Номер телефона в заголовке";
        String actualValue = payFrame.getPayFrameDescriptionPhone();
        assertEquals("Оплата: Услуги связи Номер:375" + TEST_PHONE_NUMBER, actualValue, name + " не совпадает");
    }

    @ParameterizedTest
    @DisplayName("Картинки платежных систем")
    @Description("Проверка отображения логотипов поддерживаемых платежных систем")
    @Severity(SeverityLevel.NORMAL)
    @ValueSource(strings = {"mastercard-system.svg", "visa-system.svg", "belkart-system.svg", "mir-system-ru.svg", "maestro-system.svg"})
    void payPics(String src) {
        assertTrue(payFrame.isDisplayedImg(src), "Картинка " + src + " не отображается");
    }

    @ParameterizedTest
    @DisplayName("Плейсхолдеры реквизитов карты")
    @Description("Проверка корректности плейсхолдеров полей ввода реквизитов карты")
    @Severity(SeverityLevel.NORMAL)
    @CsvSource({
            "Поле ввода номера карты, Номер карты",
            "Поле ввода срока действия карты, Срок действия",
            "Поле ввода CVC, CVC",
            "Поле ввода имени держателя, Имя и фамилия на карте"})
    void checkPlaceholders(String name, String expectedPlaceholder) {
        String actualPlaceholder = "";
        switch (name) {
            case ("Поле ввода номера карты"):
                actualPlaceholder = payFrame.getCreditCardPlaceholder();
                break;
            case ("Поле ввода срока действия карты"):
                actualPlaceholder = payFrame.getExpirationDatePlaceholder();
                break;
            case ("Поле ввода CVC"):
                actualPlaceholder = payFrame.getCvcPlaceholder();
                break;
            case ("Поле ввода имени держателя"):
                actualPlaceholder = payFrame.getCardHolderPlaceholder();
                break;
        }
        assertEquals(expectedPlaceholder, actualPlaceholder, name + " не совпадает");
    }
}
