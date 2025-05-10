import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lesson_16 {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPaymentBlockTitle() {
        Assertions.assertEquals("Онлайн пополнение без комиссии", mainPage.getPageTitle());
    }

    @Test
    public void testPaymentSystemLogos() {
        Assertions.assertEquals(5, mainPage.getPaymentSystemLogosCount(),
                "Должно быть 5 логотипов платёжных систем");

        for (int i = 0; i < mainPage.getPaymentSystemLogosCount(); i++) {
            Assertions.assertTrue(mainPage.isPaymentSystemLogoDisplayed(i),
                    "Логотип должен отображаться");
        }
    }

    @Test
    public void testDetailsLink() {
        Assertions.assertTrue(mainPage.isDetailsLinkDisplayed(),
                "Ссылка должна отображаться");

        Assertions.assertTrue(mainPage.getDetailsLinkHref().contains(
                        "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Ссылка должна вести на правильную страницу");
    }

    @Test
    public void testPaymentFormPlaceholders() {
        Assertions.assertEquals("Номер телефона", mainPage.getConnectionPhonePlaceholder());
        Assertions.assertEquals("Сумма", mainPage.getConnectionSumPlaceholder());
        Assertions.assertEquals("E-mail для отправки чека", mainPage.getConnectionEmailPlaceholder());

        mainPage.selectPaymentType("Домашний интернет");
        Assertions.assertEquals("Номер абонента", mainPage.getInternetPhonePlaceholder());
        Assertions.assertEquals("Сумма", mainPage.getInternetSumPlaceholder());
        Assertions.assertEquals("E-mail для отправки чека", mainPage.getInternetEmailPlaceholder());

        mainPage.selectPaymentType("Рассрочка");
        Assertions.assertEquals("Номер счета на 44", mainPage.getInstalmentAccountPlaceholder());
        Assertions.assertEquals("Сумма", mainPage.getInstalmentSumPlaceholder());
        Assertions.assertEquals("E-mail для отправки чека", mainPage.getInstalmentEmailPlaceholder());

        mainPage.selectPaymentType("Задолженность");
        Assertions.assertEquals("Номер счета на 2073", mainPage.getArrearsAccountPlaceholder());
        Assertions.assertEquals("Сумма", mainPage.getArrearsSumPlaceholder());
        Assertions.assertEquals("E-mail для отправки чека", mainPage.getArrearsEmailPlaceholder());
    }

    @Test
    public void testConnectionPaymentFlow() {
        mainPage.fillConnectionForm("297777777", "10", "test@example.com");
        mainPage.submitConnectionForm();
    }
}